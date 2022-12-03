import { getAlbums } from '../api/album.js';
import { html, render } from '../api/lib.js';
import { detailsPageView } from './detailsPageView.js';


const template = () => html`
<!-- Dashboard page -->
<section id="dashboard">
  <h2>Albums</h2>
</section>
`;

const newAlbum = (imageUrl, singer, album, sales) => html`
    <img src="${imageUrl}" alt="travis" />
    <p>
      <strong>Singer/Band: </strong><span class="singer">${singer}</span>
    </p>
    <p>
      <strong>Album name: </strong><span class="album">${album}</span>
    </p>
    <p><strong>Sales:</strong><span class="sales">${sales}</span></p>
    <a class="details-btn" href="javascript:void(0)">Details</a>
  `;

export async function dashboardView() {
  render(template(), document.querySelector('main'));
  const albums = await getAlbums();

  const dashboard = document.querySelector('#dashboard')

  if (albums.length > 0) {
    document.querySelector('.card-wrapper')?.remove();

    const cardWrapper = document.createElement('ul');
    cardWrapper.className = 'card-wrapper';

    albums.forEach(a => {
      const li = document.createElement('li');
      li.className = 'card';
      render(newAlbum(a.imageUrl, a.singer, a.album, a.sales), li);
      cardWrapper.appendChild(li);

      li.querySelector('.details-btn').addEventListener('click',()=>detailsPageView(a._id));
      
    });

    dashboard.appendChild(cardWrapper);
  } else {
    const h2 = document.createElement('h2');
    h2.textContent='There are no albums added yet.'
    dashboard.appendChild(h2);
  }
};