public class Queue {
	private int MAX_SIZE=10;
	private int arr[];
	private int front;
	private int rear;

	//constructor
	public Queue() {
		arr=new int[MAX_SIZE];
		front=0;
		rear=-1;
	}

	public void enqueue(int data) {
		if(rear-front==MAX_SIZE-1) {
			enlargeArray();
		}
		rear++;
		arr[rear%MAX_SIZE]=data;
	}

	public void dequeue() {
		if(front>rear) {
			System.out.println("ERROR: Empty Queue");
			return;
		}
		if(rear-front==MAX_SIZE/4&&MAX_SIZE>5) {
			squeezArray();
		}

		arr[front%MAX_SIZE]=0;
		front++;
	}

	public int peek() {
		if(front>rear) {
			System.out.println("ERROR: Empty Queue");
			return -1;
		}
		return arr[front];
	}

	public int capacity() {
		return MAX_SIZE;
	}
  
	private void enlargeArray() {
		int temp[]=new int[MAX_SIZE*2];
		int k=0;
		for(int i=front;i<=rear;i++) {
			temp[k++]=arr[i];
		}
		front=0;
		rear=k-1;
		arr=temp;
		MAX_SIZE*=2;
	}

	private void squeezArray() {
		int temp[]=new int[MAX_SIZE/2];
		int k=0;
		for(int i=front;i<=rear;i++) {
			temp[k++]=arr[i];
		}
		front=0;
		rear=k-1;
		arr=temp;
		MAX_SIZE/=2;
	}
}
