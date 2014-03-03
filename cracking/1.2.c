#include <stdio.h>
#include <string.h>

char* reverse(char *str) {
    char *start = str;
    char *end = str + strlen(str) - 1;
    while (start < end) {
        char tmp = *start;
        *start = *end;
        *end = tmp;
        start++;
        end--;
    }
    return str;
}

int main() {
    char const_str[] = "abcd";
    char str1[] = "l";
    puts(reverse(const_str));
    puts(reverse(str1));
    return 0;
}
