function solve(){

    const foundArguments = [];

    for(argument of arguments){
        let type = typeof(argument);
        console.log(`${type}: ${argument}`);
        if(foundArguments.some(arg=>arg.type==type)){
            foundArguments.find(arg=>arg.type==type).counter++;
        }else{
            foundArguments.push({type: type, counter: 1});
        }
    }
}

solve('cat', 42, function () { console.log('Hello world!'); },'blqblq');