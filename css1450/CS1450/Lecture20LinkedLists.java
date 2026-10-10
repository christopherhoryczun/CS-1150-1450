
import java.util.LinkedList;

public class Lecture20LinkedLists {

	public static void main(String[] args) {
		
		// This is using the JCF to create a linked list
		// I'm including to show you what it looks like but we won't be using it.
		LinkedList<Integer> jcfLinkedList = new LinkedList<>();
		
		// This is using the class we are building - building our own linked list
		// will strength your skills in understanding how linked lists actually work.
		GenericLinkedList20<Integer> myLinkedList = new GenericLinkedList20<Integer>(); 
		
		// Add integers values {2, 4, 6} 
		myLinkedList.addLast(2);
		myLinkedList.addLast(4);
		myLinkedList.addLast(6);								
		System.out.println ("Original " + myLinkedList.toString());
					
	} // main

} // Lecture20


class GenericLinkedList20 <E> {
	
	private GenericNode<E> head; 				
	private GenericNode<E> tail; 
	private int size;
	
	public GenericLinkedList20() {
		head = null;
		tail = null;
		size = 0;
	}	
	
	// Create a new node and add as last element
	public void addLast(E element) {
		
		GenericNode<E> newNode = new GenericNode<>(element);
		if (tail == null) {
		   head = tail = newNode;
		}
		else {
		   tail.next = newNode;
		   tail = newNode;
		}
		size++;
		
	} // addLast
	
	
	@Override // Override toString to return elements in the linked list	   
	public String toString() {
		String result = "List: ";
		
		// Walk list and create a string with the values
		GenericNode<E> current = head;					
		for (int i = 0; i < size; i++) {					
		   result = result + current.element + " --> ";			
		   current = current.next;
		}
		result = result + "Null";
		return result;
		
	} // toString


	// Inner Node Class
	private static class GenericNode <E> {

		private E element;
	    private GenericNode<E> next;
	
	    public GenericNode (E element){
	    	this.element = element;
	    	next = null; 
	    }
	} // GenericNode

} // GenericLinkedList

