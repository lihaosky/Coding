#include <iostream>

using namespace std;

class Foo {
    public:
        Foo(int a) {}
};

class Bar {
    private:
        Foo f;

    public:
        Bar(int a) { f(a);}
};

int main() {
    Foo f(10);
    return 0;
}
