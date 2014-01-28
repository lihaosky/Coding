/* Find the head of loop of singly list and free the list */
#include <stdio.h>
#include <stdlib.h>

typedef struct node_ {
    int num;
    struct node_ *next;
} node;

node* append(node *head, node *new_node) {
    if (!head) {
        return new_node;
    }

    node *tail = head;
    while (tail->next) {
        tail = tail->next;
    }

    tail->next = new_node;
    return head;
}

void print_list(node *head) {
    while (head) {
        printf("%d ", head->num);
        head = head->next;
    }
    printf("\n");
}

node* find_loop_head(node *head) {
    node *slow_node = head;
    node *fast_node = head;

    if (!head) {
        return NULL;
    }

    do {
        if (slow_node) {
            slow_node = slow_node->next;
        } else {
            return NULL;
        }
        if (fast_node && fast_node->next) {
            fast_node = fast_node->next->next;
        } else {
            return NULL;
        }
    } while (slow_node != fast_node);

    fast_node = head;
    while (slow_node != fast_node) {
        slow_node = slow_node->next;
        fast_node = fast_node->next;
    }

    return slow_node;
}

void free_list(node *head) {
    node *next;
    node *loop_head;

    loop_head = find_loop_head(head);
    if (!loop_head) {
        while (head) {
            next = head->next;
            printf("Free %d ", head->num);
            free(head);
            head = next;
        }
        printf("\n");
    } else {
        while (head != loop_head) {
            next = head->next;
            printf("Free %d ", head->num);
            free(head);
            head = next;
        }
        head = loop_head->next;
        while (head != loop_head) {
            next = head->next;
            printf("Free %d ", head->num);
            free(head);
            head = next;
        }
        printf("Free %d\n", head->num);
        free(head);
    }
}

node* new_node(int num) {
    node *anode = malloc(sizeof(node));
    if (!anode) {
        return NULL;
    }
    anode->num = num;
    anode->next = NULL;
    
    return anode;
}

int main() {
    node *head = new_node(1);
    append(head, new_node(2));
    append(head, new_node(3));
    append(head, new_node(4));
    append(head, new_node(5));
    node *node6 = new_node(6);
    append(head, node6);
    append(head, new_node(7));
    append(head, new_node(8));
    append(head, new_node(9));
    node *node10 = new_node(10);
    append(head, node10);
    node10->next = node6;

//    print_list(head);

    node *loop_head = find_loop_head(head);
    if (loop_head) {
        printf("Loop head is %d\n", loop_head->num);
    }
    free_list(head);
    
    return 0;
}










