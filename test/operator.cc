#include <iostream>
#include <string>

using namespace std;

class Base {
public:
    Base(string message) {
        msg = message;
    }
    void print() {
        cout << msg << endl;
    }
private:
    string msg;
};

template <class T>
class Operator {
public:
   Operator() : temp(0) {
        ref_count = new int(1);
   }

   Operator(T *data) : temp(data) {
       ref_count = new int(1);
   }

   Operator(const Operator<T>& op) : temp(op.temp){
       ref_count = op.ref_count;
       (*ref_count)++;
   }

   ~Operator() {
       (*ref_count)--;
       if (*ref_count == 0) {
           delete ref_count;
           delete temp;
       }
   }

   Operator& operator=(const Operator<T>& op) {
       if (this != &op) {
           (*ref_count)--;
           if (*ref_count == 0) {
               delete ref_count;
               delete temp;
           }
           ref_count = op.ref_count;
           temp = op.temp;
           (*ref_count)++;
       }
       return *this;
   }

   T* operator->() {
       return temp;
   }

   T& operator*() {
       return *temp;
   }

   int get_ref() {
       return *ref_count;
   }

private:
    T *temp;
    int *ref_count;
};

int main() {
    Operator<Base> o(new Base("what is this"));
    Operator<Base> p = o;
    o->print();
    p->print();
    cout << p.get_ref() << endl;
    Operator<Base> s;
    p = s;
    cout << p.get_ref() << endl;
    cout << o.get_ref() << endl;
    return 0;
}
