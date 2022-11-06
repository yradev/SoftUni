import { page } from './api/lib.js';
import { views, update } from './api/navigation.js'; 

// Navigation
page('/', () => views.home());
page('/login', () => views.login());
page('/logout', () => views.logout());
page('/register', () => views.register());
page('/posts/create', () => views.createPost());
page('/posts/details/:id', (data) => views.postDetails(data));
page('/posts/edit/:id', (data) => views.postEdit(data));
page('/my-posts', () => views.myPosts());


page.start()

update();