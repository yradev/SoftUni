function solve() {

  const buttons = document.querySelectorAll('button');

  const enableFirstCheck = document.querySelector('tbody tr');
  const td = enableFirstCheck.querySelectorAll('td')[4];
  td.querySelector('input[type=checkbox]').disabled = false;

  for (button of buttons) {
    button.addEventListener('click', getClickedButton);
  }


  function getClickedButton(event) {
    if (event.currentTarget.textContent == 'Generate') {
      const furnitures = JSON.parse(document.querySelectorAll('textarea')[0].value);

      const tbody = document.querySelector('tbody');
      for(furniture of furnitures){

        tbody.innerHTML += `
        <tr>
        <td><img src=${furniture.img}></td>
        <td><p>${furniture.name}</p></td>
        <td><p>${furniture.price}</p></td>
        <td><p>${furniture.decFactor}</p></td>
        <td><input type="checkbox"/></td>
        </tr>
        `;
      }
    } else {

      const checked = document.querySelectorAll('input:checked');

      const total = {
        names: [],
        totalPrice: 0,
        averageDecorationFactor: 0
      };

      for(check of checked){
        const row = check.parentElement.parentElement;

        let name = row.children[1].textContent;
        let price = Number(row.children[2].textContent);
        let average = Number(row.children[3].textContent);

        total.names.push(name);
        total.totalPrice += price;
        total.averageDecorationFactor+=average;
      }

     const textareas = document.querySelectorAll('textarea');
     
     textareas[1].textContent += `Bought furniture: ${total.names.join(', ')}\n`;
     textareas[1].textContent += `Total price: ${total.totalPrice.toFixed(2)}\n`;
     textareas[1].textContent += `Average decoration factor: ${total.averageDecorationFactor/total.names.length.toFixed(1)}`;
    }
  }

}