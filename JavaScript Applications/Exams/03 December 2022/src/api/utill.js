export function getOptionsFromForms(target){
    const formData = new FormData(target);

    const options = {};
    for (const data of formData.entries()) {
        options[data[0]] = data[1];
    }

    return options;
}