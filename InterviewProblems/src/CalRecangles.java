
public class CalRecangles {
	public int calRecs(int m, int n){
		int count=0;
		for(int i=0;i<=m-1;i++){
			for(int j=0;j<=n-1;j++){
				for(int ii=i+1;ii<=m;ii++){
					for(int jj=j+1;jj<=n;jj++){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main (String[] args){
		CalRecangles obj=new CalRecangles();
		System.out.println(obj.calRecs(1, 1));
		System.out.println(obj.calRecs(2, 2));
		System.out.println(obj.calRecs(3, 3));
	}
}
