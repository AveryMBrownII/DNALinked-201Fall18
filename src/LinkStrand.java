
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
		/*StringBuilder copy = new StringBuilder(myInfo);
		copy.reverse();
		LinkStrand ss = new LinkStrand(copy.toString());
		return ss;*/
		
	}

	@Override
	public char charAt(int index) {
		return myInfo.charAt(index);
	}	
}
