import { getMyBooks } from '../api/book.js';
import { html, render } from '../api/lib.js';
import { detailsView } from './detailsView.js';


const template = () => html`
<!-- My Books Page ( Only for logged-in users ) -->
<section id="my-books-page" class="my-books">
    <h1>My Books</h1>
    
    <!-- Display ul: with list-items for every user's books (if any) -->

</section>
`;

const newBook = (title,type,imageUrl) => html`
    <h3>${title}</h3>
    <p>Type: ${type}</p>
    <p class="img"><img src="${imageUrl}"></p>
    <a class="button" href="javascript:void(0)">Details</a>
`;

export async function myBooksView() {
    render(template(), document.querySelector('#site-content'));

    const myBooks = await getMyBooks();
    const myBooksPage = document.querySelector('#my-books-page');


    if(myBooks.length >0){
        document.querySelector('.my-books-list')?.remove();

        const ul = document.createElement('ul');
        ul.className = 'my-books-list';

        myBooks.forEach(a=>{
            const li = document.createElement('li');
            li.className = 'otherBooks';
            render(newBook(a.title,a.type,a.imageUrl),li);
            ul.appendChild(li);

            li.querySelector('.button').addEventListener('click', ()=>detailsView(a._id));
        });

        myBooksPage.appendChild(ul);
    }else{
        document.querySelector('.no-books')?.remove();
        const p = document.createElement('p');
        p.className = 'no-books';
        p.textContent = 'No books in database!';

        myBooksPage.appendChild(p);
    }
};