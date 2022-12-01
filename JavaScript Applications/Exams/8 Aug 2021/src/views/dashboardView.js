import { getAllBooks } from '../api/book.js';
import { html, render } from '../api/lib.js';
import { detailsView } from './detailsView.js';


const template = () => html`
<!-- Dashboard Page ( for Guests and Users ) -->
<section id="dashboard-page" class="dashboard">
    <h1>Dashboard</h1>
    <!-- Display ul: with list-items for All books (If any) -->
    <!-- Display paragraph: If there are no books in the database -->
</section>
`;

const newBook = (title,type,imageUrl) => html`
    <h3>${title}</h3>
    <p>Type: ${type}</p>
    <p class="img"><img src="${imageUrl}"></p>
    <a class="button" href="javascript:void(0)">Details</a>
`;

export async function dashboardView() {
    render(template(), document.querySelector('#site-content'));

    const allBooks = await getAllBooks();
    const dashboard = document.querySelector('#dashboard-page');


    if(allBooks.length >0){
        document.querySelector('.other-books-list')?.remove();

        const ul = document.createElement('ul');
        ul.className = 'other-books-list';

        allBooks.forEach(a=>{
            const li = document.createElement('li');
            li.className = 'otherBooks';
            render(newBook(a.title,a.type,a.imageUrl),li);
            ul.appendChild(li);

            li.querySelector('.button').addEventListener('click', ()=>detailsView(a._id));
        });

     dashboard.appendChild(ul);
    }else{
        document.querySelector('.no-books')?.remove();
        const p = document.createElement('p');
        p.className = 'no-books';
        p.textContent = 'No books in database!';

        dashboard.appendChild(p);
    }
};