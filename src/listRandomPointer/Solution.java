package listRandomPointer;

public class Solution {
	public static void main(String[] args) {
		RandomListNode node0 = new RandomListNode(0);
		RandomListNode node1 = new RandomListNode(1);
		
		node0.next = node1;
		node0.random = node1;
		printList((new Solution()).copyRandomList(node0));
	}
	
	public static void printList(RandomListNode node) {
		System.out.print("[");
		while (node != null) {
			System.out.print(node.label + ",");
			node = node.next;
		}
		System.out.println("]");
	}
	static class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	}
	
   public RandomListNode copyRandomList(RandomListNode head) {
	   if (head == null) return null;
	   
	   // copy the list: head -> newHead -> node1 -> newNode1...
	   RandomListNode pos = head;
	   while (pos != null) {
		   RandomListNode cur = pos;
		   pos = pos.next;
		   
		   RandomListNode copy = new RandomListNode(cur.label);
		   copy.next = cur.next;
		   cur.next = copy;
		   
		   copy.random = cur.random;
	   }
	   	   
	   // move the random pointers to the correct node
	   pos = head;
	   while (pos != null) {
		   RandomListNode posCp = pos.next;
		   if (posCp.random != null)
			   posCp.random = posCp.random.next;
		   
		   pos = posCp.next;
	   }
	   	   
	   // now extract the list
	   RandomListNode newHead = head.next;
	   pos = head;
	   while (pos != null) {
		   RandomListNode posCp = pos.next; // belong to the list
		   pos.next = pos.next.next;
		   pos = pos.next;
		   
		   if (posCp.next != null) {
			   posCp.next = posCp.next.next;
		   }
	   }
	   
	   return newHead;
   }
}