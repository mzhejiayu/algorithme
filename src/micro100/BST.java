package micro100;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 这个类是关于二叉查找树的构建与双向链表化，简单地说，将它变成一个有序链表的原理和中序遍历一样。
 * 每次遍历到的结点变成链表的lastNode,每次遍历到的结点都和lastNode构建新的列表结点。
 * */
public class BST {
	private BSTNode m_head;
	public BST(List<Integer> list){
		if(list.size()==0){
			
		}else if(list.size()>0){
			Iterator<Integer> ii = list.iterator();
			m_head = new BSTNode(ii.next());
			while(ii.hasNext()){
				putInPosition(m_head, ii.next());
			}
		}
		
	};
	private void putInPosition(BSTNode root, int number){
		if(number == root.m_value){
			//ignore
		}else if(number < root.m_value){
			if(root.m_left != null){
				putInPosition(root.m_left, number);
			}else{
				root.m_left = new BSTNode(number);
			}
		}else if(number > root.m_value){
			if(root.m_right != null){
				putInPosition(root.m_right, number);
			}else{
				root.m_right = new BSTNode(number);
			}
		}
	};
	public BSTNode getHead(){
		return m_head;
	}
	public void displayBST(){
		preorder(m_head);
	}
	public void preorder(BSTNode root){
		if(root == null)
			return;
		preorder(root.m_left);
		System.out.print(root.m_value+" ");
		preorder(root.m_right);
	}
	public BSTNode toDDList(){
		BSTNode head = findLeftMost(m_head);
		
		constructList(m_head, null);
		return head;
	}
	
	public BSTNode constructList(BSTNode root, BSTNode lastNode){
		if(root == null)
			return lastNode;
		lastNode = constructList(root.m_left, lastNode);
		if(lastNode!=null){
			System.out.print(lastNode.m_value+" > "+root.m_value+"  ");
			lastNode.m_right = root;
			root.m_left = lastNode;
		}
		
		System.out.println((lastNode==null?"xx":lastNode.m_value) +" --> " +root.m_value);
		lastNode = root;

		return constructList(root.m_right, lastNode);
	};
	
	public BSTNode findRightMost(BSTNode root){
		while(root.m_right!=null)
		{
			root = root.m_right;
		}
		return root;
	}
	
	public BSTNode findLeftMost(BSTNode n){
		while(n.m_left!=null){
			n = n.m_left;
		}
		return n;
	}
	
public static void main(String args[]){
		
		Integer []  i = {14,55,1,45,77,11,23,4, 134,34,1,3};
		List<Integer> ai = (List<Integer>) Arrays.asList(i);
		BST n = new BST(ai);
		n.displayBST();
		System.out.println("");
		BSTNode headList = n.toDDList();
		while(headList!=null){
			System.out.print(headList.m_value+" ");
			headList = headList.m_right;
		}
		LinkedList<Integer> list = new LinkedList<>();
		
	}
	
}

class BSTNode{
	BSTNode m_left;
	BSTNode m_right;
	Integer m_value;
	public BSTNode(int value){
		this.m_value = value;
	}
	public BSTNode(){
		
	}
}
