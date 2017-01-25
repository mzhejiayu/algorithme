package micro100;


import java.util.LinkedList;
/*
 * 构建一个拥有push pop min函数的一个栈，并且这些操作均为O(1)
 * 解法：将上一个min的信息储存在新的min中，在新的min退出之后，可以还原min
 */
public class StackWithMinO1 {
	
	LinkedList<Integer> _list;
	int _min;
	public StackWithMinO1() {
		// TODO Auto-generated constructor stub
		_list = new LinkedList<Integer>();
	}
	
	public int min() throws Exception{
		if(_list.isEmpty()){
			throw new Exception("No min because there is no element");
		}
		return _min;
	}
	public void push(int a){
		if(_list.isEmpty()){
			_min = a;
			_list.push(a);
		}else if(_min <= a){
			_list.push(a-_min);
		}else{
			//If new value is a new minimax
			_list.push(a-_min);
			_min = a;
		}
	}
	public int pop(){
		int raw =  _list.poll();
		if(_list.isEmpty()){
			return raw;
		}else if(raw<0){
			//If pop up the min value
			//Restore previous _min
			_min = _min - raw;
			return _min + raw;
		}else{
			//If pop up is not the min value
			return raw + _min;
		}
	}
	public static void main(String args[]){
//		StackWithMinO1 a = new StackWithMinO1();
//		a.push(111);
//		a.push(83);
//		a.push(99);
//		a.push(81);
//		a.pop();
//		a.pop();
//		a.pop();
//		a.pop();
//		try {
//			System.out.println(a.min());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
