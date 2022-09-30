function solve() {
  let text = document.querySelector('#input').value;
  let textArary = text.split('.');
  let output = document.querySelector('#output');
  
  let value = '';
  let counter = 0;
    while(textArary.length-1>0){
 
      value += textArary.shift() + '.';
      counter++;

      if(counter%3==0 || textArary.length==1){
        output.innerHTML += `<p>${value}</p>`;
        value = '';
      }
    }
}