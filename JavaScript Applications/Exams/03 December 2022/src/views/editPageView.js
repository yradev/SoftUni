import { editAlbum } from '../api/album.js';
import { html, render } from '../api/lib.js';
import { getOptionsFromForms } from '../api/utill.js';


const template = (singer,album,imageUrl,release,label,sales) => html`
<section id="edit">
        <div class="form">
          <h2>Edit Album</h2>
          <form class="edit-form">
            <input type="text" name="singer" id="album-singer" placeholder="Singer/Band" value="${singer}"/>
            <input type="text" name="album" id="album-album" placeholder="Album" value="${album}"/>
            <input type="text" name="imageUrl" id="album-img" placeholder="Image url" value="${imageUrl}"/>
            <input type="text" name="release" id="album-release" placeholder="Release date" value="${release}"/>
            <input type="text" name="label" id="album-label" placeholder="Label" value="${label}"/>
            <input type="text" name="sales" id="album-sales" placeholder="Sales" value="${sales}"/>

            <button type="submit">post</button>
          </form>
        </div>
      </section>
`;

export function editPageView(album){
    render(template(album.singer,album.album,album.imageUrl,album.release,album.label,album.sales),document.querySelector('main'));

    document.querySelector('.edit-form').addEventListener('submit',(event)=>{
      event.preventDefault();

      editAlbum(getOptionsFromForms(event.target),album._id);
  });
    
};