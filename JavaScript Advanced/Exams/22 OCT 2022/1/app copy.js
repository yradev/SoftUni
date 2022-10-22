window.addEventListener("load", solve);

function solve() {

  const firstName = document.querySelector('#first-name');
  const lastName = document.querySelector('#last-name');
  const age = document.querySelector('#age');
  const storyTitle = document.querySelector('#story-title');
  const genre = document.querySelector('#genre');
  const story = document.querySelector('#story');
  const publishButton = document.querySelector('#form-btn');
  publishButton.addEventListener('click', () => {

    if (firstName.value == '' || lastName.value == '' || age.value == '' || storyTitle.value == '' || story.value == '') {
      return;
    }

    const row = document.querySelector('#preview-list');

    const li = document.createElement('li');
    li.className = 'story-info'
    li.innerHTML = `
    <article>
    <h4>Name: ${firstName.value} ${lastName.value}</h4>
    <p>Age: ${age.value}</p>
    <p>Title: ${storyTitle.value}</p>
    <p>Genre: ${genre.value}</p>
    <p>${story.value}</p>
    </article>
    <button class='save-btn'>Save story</button>
    <button class='edit-btn'>Edit story</button>
    <button class='delete-btn'>Delete story</button>
    `;

    row.appendChild(li);

    firstName.value = '';
    lastName.value = '';
    age.value = '';
    storyTitle.value = '';
    story.value = '';

    publishButton.disabled = true;    

    document.querySelector('.edit-btn').addEventListener('click', (event) => {
      const currentTarget = event.currentTarget.parentElement.parentElement;

      const firstNameAndLastNames = currentTarget.querySelector('h4').textContent.replace('Name: ', '').split(' ');
      firstName.value = firstNameAndLastNames[0];
      lastName.value = firstNameAndLastNames[1];

      const paragraphs = document.querySelectorAll('p');

      age.value = paragraphs[0].textContent.replace('Age: ', '');
      storyTitle.value = paragraphs[1].textContent.replace('Title: ', '');
      genre.value = paragraphs[2].textContent.replace('Genre: ', '');
      story.value = paragraphs[3].textContent.replace('\n', '');

      event.currentTarget.parentElement.remove();
      publishButton.disabled = false;
    });

    document.querySelector('.save-btn').addEventListener('click', () => {
      const main = document.querySelector('#main');

      main.innerHTML = '<h1>Your scary story is saved!</h1>';
    });

    document.querySelector('.delete-btn').addEventListener('click', (event) => {
      event.currentTarget.parentElement.remove();
      publishButton.disabled = false;
    })

  });
}