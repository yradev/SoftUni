class footballTeam {
    constructor(clubName, country) {
        this.clubName = clubName;
        this.country = country;
        this.invitedPlayers = [];
    };

    newAdditions(footballPlayers) {
        const newInvitedPlayers = new Set();
        for (let player of footballPlayers) {
            const split = player.split('/');
            const name = split[0];
            const age = Number(split[1]);
            const playerValue = Number(split[2]);

            if (this.invitedPlayers.some(a => a.name == name)) {
                const indexOf = this.invitedPlayers.indexOf(this.invitedPlayers.find(a => a.name == name));

                if (playerValue > this.invitedPlayers[indexOf].playerValue) {
                    this.invitedPlayers[indexOf].playerValue = playerValue;
                }
            } else {
                this.invitedPlayers.push({ name, age, playerValue });
            }

            newInvitedPlayers.add(name);
        };
        return `You successfully invite ${[...newInvitedPlayers].join(', ')}.`;
    };

    signContract(selectedPlayer) {
        const split = selectedPlayer.split('/');
        const name = split[0];
        const playerOffer = Number(split[1]);

        if (!this.invitedPlayers.some(a => a.name == name)) {
            throw new Error(`${name} is not invited to the selection list!`);
        }

        let indexOf = this.invitedPlayers.indexOf(this.invitedPlayers.find(a => a.name == name));

        if (playerOffer < this.invitedPlayers[indexOf].playerValue) {
            throw new Error(`The manager's offer is not enough to sign a contract with ${name}, ${this.invitedPlayers[indexOf].playerValue - playerOffer} million more are needed to sign the contract!`);
        }

        this.invitedPlayers[indexOf].playerValue = 'Bought';
        return `Congratulations! You sign a contract with ${name} for ${playerOffer} million dollars.`;
    };

    ageLimit(name, age) {
        if (!this.invitedPlayers.some(a => a.name == name)) {
            throw new Error(`${name} is not invited to the selection list!`);
        }

        let indexOf = this.invitedPlayers.indexOf(this.invitedPlayers.find(a => a.name == name));
        if(this.invitedPlayers[indexOf].age < age){

            const ageDifference = age - this.invitedPlayers[indexOf].age;

            if(ageDifference<5){
                return `${name} will sign a contract for ${ageDifference} years with ${this.clubName} in ${this.country}!`
            }else if(ageDifference>5){
                return `${name} will sign a full 5 years contract for ${this.clubName} in ${this.country}!`
            };

        }else{
            return `${name} is above age limit!`;
        };
    };

    transferWindowResult(){
        return `Players list:\n${this.invitedPlayers.sort((a,b)=>a.name.localeCompare(b.name)).map(a=>`Player ${a.name}-${a.playerValue}`).join('\n')}`;
    };

}

let fTeam = new footballTeam("Barcelona", "Spain");
console.log(fTeam.newAdditions(["Kylian Mbappé/23/160", "Lionel Messi/35/50", "Pau Torres/25/52"]));
console.log(fTeam.ageLimit("Lionel Messi", 33 ));
console.log(fTeam.ageLimit("Kylian Mbappé", 30));
console.log(fTeam.ageLimit("Pau Torres", 26));
console.log(fTeam.signContract("Kylian Mbappé/1"));
