import java.util.Iterator;

/**
 * just created the LinkStrand class -avery
 * completed all methods except for reverse and charAt
 */
public class LinkStrand implements IDnaStrand {

	private class Node {
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	private Node myFirst,myLast;
	private long mySize;
	private int myAppends;
	private int myIndex; 
	private int myLocalIndex; 
	private Node myCurrent; 


	public LinkStrand() {
		this("");
	}

	public LinkStrand(String s) {
		initialize(s);
	}

	@Override
	public long size() {
		return mySize;
	}

	@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		myAppends = 0;
		mySize = source.length();
		myLast = myFirst;
		myIndex= 0;  
		myLocalIndex=0; 
		myCurrent= myFirst;  
	}

	@Override
	public String toString() {
		StringBuilder strand = new StringBuilder();
		Node temp = myFirst;
		while (temp.next != null) {
			strand.append(temp.info);
			temp = temp.next;
		}
		strand.append(myLast.info);
		return strand.toString();
	}

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += dna.length();
		myAppends++;
		return this;

	}

	@Override
	public int getAppendCount() {
		return myAppends;
	}

	@Override
	public IDnaStrand reverse() {
		Node temp = myFirst;
		Node last = myFirst;
		StringBuilder copy = new StringBuilder(temp.info);
		String xx = copy.reverse().toString();
		Node current = new Node(xx);

		while (temp.next != null) {
			StringBuilder dup = new StringBuilder(temp.next.info);
			String yy = dup.reverse().toString();
			Node previous = new Node(yy);
			previous.next = current;
			current = previous;
			temp = temp.next;
		}
		LinkStrand finishing = new LinkStrand ();
		
		finishing.myFirst= current; 
		finishing.myLast= last; 
		
		return finishing;
	}



	@Override
	public char charAt(int index) {
		if (index>= mySize || index<0) {
			throw new IndexOutOfBoundsException(); 
		}
		int count = 0;
		int dex = 0;
		Node list = myFirst;
		if (index > myIndex) {
			count= myIndex; 
			dex=myLocalIndex; 
			list= myCurrent; 
		}
		while (count != index) {
			count++;
			dex++;
			if (dex >= list.info.length()) {
				dex = 0;
				list = list.next;
			}
		}
		myIndex= index; 
		myLocalIndex= dex; 
		myCurrent= list;  
		return list.info.charAt(dex);
	}	
}
