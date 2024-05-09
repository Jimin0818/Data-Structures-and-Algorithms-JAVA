package Assignment2;

/* 5.5 Reimplement separate chaining hash tables using singly linked lists instead of using java.util.Nodes.
1.	Insert 2 values into your hash table:
		a.	At key 1, insert the value "One".
		b.	At key 2, insert the value "Two".
2.	Retrieve and print out the value for key 1.
3.	Attempt to retrieve and print out the value for key 3 (which does not exist).
4.	Remove the entry with key 1.
5.	Print out the current size of the hash table.
*/

	//This class has necessary elements needed for Linked list and hash
class Nodes {
    int key; 
    String value; 
    Nodes next; 

    //Constructor: Assign values
    public Nodes(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTableOperations {
    private Nodes[] table;
    private int capacity;
    private int size;

    //Constructor: Initialize Hash Map with given parameter 
    public HashTableOperations(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new Nodes[capacity];
    }
    //This method returns the size of the hash
    public int size()
    {
        return size;
    }

    //This method will add the given String value at the location key. It will move the current node to the next
    //position if collision occurs
    public void insert(int key, String value) {
    	if(size>= capacity) {
    		System.out.println("The Hash Map is Full");
    		return;
    	}
        int index = key % capacity;						//Makes sure the index is not over the capacity
        if (table[index] == null) {						//If given position is empty, add it
            table[index] = new Nodes(key, value);
        } else {										//Collision Occurs
            Nodes current = table[index];				//Makes a LL at that location 
            while (current.next != null && current.key != key) {
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = new Nodes(key, value);
            }
        }
        size++;											//Increase Size of Hash
    }

    //This method will return the value at a given key, or return "Key Does Not Exist" if it does not exist 
    public String get(int key) {
        int index = key % capacity;						//Makes sure the index is not over the capacity
        Nodes current = table[index];
        while (current != null) {
            if (current.key == key) {					//If key found matches key given 
                return current.value;					//Return the value in that location
            }
            current = current.next;						//If not move on to the next position
        }
        return "Key Does Not Exist"; 					//Return "Key Does Not Exist" if it traversed through all elements but did not find match
    }

    //This method removes the element at a given key if it exists and replace with a dummy element.
    public void remove(int key) {
        int index = key % capacity;						//Makes sure the index is not over the capacity
        Nodes dummy = new Nodes(-1, "");				//Create empty dummy node
        dummy.next = table[index];
        Nodes current = table[index];					//Current node is the index
        while (current != null) {						//While current node exists
            if (current.key == key) {
            	dummy.next = current.next;				//If key matches, direct the next pointer to dummys next pointer
                size--;									//Decrease size and break loop
                break;
            }
            dummy = current;							//Make dummy pointer the current pointer so previous node can point to this

        }
        table[index] = dummy.next;						
    }
    //The Main Method 
    public static void main(String[] args) {
        HashTableOperations hashTable = new HashTableOperations(10);
        //Given Test Cases
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        System.out.println("Value for key 1: " + hashTable.get(1));
        System.out.println("Value for key 3: " + hashTable.get(3)); // Expected to show some form of "not found" message.
        hashTable.remove(1);
        System.out.println("Size of hash table: " + hashTable.size());

    }
}
