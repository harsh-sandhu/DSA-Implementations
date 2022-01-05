public class Stack {
	private int MAX_SIZE=10;
	private int arr[];
	private int top;


	//constructor
	public Stack() {
		arr=new int[MAX_SIZE];
		top=-1;
	}

	public void push(int data) {
		if(top==MAX_SIZE-1) {
			enlargeArray();
		}
		arr[++top]=data;
	}

	public void pop() {
		if(top<0) {
			System.out.println("ERROR: Empty Stack");
			return;
		}
		arr[top--]=0;
		if(top==MAX_SIZE/4&&MAX_SIZE>10) {
			squeezArray();
		}
	}

	public int peek() {
		if(top<0) {
			System.out.println("ERROR: Empty Stack");
			return -1;
		}
		return arr[top];
	}

	public int size() {
		return top+1;
	}

	public int capacity() {
		return MAX_SIZE;
	}



	//RESIZE FUNCTIONS
	private void enlargeArray() {
		int temp[]=new int[MAX_SIZE*2];
		for(int i=0;i<=top;i++) {
			temp[i]=arr[i];
		}
		arr=temp;
		MAX_SIZE*=2;
	}

	private void squeezArray() {
		int temp[]=new int[MAX_SIZE/2];
		for(int i=0;i<=top;i++) {
			temp[i]=arr[i];
		}
		arr=temp;
		MAX_SIZE=MAX_SIZE/2;
	}

}
