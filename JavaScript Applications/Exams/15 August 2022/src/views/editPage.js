import { html, render } from '../api/lib.js';
import { editPair } from '../api/pair.js';


const template = (brand,model,imageUrl,release,designer,value) => html`

        <!-- Edit Page (Only for logged-in users) -->
        <section id="edit">
          <div class="form">
            <h2>Edit item</h2>
            <form class="edit-form">
              <input
                type="text"
                name="brand"
                id="shoe-brand"
                placeholder="Brand"
                value="${brand}"
              />
              <input
                type="text"
                name="model"
                id="shoe-model"
                placeholder="Model"
                value="${model}"
              />
              <input
                type="text"
                name="imageUrl"
                id="shoe-img"
                placeholder="Image url"
                value="${imageUrl}"
              />
              <input
                type="text"
                name="release"
                id="shoe-release"
                placeholder="Release date"
                value="${release}"
              />
              <input
                type="text"
                name="designer"
                id="shoe-designer"
                placeholder="Designer"
                value="${designer}"
              />
              <input
                type="text"
                name="value"
                id="shoe-value"
                placeholder="Value"
                value="${value}"
              />

              <button type="submit">post</button>
            </form>
          </div>
        </section>
`;

export function editPage(shoe){
    render(template(shoe.brand,shoe.model,shoe.imageUrl,shoe.release,shoe.designer,shoe.value),document.querySelector('main'));

    document.querySelector('.edit-form').addEventListener('submit', (event) =>{
      event.preventDefault();

      const formData = new FormData(event.target);

      const options = {};
      for(const data of formData.entries()){
        options[data[0]] = data[1];
      }

      editPair(shoe._id,options);
    });
};