
import { getOffers } from '../api/offers.js';
import { html, render } from '../api/lib.js';
import { detailsView } from './details.js';


const template = () => html`
<!-- Dashboard page -->
<section id="dashboard">
  <h2>Job Offers</h2>
  <div id='offers'></div>
</section>
`;

const newOffer = (title, salary) => html`
    <img src="./images/example1.png" alt="example1" />
    <p>
      <strong>Title: </strong><span class="title">${title}</span>
    </p>
    <p><strong>Salary:</strong><span class="salary">${salary}</span></p>
  `

export async function dashBoardView() {

  render(template(), document.querySelector('main'));
  const dashboard = document.querySelector('#dashboard');
  const offers = await getOffers();
  const domOffers = document.querySelectorAll('.offer');

  if (domOffers.length > 0) {
    domOffers.forEach(a => dashboard.removeChild(a));
  }

  if (offers.length > 0) {

    offers.forEach(a => {
      const div = document.createElement('div');
      div.className = 'offer';
      render(newOffer(a.title, a.salary), div)

      const details = document.createElement('a');
      details.textContent = 'Details';
      details.setAttribute('class', 'details-btn');
      details.setAttribute('href', 'javascript:void(0)');
      div.appendChild(details);

      dashboard.appendChild(div);

      details.addEventListener('click',()=>{
        detailsView(a);
      })


    });
  } else {
    const noOffers = document.createElement('h2');
    noOffers.textContent='No offers yet.';
    dashboard.appendChild(noOffers);
  }
};