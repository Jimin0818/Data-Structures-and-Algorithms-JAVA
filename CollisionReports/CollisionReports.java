package Assignment2;
import java.util.Random;

/* 5.3 Write a program to compute the number of collisions required in a long random sequence of insertions 
 * using linear probing, quadratic probing, and double hashing. 
*/


class HashTable {
  int[] table;
  int size;

  //Constructor 
  public HashTable(int size) {
      this.size = size;
      this.table = new int[size];
  }

  //This method will return true if a collision has occurred, and will insert key into the table if not
  public boolean insert(int key) {
      int index = key % size;
      if (table[index] == 0) {			//If key is within size, then insert key
          table[index] = key;
          return false; 				//Return false since key was successfully inserted w/o collision
      } else {
          int newIndex = index;
          int count = 1;
          while (table[index] != 0) {
              index = (newIndex + count) % size;
              count++;					
          }
          table[index] = key;			//Finds the next empty slot: used for probing
          return true; 					//Return true since collision has occurred
      }
  }
}

//This method will move to the next slot in the hash table until an empty slot is found when collision occurred
class LinearProbing extends HashTable {
  public LinearProbing(int size) {
      super(size);						//Since the probing is in the insert() method, just calls the superclass and pass parameter 
  }
}

//This method increases the step size quadratically with each collision which spread out the entries more evenly in the table.
class QuadraticProbing extends HashTable {
  public QuadraticProbing(int size) {
      super(size);						//Since the probing is in the insert() method, just calls the superclass and pass parameter 
  }
  	//This method has the same concept as the one above;however, it increments the steps quadratically
  @Override
  public boolean insert(int key) {
      int index = key % size;
      int count = 1;
      int originalIndex = index;
      while (table[index] != 0) {
          index = (originalIndex + count * count) % size;
          count++;
          if (index == originalIndex) {
              return true;
          }
      }
      table[index] = key;
      return false; 
  }

}

//This method will use two hash functions to calculate a second hash value which is used to determine the step size
class DoubleHashing extends HashTable {
  public DoubleHashing(int size) {
      super(size);						//Since the probing is in the insert() method, just calls the superclass and pass parameter 
  }


  //This method has the same concept as the one above;however, it increments the steps utilizing a second hash
  @Override
  public boolean insert(int key) {
      int index = key % size;
      int count = 1;
      int originalIndex = index;
      int hash2 = 7 - (key % 7);

      while (table[index] != 0) {
          index = (originalIndex + count * hash2) % size;
          count++;
          if (index == originalIndex) {
              return true;
          }
      }
      table[index] = key;
      return false; 
  }

}

//This method counts collisions for a given hash table
public class CollisionReports {

  public int collisionCounter(HashTable table, int numInsertions)
  {
      Random random = new Random();
      int collisions = 0;

      for (int i = 0; i < numInsertions; i++) {
          int key = random.nextInt(table.size); // Generate random key 
          if (table.insert(key)) { 
              collisions++; 				//Increase collision counter when collision occurs
          }
      }
      return collisions;
  }

  //The Main Method
  public static void main(String [] args)
  {
      CollisionReports col = new CollisionReports();

      int tableSize = 10000;
      int numInsertions = 10000;

      System.out.println("Collisions Report:");
      System.out.println("Linear Probing Collisions: " + col.collisionCounter(new LinearProbing(tableSize), numInsertions));
      System.out.println("Quadratic Probing Collisions: " + col.collisionCounter(new QuadraticProbing(tableSize), numInsertions));
      System.out.println("Double Hashing Collisions: " + col.collisionCounter(new DoubleHashing(tableSize), numInsertions));
  }

}



