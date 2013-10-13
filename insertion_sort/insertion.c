/* Insertion sort */

#include <stdio.h>

void insertion_sort(int array[], int size) {
    int i, j;
    int key;

    for (i = 1; i < size; i++) {
        key = array[i];
        j = i - 1;
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = key;
    }
}

int main() {
    int a[] = {12, 9, 8, 6, 4, 13, 76};
    int i;

    insertion_sort(a, sizeof(a) / sizeof(int));

    for (i = 0; i < sizeof(a) / sizeof(int); i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}
    

