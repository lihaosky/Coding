#include <stdio.h>
#include <string.h>

void reverse(char *str) {
    char *end = str + strlen(str) - 1;
    while (str < end) {
        char tmp = *end;
        *end = *str;
        *str = tmp;
        end--;
        str++;
    }
}

void main() {
    char str[] = "what do you want";
    reverse(str);
    puts(str);
}
