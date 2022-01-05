
public class ReverseLinkedList {

	//Three Pointer Method
	public static void reverse1(LinkedList ll) {

		//Three-pointer Method to reverse a linked-list
		Node prev=null;
		Node curr=ll.head;
		Node nxt;
		while(curr!=null) {
			nxt=curr.next;
			curr.next=prev;
			prev=curr;
			curr=nxt;
		}
		ll.head=prev;
	}

	//Recursive Method
	public static void reverse2(LinkedList ll) {
		ll.head=reverse2(ll.head);
	}
	public static Node reverse2(Node head) {
		if(head==null||head.next==null) {
			return head;
		}
		Node newhead=reverse2(head.next);
		head.next.next=head;
		head.next=null;
		return newhead;
	}


	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.insertAtTail(1);
		ll.insertAtTail(2);
		ll.insertAtTail(3);
		ll.insertAtTail(4);
		ll.insertAtTail(5);
		ll.printList();
		reverse1(ll);
		ll.printList();
		reverse2(ll);
		ll.printList();
	}

}
