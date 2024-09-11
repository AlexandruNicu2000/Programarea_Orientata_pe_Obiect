#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Book {
    private:
        string Title;
        string Author;
        string ISBN;
    public:

    Book(std::string_view t, std::string_view a, std::string_view i): Title(t), Author(a), ISBN(i) {}


        string getTitle() const {
            return Title;
        }
        string getAuthor() const {
            return Author;
        }
        string getISBN() const {
            return ISBN;
        }

        void displayBook() const {
            cout << "Titlu: " << Title << ", Autor: " << Author << ", ISBN: " << ISBN << endl;
        }
};

class Library {
    private:
        vector<Book> books;
    public:
        void addBook(const Book& book) {
            books.push_back(book);
        }

        void deleteBook(const string& isbn) {
            for(auto it = books.begin(); it != books.end(); ++it) {
                if(it->getISBN() == isbn) {
                    cout<<"Cartea "<<it->getTitle()<<" a fost staersa"<<endl;
                    books.erase(it);
                }
            }
        }
        void displayLibrary() const {
            cout << "Books:" << endl;
                for (const auto& book : books) {
                    book.displayBook();
                }
        }
};

void displayMenu() {
    cout << "\nMeniu:" << endl;
    cout << "1. Adauga o carte" << endl;
    cout << "2. Afisează lista de carti" << endl;
    cout << "3. Sterge o carte după ISBN" << endl;
    cout << "4. Iesi din program" << endl;
}
void addBookLibrary(Library& library) {
    string title, author, isbn;
    cout << "Introdu titlul cartii: ";
    cin.ignore();
    getline(cin, title);
    cout << "Introdu autorul cartii: ";
    getline(cin, author);
    cout << "Introdu ISBN-ul cartii: ";
    getline(cin, isbn);
    Book newBook(title, author, isbn);
    library.addBook(newBook);

}
void removeBookLibrary(Library& library) {
    string isbn;
    cout << "Introdu ISBN-ul cartii: ";
    cin.ignore();
    getline(cin, isbn);
    library.deleteBook(isbn);
}
int main() {
    Library library;
    int option;
    bool running = true;

    Book book1("Crima si pedeapsa", "Fiodor Dostoievski", "1112223334");
    Book book2("Don Quijote", "Miguel de Cervantes", "2223334445");
    Book book3("Mandrie si prejudecata", "Jane Austen", "3334445556");
    Book book4("Marile sperante", "Charles Dickens", "4445556667");
    Book book5("Razboi si pace", "Lev Tolstoi", "5556667778");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);
    library.addBook(book5);

    library.displayLibrary();



    while (running) {
        displayMenu();
        cin >> option;

        switch (option) {
            case 1:
                addBookLibrary(library);
            break;

            case 2:
                library.displayLibrary();
            break;

            case 3:
                removeBookLibrary(library);
            break;

            case 4:
                running = false;
            break;

            default:
                cout << "Optiune invalida" << endl;
            break;
        }
    }
}
