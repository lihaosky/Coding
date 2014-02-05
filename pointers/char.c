#include <stdio.h>

int foo(int *array) {
	return 0;
}

int main() {
	char str[] = "lihaosky";
	int a[10];
	int i, j;
	int *p = &a[0];
	a[0] = 10;
	a[1] = 100;
	printf("%p\n", a);
	printf("%p\n", &a[0]);
	printf("%p\n", &a);
	printf("%p\n", *(&a));
	printf("%d\n", p[0]);
	printf("%d\n", p[1]);
	foo(a);
	puts(str);
	for (i = 0; i < 10; i++) {
		j = 10;
	}
	return 0;
}
