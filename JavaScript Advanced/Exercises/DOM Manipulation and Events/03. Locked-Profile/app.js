function lockedProfile() {

    const buttons = document.querySelectorAll('button');

    for (button of buttons) {
        button.addEventListener('click', showMore);
    }

    function showMore(event) {
        const locked = event.currentTarget.parentElement.querySelector('input[type=radio]').checked;

        if (!locked) {
            const showMoreInfo = event.currentTarget.parentElement.querySelector('div');
            if (showMoreInfo.style.display == 'block') {
                showMoreInfo.style.display = 'none';
                showMoreInfo.parentElement.querySelector('button').textContent = 'Show more';
            } else {
                showMoreInfo.style.display = 'block';
                showMoreInfo.parentElement.querySelector('button').textContent = 'Hide it';
            }
        }
    }
}