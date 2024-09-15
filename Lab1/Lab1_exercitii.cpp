#include <iostream>
#include <string>

class Vehicle {
public:
    Vehicle(const std::string& mark) : marca_(mark) {}

    void displayMark() const {
        std::cout << "Marca vehiculului: " << marca_ << std::endl;
    }

protected:
    std::string marca_;
};


class Car : public Vehicle {
public:
    Car(const std::string& marca, int year) : Vehicle(marca), an_(year) {}

    void displayVehicleDetails() const {
        std::cout << "Masina " << marca_ << " este din anul " << an_ << std::endl;
    }

private:
    int an_;
};


class Person {
public:
    Person(const std::string& name, int age)
        : nume_(name), age_(age) {
        std::cout << "Constructor pentru " << nume_ << ", " << age_ << " ani.\n";
    }

    ~Person() {
        std::cout << "Destructor pentru " << nume_ << ".\n";
    }

private:
    std::string nume_;
    int age_;
};

class BankAccount {
public:
    BankAccount(const std::string& name, double balance)
        : nume_(name), sold_(balance) {}

    friend void displayBankDetails(const BankAccount& cont);

private:
    std::string nume_;
    double sold_;
};

void displayBankDetails(const BankAccount& cont) {
    std::cout << "Nume: " << cont.nume_ << "\n";
    std::cout << "Sold: " << cont.sold_ << "\n";
}

int main() {
    Vehicle vehicul("General");
    Car masina("Dacia", 2023);

    vehicul.displayMark();
    masina.displayVehicleDetails();


    Person p("Ion", 30);


    BankAccount cont("Ana", 1500.0);
    displayBankDetails(cont);
}
