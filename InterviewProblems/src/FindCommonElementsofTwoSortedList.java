import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


/**
 * @author cawang
 * Company: Tujia
 * From: Wanxin
 * Problem: given 2 sorted arrays, find all the common elements between them
 * Time: O(m+n) or O(MlogN)
 * 
 * 
 */
public class FindCommonElementsofTwoSortedList {
	/**
	 * @param array1
	 * @param array2
	 * @return
	 * use the shorter array as M; use the longer array as logN
	 */
	public ArrayList<Comparable> find_O_MlogN(Comparable[] array1, Comparable[] array2){
		ArrayList<Comparable> result=new ArrayList<Comparable>();
		int length1=array1.length;
		int length2=array2.length;
		for(int i=0;i<length1;i++){
			int low=0;
			int high=length2;
			if(i>0&&array1[i]==array1[i-1]) continue;
			while(low<=high){
				int mid=low+(high-low)/2;
				if(array1[i].compareTo(array2[mid])==0) {
					result.add(array1[i]);
					break; //Don't forget
				}
				else if(array1[i].compareTo(array2[mid])>0) low=mid+1;
				else high=mid-1;
			}
		}
		return result;
	}
	
	@Test
	public void test(){
		Integer[] array1a={1,1,2,3,3,5};
		Integer[] array1b={2,4,5,5};
		String result1="[2, 5]";
		Integer[] array2a={1,1,2,3,3,5};
		Integer[] array2b={4,6,8,9};
		String result2="[]";
		assertEquals("",result1,find_O_MlogN(array1a,array1b).toString());
		assertEquals("",result2,find_O_MlogN(array2a,array2b).toString());
	}
}
