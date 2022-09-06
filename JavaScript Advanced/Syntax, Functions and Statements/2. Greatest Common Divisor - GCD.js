function GCD (number1, number2){

    let divisor;
    let divisibleNumber;

    if(number1>number2){
        divisor=number2;
        divisibleNumber=number1;
    }else{
        divisor=number1;
        divisibleNumber=number2;
    }
    let remainder;
    while(true){
        remainder = divisibleNumber%divisor;
        if(remainder!=0){
            divisibleNumber = divisor;
            divisor = remainder;
        }else{
            break;
        }
    }

    console.log(divisor);
}

GCD(15,5);
GCD(2154, 458);