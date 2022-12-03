import { html, render } from '../api/lib.js';
import { getShoe } from '../api/pair.js';
import { getUserData } from '../api/session.js';


const template = () => html`

        <!-- Search Page (Only for logged-in users) -->
        <section id="search">
          <h2>Search by Brand</h2>

          <form class="search-wrapper cf">
            <input
              id="search-input"
              type="text"
              name="search"
              placeholder="Search here..."
              required
            />
            <button type="submit">Search</button>
          </form>

          <h3>Results:</h3>

          <div id="search-container">
            <ul style="display:none" class="card-wrapper">
            </ul>

            <!-- Display an h2 if there are no posts -->
             <h2  id='no-result' style="display:none">There are no results found.</h2> 
          </div>
        </section>
`;

const newResult = (imageUrl,brand,model,value) => html`
                <img src="${imageUrl}" alt="travis" />
                <p>
                  <strong>Brand: </strong><span class="brand">${brand}</span>
                </p>
                <p>
                  <strong>Model: </strong
                  ><span class="model">${model}</span>
                </p>
                <p><strong>Value:</strong><span class="value">${value}</span>$</p>
                <a class="details-btn" href="javascript:void(0)">Details</a>
`;
export function searchView() {
    render(template(), document.querySelector('main'));

    document.querySelector('.search-wrapper').addEventListener('submit', async (event)=>{
      event.preventDefault();
      const formData = new FormData(event.target);
      const getShoes = await getShoe(formData.get('search'))

      if(getShoes.length>0){
         document.querySelector('#no-result').style.display = 'none';
        const cardWrapper = document.querySelector('.card-wrapper');
        cardWrapper.style.display = '';

        getShoes.forEach(a=>{
          const div = document.createElement('li');
          div.className = 'card';
    
          render(newResult(a.imageUrl,a.brand,a.model,a.value),div);
    
          cardWrapper.appendChild(div);

          if(getUserData()==null){
            document.querySelector('.details-btn').style.display = 'none';
          }
          
          div.querySelector('.details-btn').addEventListener('click',()=>{
            detailsView(a);
          });
        });
      }else{
        document.querySelector('#no-result').style.display = '';
        document.querySelector('.card-wrapper').style.display = 'none';
      }
    })
};