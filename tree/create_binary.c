/* Create a bst from sorted array */

#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

node* balance_tree(int array[], int start, int end) {
    if (start > end) {
        return NULL;
    }
    int mid = (end - start) / 2 + start;
    node *new_node = malloc(sizeof(node));
    if (!new_node) {
        return NULL;
    }

    new_node->num = array[mid];
    new_node->left = balance_tree(array, start, mid - 1);
    new_node->right = balance_tree(array, mid + 1, end);

    return new_node;
}

void print_tree(node *root) {
    if (!root) {
        return;
    }
    print_tree(root->left);
    printf("%d ", root->num);
    print_tree(root->right);
}

int main() {
    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    node *root = balance_tree(array, 0, sizeof(array) / sizeof(int) - 1);
    print_tree(root);
    return 0;
}


