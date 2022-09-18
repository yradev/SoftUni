function solution(array,element){
    array = array.map((value,index,array)=>{
        if(index%element==0){
            return value;
        }else{
            return null;
        }
    })
    .filter((x)=>x!=null); 

    return array;
}

solution(
['5', 
'20', 
'31', 
'4', 
'20'], 
2
)

solution(
    ['dsa',
    'asd', 
    'test', 
    'tset'], 
    2    
)

solution(
    ['1', 
'2',
'3', 
'4', 
'5'], 
6
)