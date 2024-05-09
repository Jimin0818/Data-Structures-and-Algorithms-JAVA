package Assignment1;
import java.util.Iterator;

import Assignment1.Node;

public class Node implements Iterator <Node> {

	        double data;
	        private Node next;

	        public Node(double data, Node next) //constructor : O(1)
	        {
	            this.data = data;
	            this.next = next;
	        }

	        public void setData(double data) //sets the data of the called 
	        {
	            this.data = data;
	        }

	        public void setNext(Node next)// Sets the called data's next pointer into the argument
	        {
	            this.next = next;
	        }

	        public double getData()// gets the data of the node: O(1)
	        {
	            return data;
	        }

	        public Node getNext() //gets the data's next pointers value
	        {
	            return next;
	        }
	        
	        public boolean hasNext()
	        {
	            return this.next != null;
	        }

	        public Node next()
	        {
	            
	        	if(hasNext())
	        	{
	        		return this.next;
	        	}
	        	return null;
	        }


	    }
	
	
	
	

