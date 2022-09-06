function someNumbers(number){
 let areEqual = true;
 let stringNumber = `${number}`;
 
 for(let i=1;i<=stringNumber.length-1;i++){
    if(stringNumber.charAt(i)!=stringNumber.charAt(i-1)){
        areEqual = false;
        break;
    }
 }

 console.log(areEqual)
}

someNumbers(2222222);
someNumbers(1234);