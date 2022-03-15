#include <iostream>
#include <stack>

struct stack {
    int size;
    int top;
    int* s;
};

bool isEmpty(stack* s)
{
    if (s->top == -1)
    {
        return true;
    }

    return false;
}

bool isFull(stack* s)
{
    if (s->top == s->size - 1)
    {
        return true;
    }

    return false;
}

void push(stack* s, int x)
{
    if (isFull(s) != true)
    {
        s->top++;
        s->s[s->top] = x;
    }
}

void pop(stack* s)
{
    if (isEmpty(s) != true)
    {
        s->top--;
    }
}

// Index of a position is top - pos +1
int peek(stack s, int pos)
{
    int x = -1;

    if (s.top - pos + 1 < 0)
    {
        std::cout << "Invalid position" << std::endl;
    }
    else
    {
        x = s.s[s.top - pos + 1];
    }

    return x;    
}

// use inbuilt struct here
bool checkParenthesis(std::string expr)
{
    std::stack<char> st;

    for (size_t i = 0; i< expr.length(); i++)
    {
        if (expr[i] == '(')
        {
            st.push(expr[i]);
        }

        else if (expr[i] == ')')
        {
            if (st.empty() != true)
            {
                st.pop();
            }

            else
            {
                return false;
            }
        }

    }

    if (st.empty() == true)
    {
        return true;
    }

    return false;
}

int top(stack s)
{
    if (isEmpty(&s))
    {
        return -1;
    }

    else
    {
        return s.s[s.top];
    }
}
int main()
{
    //stack st;
    //st.size = 100;
    //st.s = new int[st.size];
    //st.top = -1;

    std::string s = "((a + b)";

    bool val = checkParenthesis(s);

    std::cout << val << std::endl;

    return 0;
}

