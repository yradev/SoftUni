function create(words) {

   for (value of words) {
      const div = document.createElement('div');
      const p = document.createElement('p');
      p.textContent = value;
      p.style.display = 'none';
      div.appendChild(p);
      document.querySelector('#content').appendChild(div);

      div.addEventListener('click', viewInput);
   }

   function viewInput(e) {
      const currentDiv = e.currentTarget.firstChild;
      currentDiv.style.display = '';
   }
}