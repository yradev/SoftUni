import { html, render } from '../api/lib.js';
import { getAllShoes } from '../api/pair.js';
import { detailsView } from './details.js';


const template = () => html`
<!-- Dashboard page -->
<section id="dashboard">
  <h2>Collectibles</h2>
  <ul class="card-wrapper" style='display:none'>
  </ul>

  <!-- Display an h2 if there are no posts -->
  <h2 id='no-result'style='display:none'>There are no items added yet.</h2>
</section>
`;

const newPair = (imageUrl,brand,model,value) => html`
            <!-- Display a li with information about every post (if any)-->
            <img src="${imageUrl}" alt="travis" />
            <p>
              <strong>Brand: </strong><span class="brand">${brand}</span>
            </p>
            <p>
              <strong>Model: </strong><span class="model">${model}</span>
            </p>
            <p><strong>Value:</strong><span class="value">${value}</span>$</p>
            <a class="details-btn" href="javascript:void(0)">Details</a>
`;

export async function dashboardView() {
  render(template(), document.querySelector('main'));

  const items = await getAllShoes();

  if (items.length > 0) {
    const cardWrapper = document.querySelector('.card-wrapper');
    document.querySelector('#no-result').style.display = 'none';
    cardWrapper.style.display = '';

    items.forEach(a => {
      const div = document.createElement('li');
      div.className = 'card';

      render(newPair(a.imageUrl,a.brand,a.model,a.value),div);

      cardWrapper.appendChild(div);

      div.querySelector('.details-btn').addEventListener('click',()=>{
        detailsView(a);
      });
    });

  } else {
    document.querySelector('#no-result').style.display = '';
    document.querySelector('.card-wrapper').style.display = 'none';;
  }
};