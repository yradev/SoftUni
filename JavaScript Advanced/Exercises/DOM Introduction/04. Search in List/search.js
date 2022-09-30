function search() {
   let searchingFor = document.getElementById('searchText').value;
   let towns = [...document.querySelectorAll('ul li')];
   let matches = 0;
   towns.forEach(town => {
      if(town.textContent.includes(searchingFor)){
         matches++;
         town.style.fontWeight = 'bold';
         town.style.textDecoration = 'underline';

      }
   });

   document.getElementById('result').textContent = `${matches} matches found`;
}