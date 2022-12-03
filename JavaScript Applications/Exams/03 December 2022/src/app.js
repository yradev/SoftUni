import { page } from './api/lib.js';
import { views, update } from './api/views.js'; 

page('/', () => views.home());
page('/login', () => views.login());
page('/logout', () => views.logout());
page('/register', () => views.register());
page('/add-album', () => views.addAlbum());
page('/dashboard', () => views.dashboard());

page.start()

update();