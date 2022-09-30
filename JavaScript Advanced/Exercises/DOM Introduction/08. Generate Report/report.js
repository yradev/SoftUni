function generateReport() {
    let checkedInputs = document.querySelectorAll('input:checked');

    let table = document.querySelector('table');
    const report = [];
    const cells = [];

    for (let inputIndex = 0; inputIndex < checkedInputs.length; inputIndex++) {
        for (let index = 0; index < table.rows[0].cells.length; index++) {
            if (checkedInputs[inputIndex].parentElement.textContent == table.rows[0].cells[index].textContent) {
                cells.push(index);
                break;
            }
        }
    }

    for (index = 1; index < table.rows.length; index++) {
        const newReport = {};
        for (cell of cells) {
            let name = table.rows[0].cells[cell].textContent;
            let value = table.rows[index].cells[cell].textContent;
            newReport[name.toLowerCase().replace(' ','')] = value;
        }
        
        report.push(newReport);
    }


    document.querySelector('#output').value = JSON.stringify(report);
}