import { html, render } from '../api/lib.js';
import { deleteShoe } from '../api/pair.js';
import { getUserData } from '../api/session.js';
import { editPage } from './editPage.js';


const template = (imageUrl, brand, model, release, designer, value) => html`

        <!-- Details page -->
        <section id="details">
          <div id="details-wrapper">
            <p id="details-title">Shoe Details</p>
            <div id="img-wrapper">
              <img src="${imageUrl}" alt="example1" />
            </div>
            <div id="info-wrapper">
              <p>Brand: <span id="details-brand">${brand}</span></p>
              <p>
                Model: <span id="details-model">${model}</span>
              </p>
              <p>Release date: <span id="details-release">${release}</span></p>
              <p>Designer: <span id="details-designer">${designer}</span></p>
              <p>Value: <span id="details-value">${value}</span></p>
            </div>
        
             <div id="action-buttons">
            </div> 
          </div>
        </section>
`;

export function detailsView(shoe) {
  render(template(shoe.imageUrl, shoe.brand, shoe.model, shoe.release, shoe.designer, shoe.value), document.querySelector('main'));
  const actionButtons = document.querySelector('#action-buttons');

  const editButton = document.createElement('a');
  editButton.href = 'javascript:void(0)';
  editButton.id = 'edit-btn'
  editButton.textContent = 'Edit';



  const deleteButton = document.createElement('a');
  deleteButton.href = 'javascript:void(0)';
  deleteButton.id = 'delete-btn'
  deleteButton.textContent = 'Delete';

  if (getUserData() != null) {
    if (getUserData()._id == shoe._ownerId) {
      actionButtons.appendChild(editButton);
      actionButtons.appendChild(deleteButton);
    }
  }

  deleteButton.addEventListener('click', () => {
    if (confirm('Press ok to delete this shoe!')) {
      deleteShoe(shoe._id);
    }
  });

  editButton.addEventListener('click', () => {
    editPage(shoe);
  });
};
