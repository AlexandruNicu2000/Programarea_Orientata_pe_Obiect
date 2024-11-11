#include <iostream>
#include <vector>
#include <string>

class Book {
private:
    std::string title;
    std::string author;
    std::string ISBN;

public:
    Book(std::string  t, std::string  a, std::string  i): title(std::move(t)), author(std::move(a)), ISBN(std::move(i)) {};

    std::string get_title() {
        return title;
    }
    std::string get_Author() {
        return author;
    }
    std::string get_ISBN() {
        return ISBN;
    }

    void displayBook() const{
        std::cout << "Title: " << title <<" ,Author: "<< author << " ,ISBN: "<< ISBN<< std::endl;
    }

};

class Library {
private:
    std::vector<Book> books;
public:

    void addBook(const Book& book) {
        books.push_back(book);
    }

    void deleteBook(const std::string& isbn) {
        for(auto it = books.begin(); it != books.end(); ++it) {
            if(it->get_ISBN() == isbn) {
                books.erase(it);
                break;
            }
        }
    }

    void displayLibraryBooks() const {
        std::cout << "Books from library" << std::endl;
        for(const auto& book : books) {
            book.displayBook();
        }
    }
};

void showMenu() {
    std::cout << "Library Menu:\n";
    std::cout << "1. Add a book\n";
    std::cout << "2. Delete a book\n";
    std::cout << "3. Display all books\n";
    std::cout << "4. Exit\n";
    std::cout << "Enter your choice: ";
}

void addBookToLibrary(Library& library) {
    std::string title, author, isbn;
    std::cout << "Enter title: ";
    std::cin.ignore();
    std::getline(std::cin, title);
    std::cout << "Enter author: ";
    std::getline(std::cin, author);
    std::cout << "Enter ISBN: ";
    std::getline(std::cin, isbn);
    library.addBook(Book(title, author, isbn));
}
void deleteBookFromLibrary(Library& library) {
    std::string isbn;
    std::cout << "Enter ISBN of the book to delete: ";
    std::cin.ignore();
    std::getline(std::cin, isbn);
    library.deleteBook(isbn);
}


int main() {

    Library library;
    int choice;

    Book book1("Crime and Punishment", "Fyodor Dostoevsky", "1112223334");
    Book book2("Don Quixote", "Miguel de Cervantes", "2223334445");
    Book book3("Pride and Prejudice", "Jane Austen", "3334445556");
    Book book4("Great Expectations", "Charles Dickens", "4445556667");
    Book book5("War and Peace", "Leo Tolstoy", "5556667778");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);
    library.addBook(book5);

    library.displayLibraryBooks();

    do {
        showMenu();
        std::cin >> choice;

        switch (choice) {
            case 1:
                addBookToLibrary(library);
            break;
            case 2:
                deleteBookFromLibrary(library);
            break;
            case 3:
                library.displayLibraryBooks();
            break;
            case 4:
                std::cout << "Program Stopped\n";
            break;
            default:
                std::cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 4);
}
