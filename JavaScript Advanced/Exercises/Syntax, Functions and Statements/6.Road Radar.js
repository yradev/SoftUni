function roadRadar(speed,area){
let speedlimit;
let status;

switch(area){
    case 'motorway': speedlimit = 130; break;
    case 'interstate': speedlimit = 90; break;
    case 'city': speedlimit = 50; break;
    case 'residential': speedlimit = 20; break;
}

if(speed<=speedlimit){
        console.log(`Driving ${speed} km/h in a ${speedlimit} zone`);
    }else{

        if(speed-speedlimit<=20){
            status = 'speeding';
        }else if(speed-speedlimit>20 && speed-speedlimit<=40){
            status = 'excessive speeding';
        }else{
            status = 'reckless driving';
        }

        console.log(`The speed is ${speed-speedlimit} km/h faster than the allowed speed of ${speedlimit} - ${status}`);
    }
}

roadRadar(40, 'city');
roadRadar(21, 'residential');
roadRadar(120, 'interstate');
roadRadar(200, 'motorway');