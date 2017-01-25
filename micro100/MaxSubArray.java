package micro100;

import java.lang.reflect.Array;
import java.util.List;

/*
 * 求字数组最大和比如 -1 2 -3 4 -5 6 -7 max = 6
 * 解法： 
 * */
public class MaxSubArray {
	//每一个实例在初始化之后都可以获得一个_max
	public int _max;
	public MaxSubArray(int[] arr) {
		//accumulate 是一直变化的一个量，在遍历的过程中代表这到i位能够取到的最大值
		//遍历完之后就能在这些之中挑选到最大的，为了保证最高的效率，使用max来记录遍历过程中遇到的最大的，而不是存在accumulate数组中国年
		int accumulate = arr[0];
		int max = accumulate;
		for(int i = 1;i < arr.length; ++i){
			if(accumulate>0){
				accumulate+=arr[i];
			}else{
				accumulate = arr[i];
			}
			if(accumulate>max){
				max = accumulate;
			}
		}
		_max = max;
	}
	

}
