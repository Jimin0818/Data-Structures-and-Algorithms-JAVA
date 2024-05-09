package Assignment2;
/* 
3.33 Efficiently implement a queue class using a circular array
1.	Add 2 elements to your queue: 10 and 20.
2.	Print the queue.
3.	Dequeue an element from the queue.
4.	Print the queue again.

*/

public class CircularQueueOperations {
	    private int[] queue;					//Initialize circular queue
	    private int size;						//Initialize size of the array
	    private int front; 						//Initialize position of front element
	    private int rear;  						//Initialize position of back element
	    private int capacity;					//Initialize max capacity of array
	   
	    public CircularQueueOperations() {
	    	
	    }
	    
	    public CircularQueueOperations(int capacity) {
	        this.queue = new int[capacity];
	        this.size = 0;
	        this.front = 0;
	        this.rear = -1;
	        this.capacity = capacity;
	    }
	    //Returns true if the size of the array is 0 (empty)
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    //Returns true if the array reaches maximum capacity
	    public boolean isFull() {
	        return size == capacity;
	    } 

	    //This method adds element to the queue only if the array is not full
	    public void enqueue(int item) {
	        if (isFull()) 
	        {
	           return; 							//Return if the size of the array exceeds the max capacity
	        }
	        rear = (rear + 1) % capacity;		//Adjust the position of the back of the queue
	        queue[rear] = item; 				//Adds element to the end of the circular array
	        size++; 							//Increase Size of array
	    }

	    //This method removes element in the array and returns it only if array is not empty
	    public int dequeue() {
	        if (isEmpty())						//Check if the queue is empty before removing elements
	        {
	            return -1;
	        }
	        int frontItem = queue[front];
	        queue[front] = 0; 					//Reset the front position
	        front = (front + 1) % capacity;		//Adjust position
	        size--;							 	//Decrease array size
	        return frontItem;					//Return removed element
	    }

	    //This method returns the first value of the queue without deleting it
	    public int peek() {
	        if (isEmpty())						//Check if the queue is empty before peeking
	        {
	            return -1;
	        }
	        return queue[front];
	    }

	    //This method prints out the elements of the queue
	    public void print() {
	        if (isEmpty()) 						//Check if the queue is empty before printing
	        {
	            return; 
	        }
	        int index = front; 					//Starting position of queue
	        int count= size;					//Iterator for the loop
	        while (count !=0) {
	            System.out.print(queue[index] + " "); 
	            index = (index + 1) % capacity;	//Adjust position of print
	            count--;						//Decrease loop counter
	        }
	    }


	    //The Main Method
	    public static void main(String [] args)
	    {
	       
	        CircularQueueOperations queue = new CircularQueueOperations(10);
	        //Given Test Cases
	        queue.enqueue(10);
	        queue.enqueue(20);
	        System.out.print("Queue: [ ");
	        queue.print();
	        System.out.println("]");
	        queue.dequeue();
	        System.out.print("Queue after dequeue: [ ");
	        queue.print();
	        System.out.println("]");

	    }


}
