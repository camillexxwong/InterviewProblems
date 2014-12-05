
public class FindSecondMax {
	public int find(int[] array){
		int maxIdx=0;
		int sMaxIdx=0;
		for (int i=0;i<array.length;i++){
			if(array[i]>array[sMaxIdx]){
				if(array[i]>array[maxIdx]) {
					sMaxIdx=maxIdx;
					maxIdx=i;
				}
				else sMaxIdx=i;
			}
		}
		return array[sMaxIdx];
	}
	
	public static void main(String[] args){
		int[] array1={1,4,3,2,6,5,7};
		FindSecondMax obj=new FindSecondMax();
		System.out.println(obj.find(array1));
	}
}
