#include <stdio.h>
#include <stdlib.h>

int steps = 0;
void hanoi(int n, char *from, char *to, char *via) {
    if (n > 0) {
        hanoi(n - 1, from, via, to);
        steps++;
        printf("Move disk %d from %s to %s\n", n, from, to);
        hanoi(n - 1, via, to, from);
    }
}

int main() {
    hanoi(10, "A", "B", "C");
    printf("Total steps is %d\n", steps);
    return 0;
}
