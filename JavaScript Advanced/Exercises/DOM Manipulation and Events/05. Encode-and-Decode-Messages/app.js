function encodeAndDecodeMessages() {
    function encode(message){

        let encodedMessage = [];

        for(let index = 0; index<message.length; index++){
            let encodeASCII = message.charCodeAt(index)+1;
            let encodeString = String.fromCharCode(encodeASCII);

            encodedMessage.push(encodeString)
        }

        return encodedMessage.join('');
    }


    function decode(message){

        let decodedMessage = [];

        for(let index = 0; index<message.length; index++){
            let decideASCII = message.charCodeAt(index)-1;
            let decodeString = String.fromCharCode(decideASCII);

            decodedMessage.push(decodeString)
        }

        return decodedMessage.join('');

    }

    let message = document.querySelectorAll('div textarea')[1];

    const buttons = document.querySelectorAll('button');

    for(button of buttons){
        button.addEventListener('click', checkButton);
    }
    
    function checkButton(event){
        if(event.currentTarget.parentElement.querySelector('p').textContent=='Message'){
            message.value = encode(event.currentTarget.parentElement.querySelector('textarea').value);
            event.currentTarget.parentElement.querySelector('textarea').value = '';
        }else{
            message.value = decode(event.currentTarget.parentElement.querySelector('textarea').value);
        }

    }
}