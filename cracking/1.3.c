#include <stdio.h>
#include <string.h>

char* remove_dup(char *str) {
    int free_pos = 0;
    int i, j;
    for (i = 0; i < strlen(str); i++) {
        for (j = 0; j < i; j++) {
            if (str[i] == str[j]) {
                break;
            }
        }
        if (j == i) {
            str[free_pos] = str[j];
            free_pos++;
        }
    }
    str[free_pos] = '\0';
    return str;
}

int main() {
    char str[] = "aaaaaa";
    char str1[] = "a";
    char str2[] = "";
    char str3[] = "abcdef";
    char str4[] = "abcccddeeffa";
    puts(remove_dup(str));
    puts(remove_dup(str1));
    puts(remove_dup(str2));
    puts(remove_dup(str3));
    puts(remove_dup(str4));
    return 0;
}
