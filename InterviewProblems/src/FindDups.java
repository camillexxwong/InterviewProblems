import java.util.HashSet;


public class FindDups {
	static String str="1";
	public static void main(String[] args){ 
		HashSet<Test> set=new HashSet<Test>();
		FindDups o=new FindDups();
		Test t1=o.new Test(1);
		Test t2=o.new Test(2);
		set.add(t1);
		set.add(t2);
		System.out.println(t1.equals(t2));
		System.out.println(set.toString());
		
	}
	public void test(){
		str="2";
	}
	public class Test{
		int val;
		Test(int val){
			this.val=val;
		}
		@Override
		public boolean equals(Object o){
			return true;
		}
		@Override
		public int hashCode(){
			return val;
		}
		@Override
		public String toString(){
			return super.toString()+"; val: "+ val;
		}
	}

}
