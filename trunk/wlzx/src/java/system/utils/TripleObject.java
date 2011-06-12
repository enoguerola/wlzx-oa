package system.utils;

/**
 * 
 * @author Wu.Yuyue

 */
public class TripleObject<L,M,R> {
	
	private L left;
	private M middle;
	private R right;
	public TripleObject(){
		
	}
	
	public TripleObject(L left, M middle,R right){
		this.left = left;
		this.middle=middle;
		this.right = right;
		
	}

	public L getLeft() {
		return left;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public M getMiddle() {
		return middle;
	}

	public void setMiddle(M middle) {
		this.middle = middle;
	}

	public R getRight() {
		return right;
	}

	public void setRight(R right) {
		this.right = right;
	}
	

	
}
