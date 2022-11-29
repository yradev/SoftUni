import { html, render } from '../api/lib.js';
import { createPair } from '../api/pair.js';


const template = () => html`

        <!-- Create Page (Only for logged-in users) -->
        <section id="create">
          <div class="form">
            <h2>Add item</h2>
            <form class="create-form">
              <input
                type="text"
                name="brand"
                id="shoe-brand"
                placeholder="Brand"
              />
              <input
                type="text"
                name="model"
                id="shoe-model"
                placeholder="Model"
              />
              <input
                type="text"
                name="imageUrl"
                id="shoe-img"
                placeholder="Image url"
              />
              <input
                type="text"
                name="release"
                id="shoe-release"
                placeholder="Release date"
              />
              <input
                type="text"
                name="designer"
                id="shoe-designer"
                placeholder="Designer"
              />
              <input
                type="text"
                name="value"
                id="shoe-value"
                placeholder="Value"
              />

              <button type="submit">post</button>
            </form>
          </div>
</section>
`;

export function createPageView(){
    render(template(),document.querySelector('main'));

    document.querySelector('.create-form').addEventListener('submit', (event) =>{
      event.preventDefault();

      const formData = new FormData(event.target);

      const options = {};
      for(const data of formData.entries()){
        options[data[0]] = data[1];
      }

      createPair(options);
    });
};