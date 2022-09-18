function solution(array,rotate){

    for(let index=1; index<=rotate; index++){
        let lastValue = array.pop();
        array.unshift(lastValue);
    }

    console.log(array.join(' '));
}

solution(['1', 
'2', 
'3', 
'4'], 
2
);

solution(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
)