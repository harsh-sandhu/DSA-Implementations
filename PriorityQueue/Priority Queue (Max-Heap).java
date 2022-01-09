class PriorityQueue {

	private int pq[];
	private int n;
	private static int capacity=5;

	//Constructors
	//1.
	public PriorityQueue() {
		this(capacity);
	}

	//2.
	public PriorityQueue(int initialCapacity) {
		pq=new int[initialCapacity];
		n=0;
	}

	//Functions
	public void push(int val) {
		if(n==capacity-1) {
			int temp[]=new int[capacity*2];
			for(int i=0;i<capacity;i++) {
				temp[i]=pq[i];
			}
			pq=temp;
			capacity*=2;
		}
		pq[++n]=val;
		swim(n);
	}

	public int peek() {
		return pq[1];
	}

	public int poll() {
		int maxEle=pq[1];
		this.exchange(1, n--);
		sink(1);
		pq[n+1]=0;
		return maxEle;
	}

	public boolean isEmpty() {
		return n==0?true:false;
	}

	public int printSize() {
		return n;
	}

	public int printCapacity() {
		return capacity;
	}

	//Private Functions

	private void sink(int k) {
		while(2*k<=n) {
			int j=2*k;
			if(j<n&&pq[j]<pq[j+1])j++;
			if(pq[k]>=pq[j])break;
			exchange(k,j);
			k=j;
		}
	}

	private void swim(int k) {
		while(k>1&&pq[k/2]<pq[k]) {
			this.exchange(k/2, k);
			k/=2;
		}
	}

	private void exchange(int i,int j) {
		int temp= pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}

}
