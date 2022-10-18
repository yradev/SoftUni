window.addEventListener("load", solve);

function solve() {
  document.querySelector('#publish-btn').addEventListener('click', () => {
    
    const title = document.querySelector('#post-title');
    const category = document.querySelector('#post-category');
    const content = document.querySelector('#post-content');


    if(title.value == '' || category.value == '' || content.value == ''){
      title.value = '';
      return;
    }

    const ul = document.querySelector('#review-list');

    const li = document.createElement('li');
    li.className = 'rpost';
    const article = document.createElement('article');


    article.innerHTML = `
    <h4>${title.value}</h4>
    <p>Category: ${category.value}</p>
    <p>Content: ${content.value}</p>
    `;

    li.appendChild(article);
    const editButton = document.createElement('button');
    editButton.type = 'button';
    editButton.className = 'action-btn edit';
    editButton.textContent = 'Edit';
    li.appendChild(editButton);

    const approveButton = document.createElement('button');
    approveButton.type = 'button';
    approveButton.className = 'action-btn approve';
    approveButton.textContent = 'Approve';
    li.appendChild(approveButton);

    ul.appendChild(li);


    title.value = '';
    category.value = '';
    content.value = '';

    editButton.addEventListener('click', (event) => {
      const currTarget = event.currentTarget.parentElement;

      title.value = currTarget.querySelector('h4').textContent;
      category.value = currTarget.querySelectorAll('p')[0].textContent.replace('Category: ','');
      content.value = currTarget.querySelectorAll('p')[1].textContent.replace('Content: ','');

      ul.removeChild(currTarget);
    });

    approveButton.addEventListener('click', (event) =>{
      const currTarget = event.currentTarget.parentElement;

      currTarget.removeChild(currTarget.querySelector('button'));
      currTarget.removeChild(currTarget.querySelector('button'));

      const publishedList = document.querySelector('#published-list');

      publishedList.appendChild(currTarget);

    });
  });
  
  document.querySelector('#clear-btn').addEventListener('click', ()=>{
    const publList = document.querySelector('#published-list');

    for(let index = 0; index<=publList.children.length;index++){
      publList.removeChild(publList.firstChild);
    }
   
  })
};
