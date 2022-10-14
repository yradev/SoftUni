function validate() {
    const submit = document.querySelector('#submit');
    submit.type = 'button';
    submit.addEventListener('click', onSubmit);

    const company = document.querySelector('#company');

    company.addEventListener('change', companyCheck);

    function companyCheck() {
        const checkInfo = document.querySelector('#companyInfo');
        if (company.checked) {
            checkInfo.style.display = 'block';
        } else {
            checkInfo.style.display = 'none';
        }
    }

    function onSubmit() {
        const valid = document.querySelector('#valid');
        valid.style.display = 'block';

        const username = document.querySelector('#username');

        const usernameRegex = /^[A-z0-9]+$/;

        if (username.value.length < 3 || username.value.length > 20 || !usernameRegex.test(username.value)) {
            username.style.borderColor = 'red';
            valid.style.display = 'none';
        } else {
            username.style.borderColor = 'none';
        }

        const email = document.querySelector('#email');

        if (email.value.includes('@')) {
            if (!email.value.substring(email.value.indexOf('@') + 1).includes('.')) {
                email.style.borderColor = 'red';
                valid.style.display = 'none';
            } else {
                email.style.borderColor = 'none';
            }
        } else {
            email.style.borderColor = 'red';
            valid.style.display = 'none';
        }

        const password = document.querySelector('#password');
        const confirmPassword = document.querySelector('#confirm-password');

        const passwordRegex = /^[\w]+$/;

        if (password.value.length < 5 || password.value.length > 15 || !passwordRegex.test(password.value) || confirmPassword.value != password.value) {
            password.style.borderColor = 'red';
            valid.style.display = 'none';
        } else {
            password.style.borderColor = 'none';
        }

        if (confirmPassword.value.length < 5 || confirmPassword.value.length > 15 || !passwordRegex.test(confirmPassword.value) || confirmPassword.value != password.value) {
            confirmPassword.style.borderColor = 'red';
            valid.style.display = 'none';
        } else {
            confirmPassword.style.borderColor = 'none';
        }

        if (company.checked) {
            const companyNumber = document.querySelector('#companyNumber');

            if (Number(companyNumber.value) < 1000 || Number(companyNumber.value) > 9999) {
                companyNumber.style.borderColor = 'red';
                valid.style.display = 'none';
            } else {
                companyNumber.style.borderColor = 'none';
            }
        }
    }

}
