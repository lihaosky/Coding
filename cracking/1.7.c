#include <stdio.h>


int main() {
    int *(a)[4];
    printf("%0xu\n", a);
    printf("%0xu\n", a + 1);
    return 0;
}
