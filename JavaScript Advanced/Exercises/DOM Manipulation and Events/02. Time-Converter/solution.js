function attachEventsListeners() {

    
        const calculator = {
            calculateDay(days){
                let hours = days*24;
                let minutes = hours*60;
                let seconds = minutes*60;

                return [Number(days),hours,minutes,seconds];
            },
            calculateHours(hours){
                let days = hours/24;
                let minutes = hours*60;
                let seconds = minutes*60;
                
                return [days,Number(hours),minutes,seconds];
            },
            calculateMinutes(minutes){
                let hours = minutes/60;
                let days = hours/24;
                let seconds = minutes*60;

                return [days,hours,Number(minutes),seconds];
            },
            calculateSeconds(seconds){

                let minutes = seconds/60;
                let hours = minutes/60;
                let days = hours/24;

                return [days,hours,minutes,Number(seconds)];
            }
        }


        let buttons = document.querySelectorAll('input[type=button]');


       for(button of buttons){
        
        button.addEventListener('click',calculate);

       }

       function calculate(event){
        let values = [];
        let value = event.currentTarget.parentElement.querySelector('input[type=text]').value;

        switch(event.currentTarget.id){
            case 'daysBtn': values = calculator.calculateDay(value); break;
            case 'hoursBtn': values = calculator.calculateHours(value); break;
            case 'minutesBtn': values = calculator.calculateMinutes(value); break;
            case 'secondsBtn': values = calculator.calculateSeconds(value); break;
        }

        let inputs = document.querySelectorAll('input[type=text]');

        for(input of inputs){
            input.value = values.shift();
        }
    }
}