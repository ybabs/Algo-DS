#include <stdlib.h>
#include <stdio.h>
#include <iostream>

struct Node {
	int data;
	struct Node* next; // stores address to the next node
};

Node* head;

void InsertatPos(Node** head, int data, int n)
{

	Node* temp_node = new Node();
	temp_node->data = data;
	temp_node->next = NULL;

	// If inserting at the head
	if( n == 1)
	{
		temp_node->next = *head;
		*head = temp_node;
		return;
	}

	Node* temp2 = *head;
	for (int i = 0; i < n - 2; i++)
	{
		temp2 = temp2->next;
	}

	temp_node->next = temp2->next;
	temp2->next = temp_node;

}

void Print(Node *head)
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

void PrintRecursively(Node* head)
{
	if (head == NULL)
	{
		return;
	}
	printf("%d ", head->data);
	PrintRecursively(head->next);
	//printf("%d ", head->data);
}
// Delete a node at a given position
void DeleteNode(Node** head, int n)
{
	Node* temp1 = *head;

	// check if we're at the head
	if (n == 1)
	{
		*head = temp1->next; // head now points to the second node
		delete temp1;
		return;
	}

	for (int i = 0; i < n - 2; i++)
	{
		temp1 = temp1->next;
	}
	// point to the n-1th node
	Node* temp2 = temp1->next; 
	temp1->next = temp2->next;  // (n+1) node.
	
	delete temp2;

}


void Create(int A[], int n)
{
	Node* temp;
	Node* tail = new Node();

	head = new Node();

	// First Node;
	head->data = A[0];
	head->next = NULL;
	tail = head;

	for (int i = 1; i < n; i++)
	{
		temp = new Node();
		temp->data = A[i];
		temp->next = NULL;
		tail->next = temp;
		tail = temp;
	}
	
}


Node* CreateNewNode(int A[], int n)
{
	Node* temp;
	Node* tail = new Node();

	Node* new_node = new Node();

	// First Node;
	new_node->data = A[0];
	new_node->next = NULL;
	tail = new_node;

	for (int i = 1; i < n; i++)
	{
		temp = new Node();
		temp->data = A[i];
		temp->next = NULL;
		tail->next = temp;
		tail = temp;
	}

	return new_node;

}

void Insert(Node* head, int pos, int data)
{
	// Create a new node for the position
	Node* t = new Node();

	// create another temporary node p
	Node* p = new Node();

	if (pos == 0)
	{
		t->data = data;
		t->next = head;
		head = t;
	}

	else if (pos > 0)
	{
		p = head;
		// Advance p to the position you are trying to insert to
		for (int i = 0; i < pos - 1; i++)
		{
			p = p->next;
		}

		if (p != NULL)
		{
			t->data = data;
			// make Node t->next point to p-> next
			t->next = p->next;
			// Make p->next equal to t to complete the link
			p->next = t;
		}

	}

}

int GetLength(Node* head)
{
	int length = 0;
	while (head != NULL)
	{
		length++;
		head = head->next;
	}
	return length;
}

int SumofElements(Node* head)
{
	int sum = 0;
	while (head != NULL)
	{
		sum += head->data;
		head = head->next;
	}
	return sum;
}

int Max(Node* head)
{
	int max = 0;

	while (head != NULL)
	{
		if (head->data > max)
		{
			max = head->data;
		}

		head = head->next;
	}

	return max;
}

Node* Search(Node* head, int key)
{
	while (head != NULL)
	{
		if (key == head->data)
		{
			return head;
		}
		head = head->next;
	}

	return NULL;
}


Node* SearchMoveToHead(Node* p, int key)
{
	Node* q = NULL;

	while(head!=NULL)
	{
		if (key == p->data)
		{
			q->next = p->next;
			p->next = head;
			head = p;
			return p;
		}
		q = p;
		p = p->next;
	}
	return NULL;
}

void InsertAtLast(Node* head, int x)
{
	Node* t = new Node();
	Node* tail = new Node();
	Node* p = new Node();
	t->data = x;
	t->next = NULL;

	if (head == NULL)
	{
		head = tail = t;
	}
	p = head;
	while (p!= NULL)
	{
		tail = p;
		p = p->next;
	}

	tail->next = t;
	tail = t;	
}

void Delete(Node** head, int n)
{
	Node* p = new Node();
	Node* q = new Node();
	p = *head;

	if (n == 1)
	{
		*head = p->next;
		delete p;
	}

	for (int i = 0; i < n - 1; i++)
	{
		q = p;
		p = p->next;
	}

	q->next = p->next;
	delete p;



}

bool IsSorted(Node** head)
{
	int node_data = -32768;
	Node* p = new Node;
	p = *head;

	while (p != NULL)
	{
		if (p->data > node_data)
		{
			node_data = p->data;
			p = p->next;
		}

		else
		{
			return false;
		}

	}

	return true;
}

void RemoveDuplicates(Node** head)
{
	// Need two pointers for this
	Node* p = *head;
	Node* q = (*head)->next;

	
	while (q!= NULL)
	{
		if (p->data != q->data)
		{
			p = q;
			q = q->next;
		}

		else
		{
			p->next = q->next;
			delete q;
			q = p->next;
		}
	}


}

Node * Concatenate(Node* p, Node* q)
{
	Node* t = p;
	while (t->next != NULL)
	{
		t = t->next;
	}
	t->next = q;
	q = NULL;

	return p;
}

Node* Merge(Node* p, Node* q)
{
	Node* third_node;
	Node* last_node;

	if (p->data < q->data)
	{
		third_node = last_node = p;
		// advance p
		p = p->next;
		// Make last_node next NULL for now
		last_node->next = NULL;
	}
	else
	{
		third_node = last_node = q;
		q = q->next;
		last_node->next = NULL;
	}

	while (p != NULL && q!= NULL)
	{
		if (p->data < q->data)
		{
			last_node->next = p;
			last_node = p;
			p = p->next;
			last_node->next = NULL;
		}

		else
		{
			last_node->next =q;
			last_node = q;
			q = q->next;
			last_node->next = NULL;
		}
	}

	if (p != NULL)
	{
		last_node->next = p;
	}
	else
	{
		last_node->next = q;
	}
	return third_node;
}
 
void Reverse(Node** head)
{
	Node* p = *head;
	Node* q = NULL;
	Node* r = NULL;

	while (p!= NULL)
	{
		r = q;
		q = p;
		p = p->next; 
		q->next = r;
	}
	// Point first node to the q pointer
	*head = q;
}

int main()
{

	int A[] = { 3,5,7,15,15 };
	int B[] = { 2,5,7,12,20 };
	
	Node * a = CreateNewNode(A, 5);
	Node * b = CreateNewNode(B, 5);

	Node* mergedList = Merge(a, b);
	//PrintRecursively(head);
	//int l = Max(head);
	//SearchMoveToHead(head, 20);

	//Insert(head, 4, 12);
	//InsertAtLast(head, 25);
	//Delete(&head, 5);

	//bool val = IsSorted(&head);
	//std::cout << val << std::endl;

	//RemoveDuplicates(&head);
	Print(mergedList);

	delete head;

   	return 0;


}
