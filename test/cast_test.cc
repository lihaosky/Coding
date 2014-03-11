#include <iostream>
#include <typeinfo>

int main() {
    int *a, b;
    a = 0;
    b = 0;
    std::cout << typeid(a).name() << " " << typeid(b).name() << std::endl;
    return 0;
}
