import { html, render } from '../api/lib.js';
import { deleteOffer, isUserApplied, getApplies, applyOffer } from '../api/offers.js';
import { getUserData } from '../api/session.js';
import { editOfferView } from './editPage.js';


const template = (imageUrl, title, category, salary, description, req, applies) => html`

        <!-- Details page -->
        <section id="details">
          <div id="details-wrapper">
            <img id="details-img" src="${imageUrl}" alt="example1" />
            <p id="details-title">${title}</p>
            <p id="details-category">
              Category: <span id="categories">${category}</span>
            </p>
            <p id="details-salary">
              Salary: <span id="salary-number">${salary}</span>
            </p>
            <div id="info-wrapper">
              <div id="details-description">
                <h4>Description</h4>
                <span>${description}</span>
              </div>
              <div id="details-requirements">
                <h4>Requirements</h4>
                <span>${req}</span>
              </div>
            </div>
            <p>Applications: <strong id="applications">${applies}</strong></p>
        
          </div>
        </section>
`;

export async function detailsView(details) {
  const applies = await getApplies(details._id);
  render(template(details.imageUrl, details.title, details.category, details.salary, details.description, details.requirements,applies), document.querySelector('main'));
  const userData = getUserData();
  if (userData != null) {
    const div = document.createElement('div');
    div.id = 'action-buttons';
    if (userData._id == details._ownerId) {

      div.innerHTML = `
      <a href="javascript:void(0)" id="edit-btn">Edit</a>
      <a href="javascript:void(0)" id="delete-btn">Delete</a>
      `;
      document.querySelector('#details-wrapper').appendChild(div);

      document.querySelector('#edit-btn').addEventListener('click', () => {
        editOfferView(details);
      });

      document.querySelector('#delete-btn').addEventListener('click', () => {
        if (confirm('Press ok to delete this offer!')) {
          deleteOffer(details._id);
        }
      });
    } else {
      if (!await isUserApplied(details._id,userData._id)) {
        div.innerHTML = `
      <a href="javascript:void(0)" id="apply-btn">Apply</a>
      `;
        document.querySelector('#details-wrapper').appendChild(div);
        const applyButton = document.querySelector('#apply-btn');
        applyButton.addEventListener('click', async ()=>{
          applyOffer(details._id);
          document.querySelector('#applications').textContent = await getApplies(details._id);
          div.innerHTML = '';
        });
      }
    }
  }
};