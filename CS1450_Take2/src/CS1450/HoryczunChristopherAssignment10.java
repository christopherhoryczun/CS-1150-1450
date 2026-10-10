package CS1450;

import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment10 {

    public static void main(String[] args) throws FileNotFoundException {

        // create the binary tree
        BinaryTree tree = new BinaryTree();

        // open the file
        File file = new File("parrots.txt");
        Scanner input = new Scanner(file);

        // read until end of file
        while (input.hasNext()) {

            // read each piece of data
            int id = input.nextInt();
            String name = input.next();
            String songWord = input.next();

            // create parrot object
            Parrot parrot = new Parrot(id, name, songWord);

            // add it to the tree
            tree.insert(parrot);
        }

        input.close(); // close file

        // print song using level order traversal
        System.out.println("Parrot's Song");
        System.out.println("---------------------");
        tree.levelOrder();

        // print leaf nodes
        System.out.println();
        System.out.println();
        System.out.println("Parrots on Leaf Nodes");
        System.out.println("----------------------");
        tree.visitLeaves();
    }
}

// class that represents a single parrot
class Parrot implements Comparable<Parrot> {

    private int id;
    private String name;
    private String songWord;

    // constructor
    public Parrot(int id, String name, String songWord) {
        this.id = id;
        this.name = name;
        this.songWord = songWord;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // returns the parrot's word in the song
    public String sing() {
        return songWord;
    }

    // compare parrots by id
    public int compareTo(Parrot otherParrot) {
        if (this.id < otherParrot.id) {
            return -1;
        }
        else if (this.id > otherParrot.id) {
            return 1;
        }
        else {
            return 0; // same id
        }
    }
}

// binary search tree class
class BinaryTree {

    private TreeNode root;

    // constructor
    public BinaryTree() {
        root = null;
    }

    // insert method
    public boolean insert(Parrot parrotToAdd) {

        TreeNode newNode = new TreeNode(parrotToAdd);

        // if tree empty, new node becomes root
        if (root == null) {
            root = newNode;
            return true;
        }

        TreeNode parent = null;
        TreeNode current = root;

        // find correct spot in tree
        while (current != null) {
            parent = current;

            if (parrotToAdd.compareTo(current.parrot) < 0) {
                current = current.left; // go left
            }
            else if (parrotToAdd.compareTo(current.parrot) > 0) {
                current = current.right; // go right
            }
            else {
                return false; // duplicate, don't insert
            }
        }

        // attach node to correct side
        if (parrotToAdd.compareTo(parent.parrot) < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }

        return true;
    }

    // level order traversal (uses a queue)
    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // start with root

        while (!queue.isEmpty()) {

            TreeNode tempNode = queue.remove();

            // print the word
            System.out.print(tempNode.parrot.sing() + " ");

            // add children to queue
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    // public method calls recursive helper
    public void visitLeaves() {
        visitLeaves(root);
    }

    // recursive method to print leaf nodes
    private void visitLeaves(TreeNode aNode) {

        if (aNode == null) {
            return;
        }

        // if both children are null, it's a leaf
        if (aNode.left == null && aNode.right == null) {
            System.out.println(aNode.parrot.getName());
            return;
        }

        // go left then right
        visitLeaves(aNode.left);
        visitLeaves(aNode.right);
    }

    // inner class for tree node
    private class TreeNode {

        private Parrot parrot;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Parrot parrot) {
            this.parrot = parrot;
            left = null;
            right = null;
        }
    }
}