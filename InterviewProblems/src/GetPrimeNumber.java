import java.util.ArrayList;
import java.util.Arrays;


public class GetPrimeNumber {
	/*public int[] getPrimeNumber(){
		ArrayList<Integer> numsArrayList=new ArrayList<Integer>();
		for(int i=1;i<=300;i++){
			numsArrayList.add(i);
		}
		for(int i=2;i<=300;i++){
			int multiple=i;
			for(int k=1;multiple<300;k++){
				numsArrayList.remove(multiple-1);
				multiple*=k;
			}
		}
		int[] result=new int[numsArrayList.size()];
		for(int a:numsArrayList){
			result[a-1]=a;
		}
		return result;
	}*/
	
	/**
	 *  用筛法求300以内质数
	 * @return
	 */
	public int[] getPrimeNumber(){
		int max=300;
		int[] nums=new int[max];
		int count=max;
		int sqrt=(int)Math.sqrt(max);
		//初始化数组
		for(int i=1;i<=max;i++){
			nums[i-1]=i;
		}
		//将i的倍数设为-1
		for(int i=2;i<=sqrt;i++){
			int k=2;
			int multiple=i*k;
			for(;multiple<=max;multiple=i*++k){
				if(nums[multiple-1]==-1)continue;
				nums[multiple-1]=-1;
				count--;
			}
		}
		System.out.println("count: "+count);
		//将不为-1的值存入新数组
		int[] result=new int[count];
		for(int j=0,k=0;j<nums.length;j++){
			if(nums[j]!=-1)	result[k++]=nums[j];
		}
		return result;
	}
	
	public static void main(String[] args){
		GetPrimeNumber obj =new GetPrimeNumber();
		System.out.println(Arrays.toString(obj.getPrimeNumber()));
	}
}
