#include <stdio.h>

typedef struct block{
	int data;
	struct block *next;
} data_t;

data_t*
reverse_recursive(data_t *head) {
	data_t *tmp;
	if (!head || !head->next) {
		return head;
	}
    tmp = reverse_recursive(head->next);
	head->next->next = head;
	head->next = NULL;
	return tmp;
}

data_t*
reverse(data_t *head) {
	data_t *pre = NULL;
	if (!head) {
		return NULL;
	}
	while (head) {
		data_t *tmp = head->next;
		head->next = pre;
		pre = head;
		head = tmp;
	}
	return pre;
}

void 
print_list(data_t *head) {
	while (head) {
		printf("%d ", head->data);
		head = head->next;
	}
	printf("\n");
}

data_t*
new_data(int i) {
	data_t *data;
	
	data = malloc(sizeof(data_t));
	data->data = i;
	data->next = NULL;
}

int main() {
	data_t *head, *pre;
	int i;

	pre = NULL;
	for (i = 0; i < 10; i++) {
		head = new_data(i);
	    head->next = pre;
		pre = head;
	}

	print_list(head);
	head = reverse(head);
	print_list(head);

	return;
}
