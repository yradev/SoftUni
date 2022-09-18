function solution(array){
    const finalArray = [];

    let number = 0;

    array.forEach(element => {

    switch(element){
        case 'add': finalArray.push(++number); break;
        case 'remove': number++;finalArray.pop(); break;
    }    
    });

    if(finalArray.length==0){
        console.log('Empty')
    }else{
        finalArray.forEach((x)=>console.log(x))
    }
};

solution(['add', 
'add', 
'add', 
'add']
);

solution(['add', 
'add', 
'remove', 
'add', 
'add']
);

solution(['remove', 
'remove', 
'remove']
)