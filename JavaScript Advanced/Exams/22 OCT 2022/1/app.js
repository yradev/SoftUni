window.addEventListener("load", solve);
 
function solve() {
 
  const publish = document.querySelector('#form-btn');
  publish.type = 'button';
 
 
  publish.addEventListener('click', () => {
 
    const firstName = document.querySelector('#first-name');
    const lastName = document.querySelector('#last-name');
    const age = document.querySelector('#age');
    const storyTitle = document.querySelector('#story-title');
    const genre = document.querySelector('#genre');
    const story = document.querySelector('#story');
 
    if (firstName.value == '' 
    || lastName.value == '' 
    || age.value == '' 
    || storyTitle.value == '' 
    || genre.value == ''
    || story.value == ''){
      return;
    }
 
      const ul = document.querySelector('#preview-list');
      const li = document.createElement('li');
      li.className = 'story-info';
      const article = document.createElement('article');
 
      article.innerHTML = `
      <h4>${firstName.value && lastName.value}</h4>
      <p>Age: ${age.value}</p>
      <p>Title: ${storyTitle.value}</p>
      <p>Genre:: ${genre.value}</p>
      <p>story: ${story.value}</p>
      `;
 
      li.appendChild(article);
      const storyButton = document.createElement('button');
      storyButton.type = 'button';
      storyButton.className = 'save-btn';
      storyButton.textContent = 'Save Story';
      li.appendChild(storyButton);
 
      const editButton = document.createElement('button');
      editButton.type = 'button';
      editButton.className = 'edit-btn';
      editButton.textContent = 'Edit Story';
      li.appendChild(editButton);
 
      const deleteButton = document.createElement('button');
      deleteButton.type = 'button';
      deleteButton.className = 'delete-btn';
      deleteButton.textContent = 'Delete Story';
      li.appendChild(deleteButton);
 
      ul.appendChild(li);
 
        firstName.value == '';
        lastName.value == ''; 
        age.value == '';
        storyTitle.value == ''; 
        genre.value == '';
        story.value == '';
 
      editButton.addEventListener('click', (event) => {
        const currentTarget = event.currentTarget.parentElement;
        firstName.value = row.children[0].textContent;
        lastName.value = row.children[1].textContent;
        age.value = Number(row.children[2].textContent);
        storyTitle.value = row.children[3].textContent;
        genre.value = Number(row.children[4].textContent);
        story.value = Number(row.children[5].textContent);
 
        currentTarget.parentElement.removeChild(row);
      })
    })}