function cookingByNumbers (number,operator1,operator2,operator3,operator4,operator5){
    let operators = [operator1,operator2,operator3,operator4,operator5];


    for(let i=0; i<=operators.length-1;i++){
        switch(operators[i]){
            case 'chop' : number/=2; break;
            case 'dice' : number=Math.sqrt(number); break;
            case 'spice': number+=1; break;
            case 'bake' : number*=3; break;
            case 'fillet': number-=number*=0.2; break;
        
        }

        console.log(number);
    }
}

cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet')