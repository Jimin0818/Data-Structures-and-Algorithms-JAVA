package Assignment2;

import java.util.*;
import java.util.Random;
import java.util.List;

/* 4.34 Write a method to generate an N-node random binary search tree with distinct keys 1 through N. 
 * What is the running time of your routine?
 * 1.	Generate a random binary search tree with N = 10.
 * 2.	Print out the elements as you add them to the tree.
 * 3.	Perform an inorder traversal of the tree and print the elements.
 */
	//The Node class initialize variables needed for BST
class Node{
	 int data;
     Node left; 
     Node right; 

     //Constructor: Assign Variables
     public Node(int data){ 
         this.data = data;
         left = null;
         right = null;
     }
 }

	//The BST class: Insert elements and perform in-order traversal
 class BinarySearchTree {
     Node root;
     
    //Constructor: Initialize root to null
     public BinarySearchTree() { 
    	 root = null;
    }
	//This method inserts elements by calling the rightLeft() method
     public void insert(int data) { 
    	 System.out.println("Added "+data+ " to the BST");
    	 root = rightLeft(root,data); 
    }

    //This method determines which direction the node is inserted in, and also created the root if its null (doesn't exist)
     private Node rightLeft(Node root, int data) {
    	 if(root == null){
             root = new Node(data);
             return root;
         }
         if(data < root.data) {
             root.left = rightLeft(root.left, data);
         }
         else if( data > root.data) {
             root.right = rightLeft(root.right, data);
         }
         return root;
     }

     //This method performs the in-order traversal on the BST (LEFT - CURRENT - RIGHT)  
     public void inOrderTraversal() {
         inOrderTraversal(root);
    	 
     }
     //This method traverses through the tree recursively 
     private void inOrderTraversal(Node root) {
         if (root != null) {
             inOrderTraversal(root.left);
             System.out.print(root.data + " ");
             inOrderTraversal(root.right);
         }
     }

 }
 public class BinarySearchTreeOperations {
     //This method generate list of random numbers and insert into ArrayList
     public static List<Integer> getNum(int size) {
         Random random = new Random();
         ArrayList<Integer> array = new ArrayList<>();

         for(int i = 0; i < size; i++){
        	 array.add(random.nextInt(size)); 
         }
         return array;
     }

     //This method creates a BST from the given list of integers using the insert() method
     public static BinarySearchTree createBST(List<Integer> list){
         BinarySearchTree tree = new BinarySearchTree();
         for(int num : list){
        	 tree.insert(num);
         }
         return tree;
     }
     
     //The Main Method
     public static void main(String[] args) {
         List<Integer> randomList = getNum(10);
         BinarySearchTree tree = createBST(randomList);

         System.out.print("The in-order traversal of the binary search tree of 10 elements is:");
         tree.inOrderTraversal();

      
     }

}
