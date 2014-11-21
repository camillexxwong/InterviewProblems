import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

//use shell:
//awk '{a[$1]++;sum[$1]+=$2}END{for (i in a) print i,sum[i]/a[i]}'  ufile

public class CalAverage {
	public static void main(String[] args){
		int[][] array1={{1,10},{1,19},{2,20},{3,30}};
		CalAverage obj=new CalAverage();
		System.out.println(Arrays.deepToString(obj.calAvg(array1)));
	}
	
	public float[][] calAvg(int[][] table){
		Hashtable<Integer, Integer[]> hashTable=new Hashtable<Integer, Integer[]>();
		for(int[] a:table){
			int key=a[0];
			int oldSum=0;
			int oldCount=0;
			if(hashTable.containsKey(key)){
				oldSum=hashTable.get(key)[0];
				oldCount=hashTable.get(key)[1];
			}
			hashTable.put(key, new Integer[]{oldSum+a[1],oldCount+1});
		}
		float[][] result=new float[hashTable.size()][2];
		Iterator<Integer> it=hashTable.keySet().iterator();
		for(float[] a:result){
			int key=it.next();
			a[0]=key;
			a[1]=hashTable.get(key)[0]/hashTable.get(key)[1];
		}
		return result;
	}
}
