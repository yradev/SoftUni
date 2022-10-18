function result(){
    class Ticket{
        constructor(destination,price,status){
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    const tickets = [];

    for(let array of arguments[0]){
        const split = array.split('|');

        tickets.push(new Ticket(split[0],split[1],split[2]));
    }

    if(arguments[1]=='price'){
        tickets.sort((a,b)=>a.price-b.price);
    }else if(arguments[1] == 'destination'){
        tickets.sort((a,b)=>a.destination.localeCompare(b.destination));
    }else{
        tickets.sort((a,b)=>a.status.localeCompare(b.status));
    }
    return tickets;
};

console.log(result(['Philadelphia|94.20|available',
 'New York City|95.99|available',
 'New York City|95.99|sold',
 'Boston|126.20|departed'],
'destination'));