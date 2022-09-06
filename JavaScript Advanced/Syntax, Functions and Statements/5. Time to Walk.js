function walkingTime(steps, lengthOfFootprint, speed){

    let matersToUniversity=steps*lengthOfFootprint;
    let speedInSeconds= speed/3.6;
    let timeInSeconds = matersToUniversity/speedInSeconds;

    let secondsToWalk = timeInSeconds%60;
    let minutesToWalk = Math.floor(timeInSeconds/60);

    let minutesBreak = Math.floor(matersToUniversity/500);
    minutesToWalk+=minutesBreak;

    let hoursToWalk;

    if(minutesToWalk>=60){
        hoursToWalk= Math.floor(minutesToWalk/60);
        minutesToWalk = minutesToWalk%60;
    }else{
        hoursToWalk=0;
    }

    console.log(`${hoursToWalk<10?'0':''}${hoursToWalk}:${minutesToWalk<10?'0':''}${minutesToWalk.toFixed(0)}:${secondsToWalk<10?'0':''}${secondsToWalk.toFixed(0)}`)
}

walkingTime(4000, 0.60, 5);
walkingTime(2564, 0.70, 5.5);