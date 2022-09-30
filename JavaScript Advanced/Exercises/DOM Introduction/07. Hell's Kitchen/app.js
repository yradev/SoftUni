function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let input = document.querySelector('#inputs textarea').value;
      const array = input.substring(1, input.length - 1).split('","');
      const totalRestaurants = [];

      for (restaurant of array) {
         let restaurantName = restaurant.split(' - ')[0].replace('"', '');
         let currentRestaurant;
         let saveIndex;

         if(totalRestaurants.some(restaurant=>restaurant.name==restaurantName)){
            currentRestaurant = totalRestaurants.find(restaurant=>restaurant.name==restaurantName);
            saveIndex = totalRestaurants.indexOf(currentRestaurant);
         }else{
            saveIndex = totalRestaurants.length;
            currentRestaurant = {
               name: restaurantName, 
               staff: [],
               calculateAverageSalary(){
                 return this.staff
                     .map(worker => worker.salary)
                     .reduce((accomulator,currentValue)=>accomulator+currentValue,0)/this.staff.length;
               },
   
               bestSalary(){
                  return Math.max(...this.staff.map(worker=>worker.salary));
               }
            };
       }
        

         const workers = restaurant
            .split(' - ') [1] // get workers as String 
            .replace('"', '') // remove last "
            .split(', '); // get worker with name and salary as String

         for(worker of workers){
            let details = worker.split(' ');
            currentRestaurant.staff.push({name: details[0], salary: Number(details[1])})
         }

         if(saveIndex!=totalRestaurants.length){
            totalRestaurants[saveIndex] = currentRestaurant;
         }else{
         totalRestaurants[saveIndex] = currentRestaurant;
         }
   }

  let bestAverageSalary =  Math.max(...totalRestaurants.map(restaurant=>restaurant.calculateAverageSalary().toFixed(2)));
  
  let bestRestaurant = totalRestaurants.filter(restaurant=>restaurant.calculateAverageSalary().toFixed(2)==bestAverageSalary)[0];

  bestRestaurant.staff.sort((a,b)=>b.salary-a.salary);

  document.querySelector('#bestRestaurant p').textContent = `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.calculateAverageSalary().toFixed(2)} Best Salary: ${bestRestaurant.bestSalary().toFixed(2)}`;

  let tempArray = [];

  for(worker of bestRestaurant.staff){
   tempArray.push(`Name: ${worker.name} With Salary: ${worker.salary}`);
  }

  document.querySelector('#workers p').textContent = tempArray.join(' ');
}
}