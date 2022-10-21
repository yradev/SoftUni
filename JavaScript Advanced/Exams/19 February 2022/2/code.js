class LibraryCollection {
    constructor(capacity) {
        this.capacity = capacity;
        this.books = [];
    }

    addBook(bookName, bookAuthor) {

        if (this.books.length >= this.capacity) {
            throw new Error("Not enough space in the collection.");
        }

        this.books.push({ bookName, bookAuthor, payed: false });
           return `The ${bookName}, with an author ${bookAuthor}, collect.`;
    };

    payBook(bookName) {
        const book = this.books.filter(a => a.bookName == bookName)[0];

        if (book == undefined) {
            throw new Error(`${bookName} is not in the collection.`);
        }
        if (book.payed) {
            throw new Error(`${bookName} has already been paid.`);
        } else {
            this.books.filter(a => a.bookName == bookName)[0].payed = true;
            return `${bookName} has been successfully paid.`
        }
    }

    removeBook(bookName) {
        const removeBook = this.books.filter(a => a.bookName == bookName)[0];

        if (removeBook == undefined) {
            throw new Error("The book, you're looking for, is not found.");
        }

        if (!removeBook.payed) {
            throw new Error(`${bookName} need to be paid before removing from the collection.`);
        }

        this.books.splice(this.books.indexOf(removeBook), 1);
        return `${bookName} remove from the collection.`;

    }

    getStatistics() {
        if (arguments.length == 0) {
            return `The book collection has ${this.capacity - this.books.length} empty spots left.\n${this.books
                .sort((a, b) => a.bookName.localeCompare(b.bookName))
                .map(a => `${a.bookName} == ${a.bookAuthor} - ${a.payed ? 'Has Paid' : 'Not Paid'}.`).join('\n')}`
        } else {
            const bookAuthor = arguments[0];
            const book = this.books.filter(a => a.bookAuthor == bookAuthor)[0];

            if (book == undefined) {
                throw new Error(`${bookAuthor} is not in the collection.`);
            } else {
                return `${`${book.bookName} == ${book.bookAuthor} - ${book.payed ? 'Has Paid' : 'Not Paid'}.`}`
            }
        }
    }
}