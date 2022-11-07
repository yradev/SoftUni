import { page } from './api/lib.js';
import { views, update } from './api/views.js'; 


// Navigation
page('/', () => views.home());
page('/dashboard', () => views.dashboard())
page('/login', () => views.login());
page('/logout', () => views.logout());
page('/register', () => views.register());
page('/pet/create-postcard', () => views.createPostcard());
page('/pet/details/:id', (data) => views.petDetails(data));

page.start()

update();