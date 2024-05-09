package Assignment1;

import java.util.EmptyStackException;

public class ListStack implements BKStack
{
    private Node head, tail;
    int size=0;

    public ListStack()//initializes the tail of the list as null
    {
        tail = null;
    }

    public boolean isEmpty() //returns a boolean value of whether or not stack is empty; 0(1)
    {
        return head == null;
    }

    public int count()//returns the size of the list O(1)
    {
        return size;
    }

    public void push(double d) //the pointer is set to the current tail  and tail is reassigned to the node created, 
    						   //if the list is empty, meaning there is no next node and it's simply the head; O(1)
    
    {
        Node node = new Node(d,null);
        if(head == null)
            tail = head = node;
        else 
        {
            node.setNext(tail);
            tail = node;
        }
        size++;
    }
    
    //This method removes the top of the stack node
    // If this stack is not empty, the head is set to the current heads next node and size is decremented
   //O(1)

    public double pop()
    {
        if(isEmpty())
            throw new EmptyStackException();
        else 
        {
           
            Node temp = tail;
            tail = tail.getNext();
           // temp.setNext(null);
            size--;
            return temp.getData();
        }

      
        
    }
    public double peek() //O(1)
    {
        double d;
        if(isEmpty())
            throw new EmptyStackException();
        else 
        {
            d = tail.data;
        }

        return d;
    }

}
