#include <iostream>
#include <string>

using namespace std;

class assign {
    public:
    string name;
    assign(int a, char b) {
        name = a;
        cout << "here" << endl;
    }
    assign(const char *s) {
        name = s;
    }
    string& operator=(const char *s) {
        name = s;
    }
};

struct mystruct {
    int a;
    int b;
};

int main() {
    string s = "lihaosky";
    const char *cstr = s.c_str();
    mystruct b = {1, 2};
    cout << b.a << " " << b.b << endl;
    cout << s + "123" << endl;
    return 0;
}
