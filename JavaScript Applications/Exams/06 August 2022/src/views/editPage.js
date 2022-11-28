import { html, render } from '../api/lib.js';
import { changeOfferValues } from '../api/offers.js';


const template = (title,imageUrl, category, description, requirements, salary) => html`

        <!-- Edit Page (Only for logged-in users) -->
        <section id="edit">
          <div class="form">
            <h2>Edit Offer</h2>
            <form class="edit-form">
              <input
                type="text"
                name="title"
                id="job-title"
                placeholder="Title"
                value="${title}"
              />
              <input
                type="text"
                name="imageUrl"
                id="job-logo"
                placeholder="Company logo url"
                value="${imageUrl}" 
              />
              <input
                type="text"
                name="category"
                id="job-category"
                placeholder="Category"
                value="${category}"
              />
              <textarea
                id="job-description"
                name="description"
                placeholder="Description"
                rows="4"
                cols="50"
              >${description}</textarea>
              <textarea
                id="job-requirements"
                name="requirements"
                placeholder="Requirements"
                rows="4"
                cols="50"
              >${requirements}</textarea>
              <input
                type="text"
                name="salary"
                id="job-salary"
                placeholder="Salary"
                value="${salary}"
              />

              <button type="submit">post</button>
            </form>
          </div>
        </section>
`;

export function editOfferView(details){
    render(
      template(details.title,details.imageUrl,details.category,details.description,details.requirements,details.salary),
      document.querySelector('main'));

      document.querySelector('.edit-form').addEventListener('submit', (event)=>{
        event.preventDefault();
        const formData = new FormData(event.target);

        const options = {
          title:formData.get('title'),
          imageUrl: formData.get('imageUrl'),
          category: formData.get('category'),
          description: formData.get('description'),
          requirements: formData.get('requirements'),
          salary: formData.get('salary')
        };

        changeOfferValues(details._id,options);
      });
};