import { page } from './api/lib.js';
import { views, update } from './api/views.js'; 

page('/', () => views.home());
page('/login', () => views.login());
page('/logout', () => views.logout());
page('/register', () => views.register());
page('/add-books', () => views.addBooks());
page('/my-books', () => views.mybooks());

page.start()

update();
