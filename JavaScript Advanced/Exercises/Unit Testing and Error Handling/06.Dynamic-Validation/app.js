function validate() {
    const emailPattern = /^[a-z]+@+[a-z]+[.]+[a-z]+$/;

    const email = document.querySelector('#email');
    email.addEventListener('change',checkEmail);

    function checkEmail(){
       if(!emailPattern.test(email.value)){
        document.querySelector('#email').className = 'error'
       }else{
        document.querySelector('#email').className = ''

       }
    }
}