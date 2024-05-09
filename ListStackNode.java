package Assignment1;
import java.util.Iterator;

public class ListStackNode implements Iterator<ListStackNode>{
  // The class itself is the node, the following is attributes of the node


  // The value of the node being of type double
  private double value;

  // The pointer which points to the next node, next node is of Type ListStackNode which is also the type of the pointer
  private ListStackNode next;


  // Constructor method for node that sets value and next pointer
  // This method takes in a double and sets the value to that arg, then the next pointer is set to null by default
  // Time Complexity - O(1)
  public ListStackNode(double newvalue) {
    this.value = newvalue;
    this.next = null;
  }

  // This method returns the value of the calling node
  // Time Complexity - O(1)
  public double getValue() {
    return this.value;
  }

  // This method takes a node as an argument and sets the calling node's next pointer to that argument
  // Time Complexity - O(1)
  public void setNext(ListStackNode nextNode) {
    this.next = nextNode;
  }

  // This method simply returns true of false wether or not the calling node has a next node in the next variable
  // Time Complexity - O(1)
  @Override
  public boolean hasNext() {
    if (this.next != null) {return true;}
    return false;

  }

  // This method returns the node next to the calling node
  // If there is no node next to it, then the method returns null
  // Time Complexity - O(1)
  @Override
  public ListStackNode next() {
    if (this.hasNext()) {
      return this.next;
    }
    return null;
  }

}
