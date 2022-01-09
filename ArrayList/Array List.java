class ArrayList {
  
	private int list[];
	static private int capacity=10;
	private int n;

	public ArrayList() {
		list=new int[capacity];
		n=-1;
	}

	public void add(int val) {
		if(n==capacity-1) {
			resize();
		}
		list[++n]=val;
	}

	public int get(int index) {
		if(index<0||index>n) {
			System.out.println("Invalid index");
			return -1;
		}
		return list[index];
	}

	public int remove(int index) {
		if(index<0||index>n) {
			System.out.println("Invalid index");
			return -1;
		}
		int val=list[index];
		for(int i=index;i<n;i++) {
			list[i]=list[i+1];
		}
		list[n]=0;
		n--;
		if(n<=capacity/4) {
			shrink();
		}
		return val;
	}

	public boolean isEmpty() {
		return n==-1?true:false;
	}

	public int size() {
		return n+1;
	}

	public int capacity() {
		return capacity;
	}

	private void resize() {
		int temp[]=new int[capacity*2];
		for(int i=0;i<capacity;i++) {
			temp[i]=list[i];
		}
		list=temp;
		capacity*=2;
	}

	private void shrink() {
		if(capacity<=10) {
			return;
		}
		int temp[]=new int[capacity/2];
		for(int i=0;i<=n;i++) {
			temp[i]=list[i];
		}
		list=temp;
		capacity/=2;
	}
}
