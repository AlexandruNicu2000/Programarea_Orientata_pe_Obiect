#include <iostream>
#include <string>

class Vehicul {
public:
    Vehicul(const std::string& marca) : marca_(marca) {}

    void afiseazaMarca() const {
        std::cout << "Marca vehiculului: " << marca_ << std::endl;
    }

protected:
    std::string marca_;
};


class Masina : public Vehicul {
public:
    Masina(const std::string& marca, int an) : Vehicul(marca), an_(an) {}

    void afiseazaDetalii() const {
        std::cout << "Masina " << marca_ << " este din anul " << an_ << std::endl;
    }

private:
    int an_;
};


class Persoana {
public:
    Persoana(const std::string& nume, int varsta)
        : nume_(nume), varsta_(varsta) {
        std::cout << "Constructor pentru " << nume_ << ", " << varsta_ << " ani.\n";
    }

    ~Persoana() {
        std::cout << "Destructor pentru " << nume_ << ".\n";
    }

private:
    std::string nume_;
    int varsta_;
};

class ContBancar {
public:
    ContBancar(const std::string& nume, double sold)
        : nume_(nume), sold_(sold) {}

    friend void afiseazaDetalii(const ContBancar& cont);

private:
    std::string nume_;
    double sold_;
};

void afiseazaDetalii(const ContBancar& cont) {
    std::cout << "Nume: " << cont.nume_ << "\n";
    std::cout << "Sold: " << cont.sold_ << "\n";
}

int main() {
    Vehicul vehicul("General");
    Masina masina("Dacia", 2023);

    vehicul.afiseazaMarca();
    masina.afiseazaDetalii();


    Persoana p("Ion", 30);


    ContBancar cont("Ana", 1500.0);
    afiseazaDetalii(cont);
}
