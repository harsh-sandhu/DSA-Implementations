public class DoublyLinkedList {

	//Inner class for Node
	class Node{
		int data;
		Node next;
		Node prev;

		Node(int data){
			this.data=data;
			next=null;
			prev=null;
		}
	}

	//Initializing the head node
	Node head=null;
	int size=0;

	//------------INSERTION-------------

	//at tail
	public void insertAtTail(int data) {

		if(head==null) {
			head=new Node(data);
			size=1;
			return;
		}


		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		Node newNode=new Node(data);

		temp.next=newNode;
		newNode.prev=temp;

		size+=1;
	}

	//at head
	public void insertAtHead(int data) {
		if(head==null) {
			head=new Node(data);
			size+=1;
			return;
		}

		Node newNode=new Node(data);

		newNode.next=head;
		head.prev=newNode;
		head=newNode;

		size+=1;
	}

	//at given index k
	public void insertAtPosition(int data,int k) {

		//Exception case
		if(k<0||k>size) {
			System.out.println("Invalid Index");
			return;
		}

		//base case-1
		if(k==0) {
			insertAtHead(data);
			return;
		}

		//base case-2
		if(k==size) {
			insertAtTail(data);
			return;
		}

		int count=0;
		Node temp=head;
		while(temp.next!=null) {
			if(count==k-1) {
				Node newNode=new Node(data);

				Node nxt=temp.next;

				temp.next=newNode;
				newNode.prev=temp;
				newNode.next=nxt;
				nxt.prev=newNode;
			}
			count++;
			temp=temp.next;
		}

		size+=1;
	}


	//--------DELETION------------

	//at tail
	public void deleteAtTail() {

		//Exception case- if list is empty
		if(size==0) {
			System.out.println("ERROR: List is Empty");
			return;
		}

		//base case- list has only one element
		if(size==1) {
			head=null;
			size=0;
			return;
		}

		//Other cases
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		Node prevNode=temp.prev;
		temp.prev=null;
		prevNode.next=null;

		size-=1;
	}

	//at Head
	public void deleteAtHead() {

		//Exception case- if list is empty
		if(size==0) {
			System.out.println("ERROR: List is Empty");
			return;
		}

		//base case- list has only one element
		if(size==1) {
			head=null;
			size=0;
			return;
		}

		//Other cases
		head=head.next;
		head.prev=null;

		size-=1;
	}

	//at index k
	public void deleteAtPosition(int k) {

		//Exception case 1- if list is empty
		if(size==0) {
			System.out.println("ERROR: List is Empty");
			return;
		}

		//Exception case 2- Invalid Index
		if(k<0||k>=size) {
			System.out.println("ERROR: Invalid Index");
			return;
		}

		//base case 1
		if(k==0) {
			deleteAtHead();
			return;
		}

		//base case 2
		if(k==size-1) {
			deleteAtTail();
			return;
		}

		int count=0;
		Node temp=head;
		while(temp!=null) {
			if(k==count) {
				Node prevNode=temp.prev;
				Node nextNode=temp.next;

				prevNode.next=nextNode;
				nextNode.prev=prevNode;

				temp.next=temp.prev=null;
				break;
			}
			count++;
			temp=temp.next;
		}

		size-=1;
	}


	//-----size of list------
	public int size() {
		return size;
	}

	//--------Print the list--------
	public void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
