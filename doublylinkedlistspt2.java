/* Constructor
	 */
	public DoublyLinkedList(){
		head = null;
		tail = null;
	}
/**
	 * Inserts element and reorders
	 * 
	 * @param x Element to be added
	 */
	public void insertOrdered(int x){
		Link newLink = new Link(x);
		Link current = head;
		while(current != null && x > current.value) //Find the position to insert
			current = current.next;

		if(current == head)
			insertHead(x);

		else if(current == null)
			insertTail(x);

		else{ //Before: 1 <--> 2(current) <--> 3
			newLink.previous = current.previous; // 1 <-- newLink
			current.previous.next = newLink; // 1 <--> newLink
			newLink.next = current; // 1 <--> newLink --> 2(current) <--> 3
			current.previous = newLink; // 1 <--> newLink <--> 2(current) <--> 3
		}
	}

	/**
	 * Returns true if list is empty
	 * 
	 * @return true if list is empty
	 */
	public boolean isEmpty(){
		return(head == null);
	}

	/**
	 * Prints contents of the list
	 */
	public void display(){ //Prints contents of the list
		Link current = head;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}

/**
 * This class is used to implement the nodes of the
 * linked list.
 * 
 * @author Unknown
 *
 */
class Link{
	/** Value of node */
	public int value;
	/** This points to the link in front of the new link */
	public Link next;
	/** This points to the link behind the new link */
	public Link previous;

	/**
	 * Constructor
	 * 
	 * @param value Value of node
	 */
	public Link(int value){
		this.value = value;
	}

	/**
	 * Displays the node
	 */
	public void displayLink(){
		System.out.print(value+" ");
	}
