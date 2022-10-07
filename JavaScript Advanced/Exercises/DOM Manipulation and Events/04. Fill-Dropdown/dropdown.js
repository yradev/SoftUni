function addItem() {
    const menu = document.querySelector('#menu');


    let newItemText = document.querySelector('#newItemText').value;
    let newItemValue = document.querySelector('#newItemValue').value;

    const option = document.createElement('option')
    option.textContent = newItemText;
    option.value = newItemValue;
    menu.add(option);

    document.querySelector('#newItemText').value = '';
    document.querySelector('#newItemValue').value = '';

}