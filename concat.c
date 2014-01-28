#include <stdio.h>
#include <string.h>

void concat(char *dest, const char *src) {
    char *end = dest + strlen(dest);
    while (*src) {
        *end++ = *src++;
    }
    *end = '\0';
}

void main() {
    char str[10] = "lihaosky";
    char str1[] = "l";
    concat(str, str1);
    puts(str);
}
