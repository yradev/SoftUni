function checker(x1,y1,x2,y2){
    
    let checkers = [];
    
    checkers[0] = Math.sqrt(((0-x1)**2)+((0-y1)**2));
    checkers[1] = Math.sqrt(((x2-0)**2)+((y2-0)**2));
    checkers[2] = Math.sqrt(((x2-x1)**2)+((y2-y1)**2));

    for(let i=0; i<checkers.length;i++){
        let checker;
        if(i==0){
         checker = `{${x1}, ${y1}} to {0, 0}`;
        }
        if(i==1){
           checker = `{${x2}, ${y2}} to {0, 0}`;
        }
        if(i==2){
        checker = `{${x1}, ${y1}} to {${x2}, ${y2}}`;
        }
        

        if(Number.isInteger(checkers[i])){
            console.log(` ${checker} is valid`);
        }else{
            console.log(` ${checker} is invalid`);
        }
    }
}

checker(3, 0, 0, 4);
checker(2, 1, 1, 1);