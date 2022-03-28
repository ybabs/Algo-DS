// AVLTrees.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
struct Node
{
    struct Node* lchild;
    struct Node* rchild;
    int data;
    int height;   // height of a node
};

Node* root = NULL;

int NodeHeight(Node* p)
{
    int hl, hr;
    hl = p && p->lchild ? p->lchild->height : 0;
    hr = p && p->rchild ? p->rchild->height : 0;

    return hl > hr ? hl + 1 : hr + 1;
}

int BalanceFactor(Node* p)
{
    int hl, hr;
    hl = p && p->lchild ? p->lchild->height : 0;
    hr = p && p->rchild ? p->rchild->height : 0;

    return hl - hr;
}


Node * LLRotation(Node *p)
{
    Node* pl = p->lchild;
    Node *plr = pl->rchild;

    pl->rchild = p;
    p->lchild = plr;
    p->height = NodeHeight(p);
    pl->height = NodeHeight(pl);

    if (root == p)
    {
        root = pl;
    }

    // New Root;
    return pl;
}

Node* LRRotation(Node* p)
{
    Node* pl = p->lchild;
    Node* plr = pl->rchild;
    
    pl->rchild = plr->lchild;
    p->lchild = plr->rchild;

    plr->lchild = pl;
    plr->lchild = p;

    pl->height = NodeHeight(pl);
    p->height = NodeHeight(p);
    plr->height = NodeHeight(plr);

    if (root == p)
    {
        root = plr;
    }

    return plr;



}

Node* RLRotation(Node* p)
{
    return NULL;
}

Node* RRRotation(Node* p)
{
    return NULL;
}

Node* Insert(Node* p, int key)
{
    Node* t = NULL;

    if (p == NULL)
    {
        t = new Node();
        t->data = key;
        t->height = 1;
        t->lchild = t->rchild = NULL;
        return t;
    }

    if (key < p->data)
    {
        p->lchild = Insert(p->lchild, key);
    }
    else if (key > p->data)
    {
        p->rchild = Insert(p->rchild, key);
    }
    p->height = NodeHeight(p);

    // check balance factor of tree and check to see if the left child balance factor is equal to 1
    // This is needed to perform LL rotation
    if(BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == 1)
    {
        return LLRotation(p);
    }

    else if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == -1)
    {
        return LRRotation(p);
    }

    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == -1)
    {
        return RRRotation(p);
    }

    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == -1)
    {
        return RLRotation(p);
    }
    return p;
}
int main()
{
    root = Insert(root, 10);
    Insert(root, 5);
    Insert(root, 2);


    std::cout << "Hello World!\n";
}
