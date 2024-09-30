#include <iostream>
#include <string>


//Mostenire
class Vehicle {
protected:
    std::string marca;
public:
    Vehicle(const std::string& mark) : marca(mark) {}

    void displayMark() const {
        std::cout << "Marca vehiculului: " << marca << std::endl;
    }


};

class Car : public Vehicle {
private:
    int an;

public:
    Car(const std::string& marca, int year) : Vehicle(marca), an(year) {}

    void displayVehicleDetails() const {
        std::cout << "Masina " << marca << " este din anul " << an << std::endl;
    }
};


//Destructor
class Person {
private:
    std::string nume;
    int age;
public:
    Person(const std::string& name, int age): nume(name), age(age) {}

    ~Person() {
        std::cout << "Destructor pentru " << nume << ".\n";
    }
};

//Friend
class BankAccount {
private:
    std::string ID;
    double balance;
public:
    BankAccount(const std::string& name, double balance): ID(name), balance(balance) {}

    friend void displayBankDetails(const BankAccount& account);

    friend class BankClient;
};

class BankClient {
private:
    std::string clientName;
public:
    BankClient(const std::string& clientName): clientName(clientName) {}
    void displayClientBalance(const BankAccount& account);
};

void displayBankDetails(const BankAccount& account) {
    std::cout << "ID: " << account.ID << "\n";
}

void BankClient::displayClientBalance(const BankAccount& account) {
    std::cout << "Account balance: " << account.balance << std::endl;
}


int main() {
    Vehicle vehicle("General");
    Car car("Dacia", 2023);

    vehicle.displayMark();
    car.displayVehicleDetails();

    Person p("Ion", 30);

    BankClient client("Ana");
    BankAccount account("1313131312", 1500.0);
    displayBankDetails(account);
    client.displayClientBalance(account);
}
