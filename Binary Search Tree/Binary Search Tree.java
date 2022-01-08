import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinarySearchTree {

	//inner class for Node
	private class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			left=null;
			right=null;
		}
	}

	//Intialize the base node root
	Node root=null;


	//INSERT
	public void insert(int data) {
		if(root==null) {
			root=new Node(data);
			return;
		}
		root=insert(root,data);
	}
	private Node insert(Node node,int data) {
		if(node==null) {
			return new Node(data);
		}
		if(data<node.data) {
			node.left=insert(node.left,data);
		}
		if(data>node.data) {
			node.right=insert(node.right,data);
		}
		return node;
	}

	//SEARCH
	public boolean search(int data) {
		Node node=search(root,data);
		if(node==null) {
			return false;
		}
		return true;
	}
	private Node search(Node node,int data) {
		if(node==null) {
			return null;
		}
		if(data<node.data) {
			return search(node.left,data);
		}
		if(data>node.data) {
			return search(node.right,data);
		}
		if(data==node.data) {
			return node;
		}
		return null;
	}

	//HEIGHT
	public int height() {
		return height(root);
	}
	private int height(Node node) {
		if(node==null) {
			return 0;
		}
		int leftHeight=height(node.left);
		int rightHeight=height(node.right);
		return 1+Math.max(leftHeight,rightHeight);
	}

	//MINIMUM
	public int min() {
		Node ans=min(root);
		return ans.data;
	}
	private Node min(Node node) {
		if(node.left==null) {
			return node;
		}
		return node.left;
	}

	//MAXIMUM
	public int max() {
		Node ans=max(root);
		return ans.data;
	}
	private Node max(Node node) {
		if(node.right==null) {
			return node;
		}
		return node.right;
	}


	//DELETION
	public void delete(int data) {
		root=delete(root,data);
	}
	private Node delete(Node node,int data) {
		if(node==null) {
			return null;
		}
		if(data<node.data) {
			node.left=delete(node.left,data);
		}
		if(data>node.data) {
			node.right=delete(node.right,data);
		}

		//if data is found
		if(node.data==data) {
			//Leaf node
			if(node.left==null&&node.right==null) {
				node=null;
			}
			//had only right child
			else if(node.left==null) {
				node=node.right;
			}
			//has only left child
			else if(node.right==null) {
				node=node.left;
			}
			//if it has both children
			//find the minimum in right substree
			//attach the left subtree to minimum of right subtree
			else {
				Node minRight=min(node.right);
				minRight.left=node.left;
				node=node.right;
			}
		}
		return node;
	}


	//Lowest Common Ancestor
	public int lowestCommonAncestor(int val1,int val2) {
		if(search(val1)&&search(val2)) {
			Node node=lca(root,val1,val2);
			return node.data;
		}
		return -1;
	}
	private Node lca(Node node,int val1,int val2) {
		if(node.data<val1&&node.data<val2) {
			return lca(node.right,val1,val2);
		}
		if(node.data>val1&&node.data>val2) {
			return lca(node.left,val1,val2);
		}
		return node;
	}



	//TRAVERSAL

	//Inorder
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	private void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}

	//PreOrder
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	//PostOrder
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	private void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}

	//LevelOrder
	public void levelOrder() {
		levelOrder(root);
		System.out.println();
	}
	private void levelOrder(Node node) {
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		while(q.size()>0) {
			Node top=q.remove();
			System.out.print(top.data+" ");
			if(top.left!=null) {
				q.add(top.left);
			}
			if(top.right!=null) {
				q.add(top.right);
			}
		}
	}

	//ZigZag Order
	public void zigzagOrder() {
		zigzagOrder(root);
		System.out.println();
	}
	private void zigzagOrder(Node node) {
		Stack<Node> currLvl=new Stack<>();
		Stack<Node> nextLvl=new Stack<>();
		boolean leftToRight=true;
		currLvl.add(node);
		while(currLvl.size()>0) {
			Node top=currLvl.pop();
			System.out.print(top.data+" ");

			if(leftToRight) {
				if(top.left!=null) {
					nextLvl.push(top.left);
				}
				if(top.right!=null) {
					nextLvl.push(top.right);
				}
			}else {
				if(top.right!=null) {
					nextLvl.push(top.right);
				}
				if(top.left!=null) {
					nextLvl.push(top.left);
				}
			}

			if(currLvl.size()==0) {
				currLvl.addAll(nextLvl);
				nextLvl.clear();
				leftToRight=!leftToRight;
			}
		}
	}

}
