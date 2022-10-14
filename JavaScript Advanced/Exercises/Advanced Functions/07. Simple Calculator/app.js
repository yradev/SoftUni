function calculator() {
    return  {
        selector1:undefined,slector2:undefined, result: 0,

        init(selector1,selector2,result){
            this.selector1 = Number(document.querySelector(selector1).value);
            this.selector2 = Number(document.querySelector(selector2).value);
            this.result = document.querySelector(result).value;
        }, 
        add() {
            document.querySelector('#result').value = Number(document.querySelector('#num1').value) + Number(document.querySelector('#num2').value)
        },
        subtract() {
            document.querySelector('#result').value = Number(document.querySelector('#num1').value) - Number(document.querySelector('#num2').value)
        }
    };
}






