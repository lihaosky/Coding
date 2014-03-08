#include <iostream>
#include <string>

using namespace std;

class base {
    public:
    virtual void foo() { 
        cout << "In base " << endl;
    }
};

class sub1 : public base {
    public:
    void foo() {
        cout << " In sub1 " << endl;
    }
};

class sub2 : public base {
    public:
    void foo() {
        cout << " In sub2 " << endl;
    }
};

void fun(base b) {
    b.foo();
}

int main() {
    sub1 s1;
    s1.foo();
    ((base)s1).foo();
    fun(s1);
    return 0;
}
