// Linear time submax
#include <stdio.h>

int submax(int a[], int size) {
    int i, submax, tmpmax;
    int is_included;
    int l_index, h_index;

    if (size <= 0) {
        return 0;
    }

    i = 0;
    submax = a[0];
    tmpmax = a[0];
    l_index = h_index = 0;
    is_included = 1;

    for (i = 1; i < size; i++) {
        if (is_included) {
            if (a[i] >= 0) {
                is_included = 1;
                h_index = i;
                submax += a[i];
                tmpmax += a[i];
            } else {
                is_included = 0;
                tmpmax += a[i];
            }
        } else {
            if (tmpmax >= 0) {
                if (tmpmax + a[i] >= submax) {
                    submax = tmpmax + a[i];
                    tmpmax = submax;
                    is_included = 1;
                    h_index = i;
                } else {
                    tmpmax += a[i];
                    is_included = 0;
                }
            } else {
                if (a[i] >= submax) {
                    l_index = h_index = i;
                    submax = a[i];
                    tmpmax = a[i];
                    is_included = 1;
                } else {
                    tmpmax += a[i];
                    is_included = 0;
                }
            }
        }
    }

    printf("Low index is %d, high index is %d\n", l_index, h_index);
    return submax;
}

// Max can be negtive
int submax1(int a[], int size) {
    int begin, end, begin_tmp;
    int i;
    int max_so_far, max_ending_here;

    max_so_far = max_ending_here = a[0];
    begin = end = begin_tmp = 0;

    for (i = 1; i < size; i++) {
        if (max_ending_here < 0) {
            max_ending_here = a[i];
            begin_tmp = i;
        } else {
            max_ending_here += a[i];
        }
        if (max_ending_here >= max_so_far) {
            max_so_far = max_ending_here;
            begin = begin_tmp;
            end = i;
        }
    }

    printf("Begin is %d, end is %d\n", begin, end);
    return max_so_far;
}


int main() {
    int a[] = {-1, -5, 6, 7, -12, 18, -2, 3};
    printf("%d\n", submax(a, sizeof(a) / sizeof(int)));
    printf("%d\n", submax1(a, sizeof(a) / sizeof(int)));
}
