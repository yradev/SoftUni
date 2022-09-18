function solution(array) {

    let biggestNumber = Number.MIN_SAFE_INTEGER;

    const finalArray = [];

    array.forEach(element => {
        if(element>=biggestNumber){
            finalArray.push(element);
            biggestNumber = element;
        }
    });

    return finalArray;
}

solution([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]
);

solution([
    1,
    2,
    3,
    4]
)


solution(
[20, 
    3, 
    2, 
    15,
    6, 
    1
    ]
)