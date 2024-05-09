5.5: HashTableOperations
	This program starts with the Nodes class which has all the necessary elements to make a LinkedList and has a variable for the key for the hash map. This method has a complexity of O(1).
	The method size() will return the size of the hash table. This method has a complexity of O(1).
	The insert() method will add a given String at a given key location. If there is already an element present, it will move all elements down to the next node in the hash table. Since in the worst case, it will push the element, which shifts all the elements, this method has a complexity of O(N). 
	The method get() returns the value at a given key in the hash map. If the given key is not found, then it returns "Key Does Not Exist". The complexity for this method is O(N) since it traverses through each element of the hashmap multiple times due to the loop.
	The method remove() removes the value at a given key if it exists. It removes the element, and is replaced with a dummy null entry. The complexity for this method is O(N) since in the worst case, the key does not exist and it fully traverses through all the elements.
	Overall, the complexity of this program is O(N).
