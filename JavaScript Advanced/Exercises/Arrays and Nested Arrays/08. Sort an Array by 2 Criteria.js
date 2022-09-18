function solve(array){

    array.sort((a,b)=>{
        if(a.length<b.length){
            return -1;
        }

        if(a.length>b.length){
            return 1;
        }

        return a.localeCompare(b);
    });

    array.forEach(element => {
        console.log(element);
    });
};


solve(
    ['test', 
    'Deny', 
    'omen', 
    'Default']    
);