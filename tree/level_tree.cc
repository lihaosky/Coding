#include "tree.h"
#include <iostream>
#include <queue>
#include <set>

using namespace std;

void print_level(node *root) {
    queue<node*> node_queue;
    set<node*> visited;
    int cur_level = 0;
    int next_level = 0;

    node_queue.push(root);
    visited.insert(root);
    cur_level++;

    while (!node_queue.empty()) {
        node *tmp_node = node_queue.front();
        node_queue.pop();
        cur_level--;
        cout <<  tmp_node->num << " ";
        if (tmp_node->left && visited.find(tmp_node->left) == visited.end()) {
            visited.insert(tmp_node->left);
            node_queue.push(tmp_node->left);
            next_level++;
        }
        if (tmp_node->right && visited.find(tmp_node->right) == visited.end()) {
            visited.insert(tmp_node->right);
            node_queue.push(tmp_node->right);
            next_level++;
        }
        if (!cur_level) {
            cout << endl;
            cur_level = next_level;
            next_level = 0;
        }
    }
}

int main() {
    node *root = new node;
    node *node1 = new node;
    node *node2 = new node;
    node *node3 = new node;

    root->num = 5;
    root->left = node1;
    root->right = node2;
    node1->num = 4;
    node1->left = node3;
    node1->right = NULL;
    node2->num = 6;
    node2->left = node2->right = NULL;
    node3->num = 2;
    node3->left = node3->right = NULL;

    print_level(root);
}

    
