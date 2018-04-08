class DoublyLinkedList{
	/** Head refers to the front of the list */
	private Link head;
	/** Tail refers to the back of the list */
	private Link tail;

	/**
	 * Constructor
	 */
	public DoublyLinkedList(){
		head = null;
		tail = null;
	}

	/**
	 * Insert an element at the head
	 * 
	 * @param x Element to be inserted
	 */
	public void insertHead(int x){
		Link newLink = new Link(x); //Create a new link with a value attached to it
		if(isEmpty()) //Set the first element added to be the tail
			tail = newLink;
		else
			head.previous = newLink; // newLink <-- currenthead(head)
		newLink.next = head; // newLink <--> currenthead(head)
		head = newLink; // newLink(head) <--> oldhead
	}

	/**
	 * Insert an element at the tail
	 * 
	 * @param x Element to be inserted
	 */
	public void insertTail(int x){
		Link newLink = new Link(x);
		newLink.next = null; // currentTail(tail)     newlink -->
		tail.next = newLink; // currentTail(tail) --> newLink -->
		newLink.previous = tail; // currentTail(tail) <--> newLink -->
		tail = newLink; // oldTail <--> newLink(tail) -->
	}

	/**
	 * Delete the element at the head
	 * 
	 * @return The new head
	 */
	public Link deleteHead(){
		Link temp = head;
		head = head.next; // oldHead <--> 2ndElement(head)
		head.previous = null; // oldHead --> 2ndElement(head) nothing pointing at old head so will be removed
		if(head == null)
			tail = null;
		return temp;
	}

	/**
	 * Delete the element at the tail
	 * 
	 * @return The new tail
	 */
	public Link deleteTail(){
		Link temp = tail;
		tail = tail.previous; // 2ndLast(tail) <--> oldTail --> null
 		tail.next = null; // 2ndLast(tail) --> null
		return temp;
	}

	/**
	 * Delete the element from somewhere in the list
	 * 
	 * @param x element to be deleted
	 * @return  Link deleted
	 */
	public Link delete(int x){
		Link current = head;

		while(current.value != x) //Find the position to delete
			current = current.next;

		if(current == head)
			deleteHead();

		else if(current == tail)
			deleteTail();

		else{ //Before: 1 <--> 2(current) <--> 3
			current.previous.next = current.next;  // 1 --> 3
			current.next.previous = current.previous; // 1 <--> 3
		}
		return current;
	}
