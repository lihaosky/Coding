#include <iostream>

using namespace std;

template<class T>
void sort(T array[], bool compare(T, T)) {
    cout << compare(array[0], array[1]) << endl;
}

bool cmp(int a, int b) {
    return a < b;
}

int main() {
    int array[] = {1, 2, 4, 5};
    sort(array, cmp);
    
    return 0;
}
