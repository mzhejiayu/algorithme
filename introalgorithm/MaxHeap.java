package introalgorithm;

import java.util.ArrayList;

/*
 * 
 * 最大堆的实现， 主要的函数就是siftdown，同时也是维护的函数
 */
public class MaxHeap {
	ArrayList<Integer> _list;
	
	public MaxHeap(int [] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i< arr.length; ++i){
			list.add(arr[i]);
		}
		construct(list);
	}
	public void insert(){
		
	}
	public int deletemax(){
		int result = _list.get(0);
		_list.set(0, _list.get(_list.size()-1));
		_list.remove(_list.size()-1);
		siftdown(0);

		return result;
		
	}
	private void construct(ArrayList<Integer> arr){
		_list = arr;
		for(int i = (_list.size()) /2 - 1 ; i>=0; --i){
			siftdown(i);
		}
	}
	public void display(){
		for(int i = 0; i< _list.size(); ++i ){
			System.out.print(_list.get(i)+" ");
		}
		System.out.println("");
	}
	
	int RIGHT(int root){
		return (root << 1) + 2;
	}
	int LEFT(int root){
		return (root << 1) + 1;
	}
	
	private void siftdown(int index){
		if( index > _list.size()/2 -1 ){
			//ignore if it is the leaf
			return;
		}
		
		if(_list.size() -1 == LEFT(index) ){
			//Has only left child
			int leftChild = LEFT(index);
			if(_list.get(index) < _list.get(leftChild)){
				int temp = _list.get(index);
				_list.set(index, _list.get(leftChild)); 
				_list.set(leftChild, temp);
			}
		}else{
			int canCompare, i1 = LEFT(index), i2 = RIGHT(index);
			if(_list.get(i1)>_list.get(i2)){
				canCompare = i1;
			}else{
				canCompare = i2;
			}
			if(_list.get(canCompare)>_list.get(index)){
				int temp = _list.get(index);
				_list.set(index, _list.get(canCompare));
				_list.set(canCompare, temp);
			}
			siftdown(canCompare);
		}
			
		
	};
	
	public static void main(String arg[]){
		int a[] =  {1,2,3,45,6,88,12,1,1,44};
		MaxHeap h = new MaxHeap(a);
		
	}
}
