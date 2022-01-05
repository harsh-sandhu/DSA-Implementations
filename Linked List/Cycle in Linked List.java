public class CycleInLinkedList {

	//----------Cycle Detection in linked list-----------
	// Floyd's Cycle Detection Algorithm
	public static boolean hasCycle(LinkedList ll) {
		Node slow=ll.head;
		Node fast=ll.head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}


	//-----------Remove Cycle from linkedList------------
	// Floyd's Cycle Removal Algorithm
	public static void removeCycle(LinkedList ll) {
		if(!hasCycle(ll)) {
			System.out.println("No Cycle found to remove");
		}
		Node slow=ll.head;
		Node fast=ll.head;

		//for exception case
		Node prevSlow=null;

		while(fast!=null&&fast.next!=null) {
			prevSlow=slow;

			slow=slow.next;
			fast=fast.next.next;

			if(slow==fast) {

				//Speical case-Linked List is Circular
				if(slow==ll.head) {
					prevSlow.next=null;
					return;
				}

				fast=ll.head;
				break;
			}
		}

		while(slow.next!=fast.next) {
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=null;
	}


	//-------Function to make cycle at K position-------------
	public static void makeCycle(LinkedList ll,int k) {
		if(k<1||k>=ll.size()) {
			System.out.println("ERROR: Cant Create Cycle");
			return;
		}

		int count=1;
		Node temp=ll.head;
		Node cyclePoint=null;
		while(temp.next!=null) {
			if(count==k) {
				cyclePoint=temp;
			}
			count++;
			temp=temp.next;
		}
		temp.next=cyclePoint;
	}


	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.insertAtTail(1);
		ll.insertAtTail(2);
		ll.insertAtTail(3);
		ll.insertAtTail(4);
		ll.insertAtTail(5);
		ll.printList();

		System.out.println(hasCycle(ll));
		makeCycle(ll,3);
		System.out.println(hasCycle(ll));
		removeCycle(ll);
		System.out.println(hasCycle(ll));
	}

}
