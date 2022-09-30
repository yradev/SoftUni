function toggle() {
    let extraModule = document.getElementById('extra');
    let button = document.getElementsByClassName('button')[0];

    console.log(button);
    
    if(button.textContent == 'More'){
        button.textContent = 'Less';
        extraModule.style.display = 'block';
    }else{
        button.textContent = 'More';
        extraModule.style.display = 'none';
    }

}