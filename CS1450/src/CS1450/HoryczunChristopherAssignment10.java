package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: December 3, 2025 (MW)
 * Assignment #10
 * Description: This assignment has us build a binary search tree of parrots, use a level-order traversal so they “sing” their song in order, and then list the 
 * parrots that appear in the leaf nodes while also completing a few design-notebook tasks like drawing a BST and decoding a message.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HoryczunChristopherAssignment10 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Create the binary search tree that will store all of the parrots
		BinaryTree parrotTree = new BinaryTree();
		
		// Load the required parrots.txt file
		Scanner parrotFile = new Scanner(new File("parrots.txt"));
		
		// Read each parrot from the file and insert them into the binary search tree
		while (parrotFile.hasNext()) {
			int parrotId = parrotFile.nextInt();
            String parrotName = parrotFile.next();
            String songPhrase = parrotFile.nextLine().trim();

            Parrot parrot = new Parrot(parrotId, parrotName, songPhrase);
            parrotTree.insert(parrot);
        }//end of while loop

        System.out.println("Parrot Christmas Song");
        System.out.println("---------------------");
        parrotTree.levelOrder();

        System.out.println();
        System.out.println();

        System.out.println("Parrots on Leave Nodes");
        System.out.println("----------------------");
        parrotTree.visitLeaves();
        
    }//Main
	
}//Assignment 10

class Parrot implements Comparable<Parrot> {

    // Each parrot consists of an ID, a name, and their piece of the song
    private int parrotId;
    private String parrotName;
    private String songPhrase;

    public Parrot(int parrotId, String parrotName, String songPhrase) {
        this.parrotId = parrotId;
        this.parrotName = parrotName;
        this.songPhrase = songPhrase;
    }

    public String getName() {
        return parrotName;
    }

    public String getSongPhrase() {
        return songPhrase;
    }

    // Compare parrots by their ID so the tree knows where to place them
    public int compareTo(Parrot otherParrot) {
        if (this.parrotId < otherParrot.parrotId) return -1;
        if (this.parrotId > otherParrot.parrotId) return 1;
        return 0;
    }
    
}//class Parrot

class BinaryTree {

    private TreeNode rootNode;

    public BinaryTree() {
        rootNode = null;
    }

    // Insert a parrot into the tree using its ID as the key
    public boolean insert(Parrot parrotToAdd) {

        if (rootNode == null) {
            rootNode = new TreeNode(parrotToAdd);
            return true;
        }//end of if

        TreeNode currentNode = rootNode;

        while (true) {
            if (parrotToAdd.compareTo(currentNode.parrotData) < 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new TreeNode(parrotToAdd);
                    return true;
                }
                currentNode = currentNode.leftChild;

            } else if (parrotToAdd.compareTo(currentNode.parrotData) > 0) {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new TreeNode(parrotToAdd);
                    return true;
                }//end of if
                
                currentNode = currentNode.rightChild;

            } else {
                return false; // IDs must be unique
            }//end of else
            
        }//end of while loop
        
    }//end of boolean

    // Level-order traversal: this prints the song in the correct order
    public void levelOrder() {
        if (rootNode == null) return;

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(rootNode);

        while (!treeQueue.isEmpty()) {
            TreeNode currentNode = treeQueue.remove();
            System.out.print(currentNode.parrotData.getSongPhrase() + " ");

            if (currentNode.leftChild != null) {
            	treeQueue.add(currentNode.leftChild);
            }
            
            if (currentNode.rightChild != null) {
            	treeQueue.add(currentNode.rightChild);
            }
            
        }//end of while
        
    }//end of void level order

    // Public method that kicks off the leaf-visiting process
    public void visitLeaves() {
        visitLeaves(rootNode);
    }

    // Recursive helper: prints leaf parrots from left to right
    private void visitLeaves(TreeNode currentNode) {
        if (currentNode == null) return;

        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            System.out.println(currentNode.parrotData.getName());
            return;
        }

        visitLeaves(currentNode.leftChild);
        visitLeaves(currentNode.rightChild);
    }
    
    private class TreeNode {
        Parrot parrotData;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(Parrot parrotData) {
            this.parrotData = parrotData;
            this.leftChild = null;
            this.rightChild = null;
        }
        
    }//end of tree node
    
}//end of binary tree
