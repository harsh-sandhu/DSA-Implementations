class LinkedList {

	//Inner class to define each node of LinkedList
	private class Node{
		int data;
		Node next;
		int size;
		Node(int data){
			this.data=data;
			this.next=null;
			this.size=0;
		}
	}

	//Initializing a head node
	Node head=null;

	//----------INSERTION------------

	//at tail
	public void insertAtTail(int data) {
		//case 1- if linklist is empty
		if(head==null) {
			head=new Node(data);
			head.size=1;
			return;
		}
		//other cases
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new Node(data);
		head.size=head.size+1;
	}

	//at head
	public void insertAtHead(int data) {
		//case 1
		if(head==null) {
			head=new Node(data);
			head.size=1;
			return;
		}
		//other cases
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;

		head.size=head.size+1;
	}

	//insert at given index
	public void insertAtPosition(int data,int index) {
		//Exception case
		if(index>head.size) {
			System.out.println("Invalid Index");
			return;
		}

		//base case 1
		if(index==0) {
			insertAtHead(data);
			return;
		}
		//base case 2
		if(index==head.size) {
			insertAtTail(data);
			return;
		}


		int count=0;
		Node temp=head;
		while(temp.next!=null) {
			if(count==index-1) {
				break;
			}
			count++;
			temp=temp.next;
		}
		Node newNode=new Node(data);

		Node nxt=temp.next;
		temp.next=newNode;
		newNode.next=nxt;

		head.size=head.size+1;
	}


	//-----------DELETION--------------

	//at tail
	public void deleteAtTail() {
		//case-1 linkedlist is empty
		if(head==null) {
			System.out.println("Empty List");
			return;
			//technically you should thorw an Exception
		}

		//case-2 linkedlist is only one element
		if(head.next==null) {
			head=null;
			return;
		}

		//other cases
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		head.size=head.size-1;
	}

	//at head
	public void deleteAtHead() {
		int size=head.size;

		//case-1 linkedlist is empty
		if(head==null) {
			System.out.println("Empty List");
			return;
			//technically you should thorw an Exception
		}

		//other cases
		head=head.next;

		head.size=size-1;
	}

	//at given index
	public void deleteAtPostion(int index) {
		//Exception case
		if(index>=head.size) {
			System.out.println("Invalid Index");
			return;
		}
		//base case 1
		if(index==0) {
			deleteAtHead();
			return;
		}
		//base case 2
		if(index==head.size-1) {
			deleteAtTail();
			return;
		}

		//other cases
		int count=0;
		Node temp=head;
		while(temp.next!=null) {
			if(count==index-1) {
				break;
			}
			count++;
			temp=temp.next;
		}
		temp.next=temp.next.next;

		head.size=head.size-1;
	}


	//---------SIZE OF LIST-----------
	public int size() {
		return head.size;
	}

	//--------PRINT THE LIST-----------
	public void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
