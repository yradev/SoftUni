class SmartHike {
    constructor(username) {
        this.username = username;
        this.goals = {};
        this.listOfHikes = [];
        this.resources = Number(100);
    }

    addGoal(peak, altitude) {

        if (this.goals[peak] == null) {
            this.goals[peak] = Number(altitude);
            return `You have successfully added a new goal - ${peak}`;
        } else {
            return `${peak} has already been added to your goals`;
        }
    }

    hike(peak, time, difficultyLevel) {
        if (this.goals[peak] == null) {
            throw new Error(`${peak} is not in your current goals`);
        } else {
            if (this.resources == 0) {
                throw new "You don't have enough resources to start the hike";
            } else {
                let difference = this.resources - Number(time) * 10;
                if (difference < 0) {
                    return "You don't have enough resources to complete the hike";
                }

                this.resources -= Number(time) * 10;

                this.listOfHikes.push({ peak: peak, time: time, difficultyLevel: difficultyLevel });

                return `You hiked ${peak} peak for ${time} hours and you have ${this.resources}% resources left`
            }
        }
    }

    rest(time) {
        let sum = this.resources + Number(time) * 10;

        if (sum >= 100) {
            this.resources = 100;
            return `Your resources are fully recharged. Time for hiking!`;
        } else {
            this.resources = sum;
            return `You have rested for ${time} hours and gained ${time * 10}% resources`;
        }
    }

    showRecord(criteria) {
        if (this.listOfHikes.length == 0) {
            return `${this.username} has not done any hiking yet`;
        }

        let hikes;
        if (criteria == 'hard' || criteria == 'easy') {
            hikes = this.listOfHikes.filter(a => a.difficultyLevel == criteria);

            if (hikes.length == 0) {
                return `${this.username} has not done any ${criteria} hiking yet`;
            }

            hikes.sort((a,b)=>a.time-b.time);

            return `${this.username}'s best ${criteria} hike is ${hikes[0].peak} peak, for ${hikes[0].time} hours`
        } else {
            hikes = this.listOfHikes;

            let hikingRecords = [];

            for(let hike of hikes){
                hikingRecords.push(`${this.username} hiked ${hike.peak} for ${hike.time} hours`)
            };
            return `All hiking records:\n${hikingRecords.join('\n')}`
        }
    }
}

const user = new SmartHike('Vili');
user.addGoal('Musala', 2925);
user.hike('Musala', 8, 'hard');
console.log(user.showRecord('easy'));
user.addGoal('Vihren', 2914);
user.hike('Vihren', 4, 'hard');
console.log(user.showRecord('hard'));
user.addGoal('Rui', 1706);
user.hike('Rui', 3, 'easy');
console.log(user.showRecord('all'));
