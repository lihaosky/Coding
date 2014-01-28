#include <iostream>

using namespace std;

class Base {
public:
    Base() { cout << "Constructor called" << endl; }
    virtual ~Base() { cout << "Destructor called" << endl; }
};

class Derived : public Base {
public:
    Derived() { cout << "Derived constructor called" << endl; }
    ~Derived() { cout << "Derived destructor called" << endl; }
};

int main() {
    Base *ptr = new Derived();
    delete ptr;
}
