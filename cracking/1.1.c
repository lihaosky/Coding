#include <stdio.h>
#include <string.h>

int isUnique(char *str) {
    if (!str) {
        return 1;
    }
    int i, j;
    for (i = 0; i < strlen(str); i++) {
        for (j = i + 1; j < strlen(str); j++) {
            if (str[i] == str[j]) {
                return 0;
            }
        }
    }
    return 1;
}

int main() {
    printf("%d\n", isUnique("abcd"));
    printf("%d\n", isUnique("a"));
    printf("%d\n", isUnique("aa"));
    printf("%d\n", isUnique(NULL));
    return 0;
}
