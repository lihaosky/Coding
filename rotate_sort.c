#include <stdio.h>
#include <stdlib.h>

int search(int array[], int l, int u, int x) {
    while (l <= u) {
        int mid = (u - l) / 2 + l;
        if (x == array[mid]) {
            return mid;
        }
        if (array[mid] >= array[l] && x < array[mid]) {
            u = mid - 1;
        } else if (array[u] >= array[mid] && x > array[mid]) {
            l = mid + 1;
        } else if (array[mid] < array[l]) {
            u = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return -1;
}

int main() {
    int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 17};

    printf("%d\n", search(a, 0, sizeof(a) / sizeof(int) - 1, 5));

    printf("%d\n", search(a, 0, sizeof(a) / sizeof(int) - 1, 4));
    

    return 0;
}

