#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int is_anagram(const char *str1, const char *str2) {
    if (strlen(str1) != strlen(str2)) {
        return 0;
    }
    const int size = 'z' + 1;
    int count1[size];
    int count2[size];
    int i;
    memset(count1, 0, sizeof(int) * size);
    memset(count2, 0, sizeof(int) * size);
    for (i = 0; i < strlen(str1); i++) {
        count1[str1[i]]++;
        count2[str2[i]]++;
    }
    for (i = 0; i < strlen(str1); i++) {
        if (count1[str1[i]] != count2[str1[i]]) {
            return 0;
        }
    }
    return 1;
}

int main() {
    printf("%d\n", is_anagram("abcd", "dbac"));
    printf("%d\n", is_anagram("aabbcc", "abcabc"));
    printf("%d\n", is_anagram("aabc", "aabd"));
    return 0;
}
