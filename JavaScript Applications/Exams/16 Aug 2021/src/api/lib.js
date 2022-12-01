import { html, render } from '../../node_modules/lit-html/lit-html.js';
import page from '../../node_modules/page/page.mjs';

export {
    html,
    render,
    page
}

export function updateChildrens(parent) {
    const count =  parent.childElementCount;
    if (count > 1) {
        for (let index = 1; index < count; index++) {
            parent.removeChild(parent.lastChild);
        }
    }
}