
/**
 * just created the LinkStrand class -avery
 */
public class LinkStrand implements IDnaStrand {
	private String myInfo;
	private int myAppends;
	
	public LinkStrand() {
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
	}
	
	@Override
	public long size() {
		return myInfo.length();
	}

	@Override
	public void initialize(String source) {
		myInfo = new String(source);
		myAppends = 0;
	}

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		myInfo = myInfo + dna;
		myAppends++;
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		StringBuilder copy = new StringBuilder(myInfo);
		copy.reverse();
		LinkStrand ss = new LinkStrand(copy.toString());
		return ss;
	}

	@Override
	public int getAppendCount() {
		return myAppends;
	}

	@Override
	public char charAt(int index) {
		return myInfo.charAt(index);
	}	
}
