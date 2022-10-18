window.addEventListener("load", solve);

function solve() {

  const publish = document.querySelector('#publish');
  publish.type = 'button';
  publish.addEventListener('click', () => {
    const make = document.querySelector('#make');
    const model = document.querySelector('#model');
    const year = document.querySelector('#year');
    const fuel = document.querySelector('#fuel');
    const originalCost = document.querySelector('#original-cost');
    const sellingPrice = document.querySelector('#selling-price');

    if (make.value == '' || model.value == '' || year.value == '' || fuel.value == '' || Number(originalCost.value) >= Number(sellingPrice.value) || Number(originalCost.value) == 0 || Number(sellingPrice.value) == 0) {
      return;
    }

    const body = document.querySelector('#table-body');
    const row = document.createElement('tr');
    row.innerHTML = `<tr>
    <td>${make.value}</td>
    <td>${model.value}</td>
    <td>${Number(year.value)}</td>
    <td>${fuel.value}</td>
    <td>${Number(originalCost.value)}</td>
    <td>${Number(sellingPrice.value)}</td>
    </tr>`

    body.appendChild(row);

    const buttonsCol = document.createElement('td');

    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.className = 'action-btn edit';
    editButton.id = 'edit';
    editButton.type = 'button';
    buttonsCol.appendChild(editButton);

    const sellButton = document.createElement('button');
    sellButton.textContent = 'Sell';
    sellButton.className = 'action-btn sell';
    sellButton.id = 'sell'
    sellButton.type = 'button';
    buttonsCol.appendChild(sellButton);
    row.appendChild(buttonsCol);

    make.value = '';
    model.value = '';
    year.value = '';
    fuel.value = '';
    originalCost.value = '';
    sellingPrice.value = '';

    editButton.addEventListener('click', (event) => {
      const row = event.currentTarget.parentElement.parentElement;
      make.value = row.children[0].textContent;
      model.value = row.children[1].textContent;
      year.value = Number(row.children[2].textContent);
      fuel.value = row.children[3].textContent;
      originalCost.value = Number(row.children[4].textContent);
      sellingPrice.value = Number(row.children[5].textContent);

      row.parentElement.removeChild(row);
    });

    sellButton.addEventListener('click', (event) => {
      const row = event.currentTarget.parentElement.parentElement;
      const ul = document.querySelector('#cars-list');

      const li = document.createElement('li');
      li.className = 'each-list';

      const span1 = document.createElement('span');
      span1.textContent = `${row.children[0].textContent} ${row.children[1].textContent}`;
      li.appendChild(span1);

      const span2 = document.createElement('span');
      span2.textContent = `${row.children[2].textContent}`;
      li.appendChild(span2);

      const span3 = document.createElement('span');
      span3.textContent = `${Number(row.children[5].textContent) - Number(row.children[4].textContent)}`;
      const profit = document.querySelector('#profit');
      let sum = Number(profit.textContent) + Number(span3.textContent);
      profit.textContent = sum.toFixed(2);
      li.appendChild(span3);

      ul.appendChild(li);
      row.parentElement.removeChild(row);
    })
  })
}