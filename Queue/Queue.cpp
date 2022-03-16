#include <iostream>

// Two methods, you can either implement using array or Linked lists

// Array Method (circular queue)
struct Queue
{
    int size;
    int front;  // front pointer. used for deletion
    int rear;   // rear pointer, used for insertion
    int* Q;     // used to dynamically allocate space into the array
};

bool isQueueFull(Queue* q)
{
    if ((q->rear + 1) % q->size == q->front)
    {
        return true;
    }

    return false;
}

bool isQueueEmpty(Queue* q)
{
    if (q->rear == q->front)
    {
        return true;
    }

    return false;
}


void enqueue(Queue* q, int x)
{
    if (isQueueFull(q) != true)
    {
        q->rear = (q->rear+1) % q->size++;
        q->Q[q->rear] = x;
    }
}

int dequeue(Queue* q)
{
    int x = -1;

    if (isQueueEmpty(q) != true)
    {
        q->front = (q->front+1) % q->size;
        x = q->Q[q->front];
    }

    return x;

}

void resetPointer(Queue* q)
{
    if (isQueueEmpty(q) == true)
    {
        q->front = q->rear = -1;
    }
}

// Queue Method
struct Node
{
    int data;
    Node* next;
};

Node* front = NULL;
Node* rear = NULL;

bool QueueEmpty(Node* q)
{
    if (q == NULL)
    {
        return true;
    }
}

// Only way you run out of space is if heap gets full
bool QueueFull()
{
    Node* t = new Node();

    if (t == NULL)
    {
        return true;
    }

    return false;
}

void QueueEnqueue(int x)
{
    Node* t = new Node();
    if (QueueFull() != true)
    {
        t->data = x;
        t->next = NULL;
        if (front == NULL)
        {
            front = rear = t;
        }

        else
        {
            rear->next = t;
            rear = t;     
        }
    }
}

int QueueDequeue(Node * q)
{
    int x = -1;
    Node* p;

    if (QueueEmpty(q) != true)
    {
        p = front;
        front = front->next;
        x = p->data;
        delete p;

    }

    return x;

}



int main()
{
    // Initialising
    Queue q;

    q.size = 10;
    q.front = q.rear = -1;
    q.Q = new int[q.size];


    std::cout << "Hello World!\n";
}

