function solve() {
    const title = document.querySelector('#title');
    const recepientName = document.querySelector('#recipientName');
    const message = document.querySelector('#message');

    document.querySelector('#add').addEventListener('click', (event) => {
        event.preventDefault();

        const row = document.querySelector('#list');

        if (title.value == '' || recepientName.value == '' || message == '') {
            return;
        }
        const li = document.createElement('li');

        li.innerHTML = `
    <h4>Title: ${title.value}</h4>
    <h4>Recipient Name: ${recepientName.value}</h4>
    <span>${message.value}</span>
    <div>
    <button type="submit" id="send">Send</button>
    <button type="submit" id="delete">Delete</button>
    </div>
    `;

        li.querySelector('#delete').addEventListener('click', deleteRow);

        row.appendChild(li);

        title.value = '';
        recepientName.value = '';
        message.value = '';

        document.querySelector('#send').addEventListener('click', (event) => {
            const li = event.currentTarget.parentElement.parentElement;
            const row = document.querySelector('.sent-list');

            const title = li.querySelectorAll('h4')[0].textContent;
            const recepientName = li.querySelectorAll('h4')[1].textContent;
            const buttonDelete = document.createElement('button');
            buttonDelete.className = 'delete';
            buttonDelete.type = 'submit';
            buttonDelete.textContent = 'Delete';

            li.parentElement.removeChild(li);

            const sendMail = document.createElement('li');
            sendMail.innerHTML = `
            <span>To: ${recepientName}</span>
            <span>Title: ${title}</span>
            `;

            const div = document.createElement('div');
            div.className = 'btn';

            div.appendChild(buttonDelete);

            sendMail.appendChild(div);

            row.appendChild(sendMail);

            buttonDelete.addEventListener('click', deleteRow);

        });

    });

    document.querySelector('#reset').addEventListener('click', (event) => {
        event.preventDefault();

        title.value = '';
        recepientName.value = '';
        message.value = '';
    });

    function deleteRow(event) {
        const row = event.currentTarget.parentElement.parentElement;


        let recipientName;
        let title;

        if (document.querySelectorAll('h4').length == 2) {
            recipientName = document.querySelectorAll('h4')[1].textContent;
            title = document.querySelectorAll('h4')[0].textContent.replace('Title: ','');

        }else{
            recipientName = document.querySelectorAll('span')[1].textContent.replace('Title: ','');
            title = document.querySelectorAll('span')[0].textContent.replace('To: ','').replace('Recipient Name: ','');
        }

        row.parentElement.removeChild(row);

        const li = document.createElement('li');

        li.innerHTML = `
        <span>To: ${recipientName}</span>
        <span>Title: ${title}</span>
        `;

        document.querySelector('.delete-list').appendChild(li);
    }
}
solve()