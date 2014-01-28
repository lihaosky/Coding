#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void swap(int *a, int *b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

int partition(int a[], int l, int u) {
    int pivot = a[u];
    int i = l - 1;
    int j;

    for (j = l; j < u; j++) {
        if (a[j] < pivot) {
            i++;
            swap(&a[i], &a[j]);
        }
    }
    swap(&a[i + 1], &a[u]);
    return i + 1;
}

void quick_sort(int a[], int l, int u) {
    if (l >= u) {
        return;
    }
    int p = partition(a, l, u);
    quick_sort(a, l, p - 1);
    quick_sort(a, p + 1, u);
}

void generate_array(int a[], int size) {
    int i;

    for (i = 0; i < size; i++) {
        a[i] = rand() % 1000;
    }
}

int main() {
    int i;
    int a[] = {3, 4, 1, 7, 4, 2};
    int b[100];

    quick_sort(a, 0, sizeof(a) / sizeof(int) - 1);
    generate_array(b, 100);
    quick_sort(b, 0, 99);

    for (i = 0; i < 100; i++) {
        printf("%d ", b[i]);
    }

    printf("\n");

    return 0;
}
