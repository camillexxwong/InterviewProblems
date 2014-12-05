import static java.lang.System.setProperty;

import java.util.List;


public class LinkedList {
	int val;
	LinkedList next;
	public LinkedList(int val) {
		
		this.val=val;
	}
	
	@Override
	public String toString(){
		StringBuffer s=new StringBuffer("");
		LinkedList temp=this;
		while(temp!=null){
			//System.out.println("toString: "+temp.val);
			s.append(temp.val);
			temp=temp.next;
		}
		return s.toString();
	}
	public static LinkedList makeLinkedList(int[] vals) {
		LinkedList temp=new LinkedList(0);
		LinkedList dummyHead=temp;
		for(int v:vals){
			temp.next=new LinkedList(v);
			temp=temp.next;
		}
		return dummyHead.next;
	}
	
	public static LinkedList reverse(LinkedList list){
		if(list==null)return list;
		LinkedList prev=list;
		LinkedList cur=prev.next;
		prev.next=null;//!!
		while(cur!=null){
			LinkedList next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		return prev; //!!
	}
	
	//default: m=1, n=list.length
	public static LinkedList reverse(LinkedList head, int m, int n){
		if(head==null)return head;
		LinkedList start=head;
		LinkedList startPre=head;
		int len=n-m+1;
		int tempm=m;
		while(tempm>1){
			startPre=start;
			start=start.next;
			tempm--;
		}
		LinkedList prev=start;
		LinkedList cur=prev.next;
		prev.next=null;//!!
		while(len>1&&cur!=null){
			LinkedList next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
			len--;
		}
		
		start.next=cur;//!!
		if(m==1) return prev;
		startPre.next=prev;//!!
		return head; //!!
	}
	public static void main(String[] args){
		LinkedList l1=makeLinkedList(new int[]{1,2,3,4,5});
		System.out.println(l1.toString());
		System.out.println(reverse(l1).toString());
		
		LinkedList l2=makeLinkedList(new int[]{1,2,3,4,5});
		System.out.println(l2.toString());
		System.out.println(reverse(l2,2,4).toString());
		
		LinkedList l3=makeLinkedList(new int[]{1,2});
		System.out.println(l3.toString());
		System.out.println(reverse(l3,1,2).toString());
	}
}
