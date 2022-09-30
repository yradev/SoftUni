function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {

      let searchingFor = document.getElementById('searchField').value;

      const array = document.querySelectorAll('tbody tr');

      for(let index=0; index<array.length; index++){
         let row = array[index];
         if(row.textContent.includes(searchingFor)){
            row.className = 'select';
         }
      }

   }
}