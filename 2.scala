case class Book(title: String, author: String, isbn: String);

var Library: Set[Book] = Set(
    Book("Book 1", "Author 1", "0000001"),
    Book("Book 2", "Author 2", "0000002"),
    Book("Book 3", "Author 1", "0000003")
  )

def addBook(book : Book) : Unit = {
    Library += book;
    println(s"Added:${book.title} by ${book.author} ISBN:${book.isbn}")
}

def removeBook(booktoremove :Book) : Unit = {
    Library.find(book => book.isbn == booktoremove.isbn && book.title == booktoremove.title && book.author == booktoremove.author) match {
        case Some(foundBook) => 
            Library -= foundBook;
            println(s"Removed: ${foundBook.title} by ${foundBook.author} ISBN: ${foundBook.isbn}");
        case None => println(s"Book not found.");
    }
}

def checkBook(booktocheck : Book) : Unit = {
    Library.find(book => book.isbn == booktocheck.isbn && book.title == booktocheck.title && book.author == booktocheck.author) match {
        case Some(foundBook) => println(s"Book Found");
        case None => println(s"Book not found."); 
    }
}

def displayLibrary() : Unit = {
    println("Library");
    Library.foreach(book => println(s"${book.title} by ${book.author}, ISBN:${book.isbn}"));
}

def searchByTitle(title : String) : Unit = {
    Library.find(_.title.toLowerCase == title.toLowerCase) match {
        case Some(foundBook) => println(s"${foundBook.title} by ${foundBook.author}, ISBN:${foundBook.isbn}");
        case None => println(s"Book not found.");
    }
}

def booksByAuthor(author : String) : Unit = {
    val books = Library.filter(_.author.toLowerCase == author.toLowerCase);
    if (books.nonEmpty){
        println(s"Books by $author:");
        books.foreach(book => println(s"${book.title} ISBN: ${book.isbn}"))
    }
    else{
       println(s"No books found from the author.")
    }; 
}

@main def main() = {
    displayLibrary();
    addBook(Book("Book 4", "Author 3", "0000005"));
    displayLibrary();
    removeBook(Book("Book 2", "Author 1", "0000002"));
    displayLibrary();
    checkBook(Book("Book 1", "Author 1", "0000001"));
    searchByTitle("Book 4");
    booksByAuthor("Author 1");
}