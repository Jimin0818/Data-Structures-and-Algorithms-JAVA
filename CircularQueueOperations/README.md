3.33: CircularQueueOperations
	This program starts by initializing the circular array, front position, back position, size of array, and the max capacity of the array. Then in the constructor, it assigns the above mentioned variables their respective values. 
The first method: isEmpty() returns true if the array is empty. This method has a complexity of O(1). 
The isFull() method returns true if the array size reaches the maximum capacity. The complexity of this method is also O(1). 
The size() method returns the size of the array This method has complexity of O(1).
The enqueue method will add an element to the queue only if the isFull() method returns true. (If the array is below the maximum capacity) Adding and deleting elements in an array has a complexity of O(N); however, this is at the end of the array so it will have a complexity of O(1) and a worst case complexity of O(n). 
The dequeue() method performs similarly as the enqueue method but removes the elements from the queue only if the array is not empty. It also returns the removed element, and updates the front position. This method has a complexity of O(1) since it only removes elements from the end, but can has worst case complexity of O(N) 
The peek() method returns the most front value of the queue. This method has a complexity of O(1).
The print() method traverses through the queue and prints out all the elements. Since this method traverses through each element to print them, it will have a complexity of O(N).
Overall, this program has the complexity of O(N).

