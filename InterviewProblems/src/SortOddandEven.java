import java.util.Arrays;


/**
 * @author cawang
 * Company: Meituan
 * From: me
 * Problem: Given an array, put all odd number to the first part of array, and even numbers the second part
 * {1,4,3,2,5}->{1,3,5,4,2}
 * Do not need to sort
 * in-place
 *  
 */
public class SortOddandEven {
	public int[] oddsort(int[] array){
		if(array==null) return null;
		int i=0;
		int j=array.length-1;
		while(true){	//notice, not while(i<j)
			while(array[i]%2==1){
				i++;
			}
			while(array[j]%2==0){
				j--;
			}
			if(i>=j) break;  //put the stop condition here!!
			int temp=array[j];
			array[j--]=array[i];
			array[i++]=temp;
		}
		return array;
	}
	
	public static void main(String[] args){
		SortOddandEven obj=new SortOddandEven();
		int[] array1={1,4,3,2,5};
		System.out.println("Ori: "+Arrays.toString(array1)+"; New: "+Arrays.toString(obj.oddsort(array1)));
	}
}
