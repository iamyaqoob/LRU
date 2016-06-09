import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

class lru{
	
	public static void main(String lol[]){
		dll list = new dll(4);
		Set <Integer > map = new HashSet<Integer>();
		int input;
		Scanner in = new Scanner(System.in);
		while(true){
			input = in.nextInt();
			if(map.contains(input)){
				System.out.println(input+ " present");
				list.addc(input);
				list.display();
			}
			else{
				System.out.println(input+ " not present");
				map.add(input);
				list.add(input);
				list.display();
			}
		}
	}
}
class node{
	int data;
	node prev;
	node next;
	node(int d ){
		data = d;
		prev = null;
		next = null;
	}
}
class dll{
	node head;
	int size ;
	int count;
	dll(int d){
		size = d;
		count =1;
		head =null;
	}
	public void add(int d){
		node x = new node(d);
		if(head==null){
			System.out.println("count = 1");
			head = x;
			count++;
			return;
		}
		else if(count <= size){
			System.out.println("size less or equal " + size);
			x.next = head;
			head.prev = head;
			head = x;
			count++;
			return;
		}
		else{
			System.out.println("full");
			node n = head;
			
			while(n.next.next!=null){
				n = n.next;
			}
			System.out.println(n.data);
			
			
			n.next.prev = null;
			n.next =  null;
			
			x.next = head;
			head.prev = x;
			head = x;
		}
	}
	public void addc(int d){
		node n = head;
		
		if(d == n.data){
			return;
		}
		node t = null;
		while(n.data != d && n.next!=null){
			t = n;
			n = n.next;
		}
		System.out.println("FOUND!");
		
		if(n.next==null){
			t.next = null;
		}
		else{
			t.next = n.next;
			n.next.prev = t;
			//System.out.println(t.data + " ---  "+n.next.data);
		}
		
		n.prev = null;
		n.next = head;
		head.prev = n;
		head = n;
		//count++;
		return;
	}
	public void display(){
		node n = head;
		String s="";
		while(n!=null){
			s+=n.data+" ";
			n = n.next;
		}
		System.out.println("[ "+s+" ]");
	}
}