#include <stdio.h>
#include <string.h>

void move(char *str, int j) {
    for (; j < strlen(str); j++) {
        str[j] = str[j + 1];
    }
}
void remove_dup(char *str) {
    int pos = 0;
    int i, j;

    for (i = 0; str[i]; i++) {
        for (j = i + 1; j < strlen(str); j++) {
            if (str[i] == str[j]) {
                move(str, j);
            }
        }
    }
}

void remove_dup1(char *str) {
    if (strlen(str) < 2) {
        return;
    }

    int tail = 1;
    int i, j;

    for (i = 1; i < strlen(str); i++) {
        for (j = 0; j < tail; j++) {
            if (str[i] == str[j]) {
                break;
            }
        }
        if (j == tail) {
            str[tail] = str[i];
            tail++;
        }
    }
    str[tail] = '\0';
}

void main() {
    char str[] = "what is this? I don't know";
    remove_dup1(str);
    puts(str);
}
    
