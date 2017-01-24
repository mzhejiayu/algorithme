import java.util.Scanner;

public class Main {

	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			Main.max = 0;
			String s = in.nextLine();
			Main.FindSolution(0,s.length()-1,s,0);
			System.out.println(s.length()-Main.max);
		}
		
	}
	static int max(int a,int b){
		return a>b?a:b;
	}
	static void FindSolution(int left, int right, String s, int depth){
		if(right<left){
			//结束状态 最大值为 2*depth
//			System.out.println(2*depth+" 1");
			Main.max = Main.max(Main.max,2*depth);
		}
		else if(right==left){
			//结束状态 最大值为2*depth-1
//			System.out.println(2*depth+1+ " 2");
			Main.max = Main.max(Main.max,2*depth+1);
		}
		else{
			int i = left;
			int match = left;
			//找到一个配对
			for(;i<right;++i){
				boolean find = false;
				int j = right;
				for(; j > match;--j){
					if(s.charAt(i) == s.charAt(j)){
						find = true;
						break;
					}
				}
				if(!find)
					continue;
					
				match = j;
				Main.FindSolution(i+1, j-1, s, depth+1);
				
			}
			
			//最大数为 depth*2 + 1
//			System.out.println(2*depth+1 +" 3");
			Main.max = Main.max(Main.max,2*depth+1);
			
		}
		
	}

}
