package Assignment2;


/* 3.11 Assume that a singly linked list is implemented with a header node, but no tail
node, and that it maintains only a reference to the header node. Write a class that
includes methods to
a. return the size of the linked list
b. print the linked list
c. test if a value x is contained in the linked list
d. add a value x if it is not already contained in the linked list
e. remove a value x if it is contained in the linked list
*/


public class SinglyLinkedListOperations {
	private ListNode head;							//Initialize only the head of the LL: Instructions
    private int size;								//Initialize variable that will contain size of array
    
    private class ListNode {
        int value;
        ListNode next; 								//Allows user to point to the next node
        ListNode(int value) {
        	this.value = value; 						//Sets value from ListNode to local
    	}
    
    }

    // Constructor
    public SinglyLinkedListOperations() {
        head = new ListNode(0); 					//Puts dummy in header node
        size = 0; 									//Set size of LL to 0
    }

    //Condition A:Return the size of the linked list
    public int size() {
        return size;
    }

    //Condition B: print the linked list
    public void printList() {
        ListNode currentNode = head.next;				//Initializes the current as node after the head to start at the beginning
        while (currentNode != null) { 					//Traverse through the list until the last node (when node == null)
            System.out.print(currentNode.value + " ");  //Print values in the node + " "
            currentNode = currentNode.next; 			//Points the currentNode to the next node
        }
        //System.out.println(); //once null print, indicates end of list
    }

   ///Condition C: test if a value x is contained in the linked list
    public boolean hasValue(int x) {
        ListNode currentNode = head.next;				//Initializes the current as node after the head to start at the beginning
        while (currentNode != null) { 					//Traverse through the list until the last node (when node == null)
            if (currentNode.value == x) { 				//Test if the value of current node = the given value
                return true; 							//Returns true if above statement is true
            }
            currentNode = currentNode.next; 			//Points the currentNode to the next node; traverse list
        }
        return false; 									//Return false if none of the node = x
    }
    
    //Condition D: add a value x if it is not already contained in the linked list
    public void add(int x) {
        if (!hasValue(x)) { 							//Checks if the value is in the list
        	size++; 									//Increase size of array by 1
        	ListNode newNode = new ListNode(x);			//Creates a new node
            newNode.next = head.next; 					//"Inserts" the new node after the head; adjust the pointers
            head.next = newNode;
        }
    }

   //Condition E:  remove a value x if it is contained in the linked list
    public void remove(int x) {
        ListNode prev = head;
        ListNode currentNode = head.next;

        while (currentNode != null) {						//Traverse through the list until the last node (when node == null)
            if (currentNode.value == x) {					//Test if the value of current node = the given value
                prev.next = currentNode.next;				//If true, then "remove" the node by connecting the next pointer of the 
                											//previous node to the next node
                size--;										//Decrease size of the list by 1
                break; 										//Break the loop if the value has been found and removed
            }
            prev = currentNode;								//Move to the next node
            currentNode = currentNode.next;
        }
    }
    //Main Method
    public static void main(String[] args) {
    	SinglyLinkedListOperations list = new SinglyLinkedListOperations();
    	
    	//Given Test Cases
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List contains 20: " + list.hasValue(20));
        list.remove(20);
        System.out.println("List contains 20 after removal: " + list.hasValue(20));
        list.printList();
    }

}
