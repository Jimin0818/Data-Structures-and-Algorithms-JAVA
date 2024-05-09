package Assignment1;

import java.util.Arrays;

import java.util.EmptyStackException;		////Used for throwing an exception when the stack is empty: EmptyStackException


public class ArrayStack implements BKStack
{
    int INTIAL_CAPACITY = 10;   			//define an INITIAL_CAPACITY for the array of type int and value 10
    private double arr [];      			//Create variable double array (Not initialized yet)
    private int size;						//Creates Private variable int size		

    public ArrayStack()
    {
        arr = new double[INTIAL_CAPACITY];  //Initialize the double "arr" with the capacity of "Intial_Capacity"
        size = 0;							//Defines the variable size with the value 0
    }

    public boolean isEmpty()				//Returns True or False of whether the stack is empty
    {
        return size == 0;					//Returns True when size == 0 and vise versa
    }

    public int count() 						//Returns the number of elements stored in the stack
    {
        return size;						//Returns the number of element(size)
    }

    public void push(double d)				//Inserts(pushes) variable "d" onto the stack
    {
        for(int i = arr.length; i > 0; i--)
        {
            arr[i+1] = arr[i];				//Shift the position of every element in the stack by +1 to make room for new value
        }

        arr[0] = d;							//Pushes the new value "d" into the top of the stack (position 0)
        size++;								//Increase the variable "size" (the size of stack) by 1
        if(size == arr.length-2)			//If the size (number of elements/top) reaches the arr.length (-1 cause variable
        	resize();						//size starts at 0 so if size = 9 then the stack of size 10 will be full), then jump to 
											//the resize() method
          
    }

    public double pop()						//Deletes (pops) the top value of the stack, returns the popped value, and 
    										//EmptyStackException if stack is empty
    {
        if(isEmpty())
        {
        	throw new EmptyStackException();//throws  exception if the stack is empty
        }else {
        	
            double popVal = arr[0];			//Pops the top value of the stack in puts it into double "popVal"
            for(int i = 0; i < arr.length; i++)
            {   
                arr[i] = arr[i+1];			//Shifts the position of the element by -1 in order to delete the "popped" element
            }
            	size--;						//Decrease the size of the stack by 1
            return popVal;					//Return the value of the popped element
        }
    }


    public double peek()					//Throws exception if the stack is empty, else return top element of stack
    {
    	if(isEmpty())
        	throw new EmptyStackException();
    	return arr[0];
        
    }

    private void resize() {					//Doubles the size of the array once the number of elements gets closer to the length
        int newSize = arr.length * 2;		//Creates variable "newSize" that is double the length of array "arr"
        arr = Arrays.copyOf(arr, newSize);	//Uses the Array class to copy the values in the "arr" array to a new array "arr" with 
        									//the length "newSize"
    }
}
