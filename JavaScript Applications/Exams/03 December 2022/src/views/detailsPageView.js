import { amILiked, deleteAlbum, getAlbumById, getLikes, newLike } from '../api/album.js';
import { html, render } from '../api/lib.js';
import { amICreator, getUserData } from '../api/session.js';
import { editPageView } from './editPageView.js';


const template = (imageUrl, singer, album, release, label, sales, likes) => html`
<!-- Details page -->
<section id="details">
  <div id="details-wrapper">
    <p id="details-title">Album Details</p>
    <div id="img-wrapper">
      <img src="${imageUrl}" alt="example1" />
    </div>
    <div id="info-wrapper">
      <p><strong>Band:</strong><span id="details-singer">${singer}</span></p>
      <p>
        <strong>Album name:</strong><span id="details-album">${album}</span>
      </p>
      <p><strong>Release date:</strong><span id="details-release">${release}</span></p>
      <p><strong>Label:</strong><span id="details-label">${label}</span></p>
      <p><strong>Sales:</strong><span id="details-sales">${sales}</span></p>
    </div>
    <div id="likes">Likes: <span id="likes-count">${likes}</span></div>
  </div>
</section>
`;

const ownerButtons = () => html`
  <a href="javascript:void(0)" id="edit-btn">Edit</a>
  <a href="javascript:void(0)" id="delete-btn">Delete</a>
`;

const likeButton = () => html`
  <a href="javascript:void(0)" id="like-btn">Like</a>
`;
export async function detailsPageView(id) {
  const album = await getAlbumById(id);
  const likes = await getLikes(id);
  
  render(template(album.imageUrl, album.singer, album.album, album.release, album.label, album.sales, likes), document.querySelector('main'));

  const detailsWrapper = document.querySelector('#details-wrapper');
  if (getUserData() != null) {
    const actionButtons = document.createElement('div');
    actionButtons.id = 'action-buttons';

    if (amICreator(album._ownerId)) {
      render(ownerButtons(), actionButtons);
      detailsWrapper.appendChild(actionButtons);

      document.querySelector('#edit-btn').addEventListener('click', () => editPageView(album));
      document.querySelector('#delete-btn').addEventListener('click', () => {
        if (confirm('Press ok to delete this album!')) {
          deleteAlbum(album._id);
        }
      });
    } else {

      if (!await (amILiked(album._id))) {
        render(likeButton(), actionButtons);

        detailsWrapper.appendChild(actionButtons);

        document.querySelector('#like-btn').addEventListener('click', () => {
          newLike(album._id);
          document.querySelector('#like-btn').remove();
        });
      }
    }
  };
};