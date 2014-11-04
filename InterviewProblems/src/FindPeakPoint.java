import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;


/**
 * @author cawang
 * Company: Tujia
 * From: Wanxin
 * Problem: given an array, if array[i]>array[i-1]&&array[i]>array[i+1], array[i] is a peak pont
 * if i=0 && array[0}>array[1] or i=length-1 && array[i]>array[i-1], it's also peak
 * find any peak point of array, O(N) and  O(logN)
 * 
 * More Question: what if there're duplicate elements?
 */
public class FindPeakPoint {
	/**
	 * @param array
	 * @return
	 * O(logN), binary Search
	 */
	public Comparable findPeak_O_logN(Comparable[] array){
		if(array==null) return null;
		int targetIdx=-1;
		if( array[0].compareTo(array[1])>0)  targetIdx=0; //Don't use >=0; {0,0,1,2,3,4}
		else if(array[array.length-1].compareTo(array[array.length-2])>0) targetIdx=array.length-1;
		else {
			int low=0;
			int high=array.length-1;
			while(low<=high){
				int mid=low+(high-low)/2;
				if(array[mid].compareTo(array[mid-1])>0&&array[mid].compareTo(array[mid+1])>0){
					targetIdx=mid;
					break;
				}
				else if(array[mid].compareTo(array[mid-1])>0&&array[mid].compareTo(array[mid+1])<0){
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
			
		}
		if(targetIdx==-1)return null;
		return array[targetIdx];
	}
	
	public Comparable findPeak_O_N(Comparable[] array){
		if(array==null) return null;
		int targetIdx=-1;
		if(array[0].compareTo(array[1])>0)  targetIdx=0; //Don't use >=0; {0,0,1,2,3,4}
		else if(array[array.length-1].compareTo(array[array.length-2])>0) targetIdx=array.length-1;
		else{
			for(int i=1;i<array.length-1;i++){
				if(array[i].compareTo(array[i+1])>0){ //find the first element i that is larger than i+1, no need to compare with i-1
					targetIdx=i;
					break;
				}
			}
		}
		if(targetIdx==-1)return null;
		return array[targetIdx];
	}
	
	@Test
	public void test(){
		Integer[] array1={0,0,1,2,3,4};
		Integer result1=4;
		Integer[] array2={5,4,2,1,1};
		Integer result2=5;
		Integer[] array3={1,2,5,4,3};
		Integer result3=5;
		Integer[] array4={1,2,5,4,3,6,2};
		Integer result4=5;
		assertEquals(""+Arrays.toString(array1)+"; "+result1,result1,findPeak_O_logN(array1));
		assertEquals(""+Arrays.toString(array2)+"; "+result2,result2,findPeak_O_logN(array2));
		assertEquals(""+Arrays.toString(array3)+"; "+result3,result3,findPeak_O_logN(array3));
		assertEquals(""+Arrays.toString(array4)+"; "+result4,result4,findPeak_O_logN(array4));
		
		assertEquals(""+Arrays.toString(array1)+"; "+result1,result1,findPeak_O_N(array1));
		assertEquals(""+Arrays.toString(array2)+"; "+result2,result2,findPeak_O_N(array2));
		assertEquals(""+Arrays.toString(array3)+"; "+result3,result3,findPeak_O_N(array3));
		assertEquals(""+Arrays.toString(array4)+"; "+result4,result4,findPeak_O_N(array4));
		
	}
}
