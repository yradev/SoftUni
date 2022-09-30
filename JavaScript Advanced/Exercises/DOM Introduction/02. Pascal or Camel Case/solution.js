function solve() {

  let text = document.getElementById('text').value;
  let namingConvention = document.getElementById('naming-convention').value;
  let result = document.getElementById('result');
  let textArray;
  
  text = text.toLowerCase();
  
  switch(namingConvention){
    case 'Camel Case': 
    textArray = text.split(" ");
  
    for(let index=1;index<textArray.length;index++){
      textArray[index] = textArray[index].charAt(0).toUpperCase() + textArray[index].substring(1);
    }
  
    text = textArray.join('');
    break;
  
    case 'Pascal Case':
      textArray = text.split(" ");
  
      for(let index=0;index<textArray.length;index++){
        textArray[index] = textArray[index].charAt(0).toUpperCase() + textArray[index].substring(1);
      }
    
      text = textArray.join('');
      break;
  
      default: text = 'Error!'; break;
  }
  
  result.textContent = text
  }