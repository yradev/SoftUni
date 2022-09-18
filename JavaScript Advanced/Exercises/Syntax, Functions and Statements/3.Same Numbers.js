function someNumbers(number){
 let areEqual = true;
 let stringNumber = `${number}`;
 let sum = 0;

for(let counter=1; counter<=stringNumber.length-1;counter++){
    let currentNumber = Number(stringNumber.charAt(counter));
    let previousNumber = Number(stringNumber.charAt(counter-1));

    sum+=counter<stringNumber.length-1?previousNumber:currentNumber+previousNumber;

    if(areEqual && currentNumber!=previousNumber){
            areEqual = false;
            }
        }

console.log(areEqual);
console.log(sum);
}

someNumbers(2222222);
someNumbers(1234);