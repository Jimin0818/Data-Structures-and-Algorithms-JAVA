5.3: CollisionReports
	This program starts by creating the necessary variables: int[] table and into size to make a hash table and assign values to them. 
The insert() method will return true if a collision has occurred, and will insert a key into the table if no collision has been detected(return false). This method has a complexity of O(N).
The method LinearProbing() uses a Linear Probing method where you move to the next available spot in the map in case of a collision. The complexity of this can be O(N) where N is the size of the hash map since it goes through the whole map to find a spot. 
The method QuadraticProbing() uses the Quadratic Probing method which spreads out the entries more evenly in the table by allowing the step size to increase quadratically with each collision. The complexity of this method can also be O(N) since in the worst case it would have to traverse through the whole map. (Known to be better than linear probing)
	The method DoubleHashing() uses two hash functions to calculate a second hash value which is used to determine the step size. Similar to the two other probing methods, it has a worst case complexity of O(N) since it could traverse through the whole map. This is designed to reduce clustering and has a more even distribution than linear probing.
	The collisionCounter() method inserts random keys into the hash table for a specified time (Given by the user) and increments the collision counter whenever a collision occurs. This method has a complexity of O(N) with N being the number of insertions. 
	Overall, the program's complexity is O(N).

