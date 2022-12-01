import { page } from './api/lib.js';
import { views, update } from './api/views.js'; 

page('/', () => views.home());
page('/login', () => views.login());
page('/logout', () => views.logout());
page('/register', () => views.register());
page('/create-game', () => views.createGame());
page('/all-games', () => views.allGames())

page.start()

update();