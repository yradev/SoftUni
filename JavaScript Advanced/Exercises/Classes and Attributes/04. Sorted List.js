class List{
    constructor(){
        this.array = [];
        this.size = this.array.length;
    }

    add(element){
        this.array.push(Number(element)); 
        this.size = this.array.length;
    }

    remove(index){
        if (index < 0 || index >= this.array.length) {
            throw new Error(`Index doesn't exist`);
        } else {
            this.array.splice(Number(index),1);
            this.size = this.array.length;
        }
    }

    get(index){
        this.array.sort((a,b)=>a-b);
        return this.array[Number(index)];
    }
}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));
