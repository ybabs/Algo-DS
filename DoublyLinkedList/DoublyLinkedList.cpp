// DoublyLinkedList.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    Node* next;
    Node* prev;
};

Node* head;
Node* tail;

Node* createNewNode(int x)
{
    Node* temp = new Node();
    temp->data = x;
    temp->prev = NULL;
    temp->next = NULL;

    return temp;
}

void InsertAtHead(int x)
{
    Node* temp = createNewNode(x);

    if (head == NULL)
    {
        head = temp;
        return;
    } 

    head->prev = temp;
    temp->next = head;
    head = temp;

}

void InsertAtTail(int x)
{
    Node* temp = createNewNode(x);

    if (head == NULL)
    {
        temp->prev = NULL;
        head = temp;
        tail = temp;
        
        return;
    }


    temp->prev = tail;
    tail->next = temp;
    tail = temp;
      

}

void Print()
{
    Node* temp = head;
    printf("List is ");
    while (temp != NULL)
    {
        printf(" %d", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void ReversePrint()
{
    Node* temp = head;
    if (temp == NULL)
    {
        return;
    }

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    printf("Reverse Node:");
    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->prev;
    }

    printf("\n");

}


int main()
{

    head = NULL;
    tail = NULL;

    InsertAtTail(2);
    InsertAtTail(4);
    InsertAtTail(6);
    Print();

    
    head = NULL;
    tail = NULL;

    InsertAtHead(2);
    InsertAtHead(4);
    InsertAtHead(6);
    Print();

   
}

 