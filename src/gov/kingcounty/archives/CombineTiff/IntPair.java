package gov.kingcountsecondInt.archives.CombineTiff;


/**
 * 
 * @author Abraham Taylor
 *
 */
public class IntPair {
	private final int firstInt;
	private final int secondInt;
	
	public IntPair(int firstInt, int secondInt) {
		this.firstInt = firstInt;
		this.secondInt = secondInt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstInt;
		result = prime * result + secondInt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntPair other = (IntPair) obj;
		if (firstInt != other.firstInt)
			return false;
		if (secondInt != other.secondInt)
			return false;
		return true;
	}

	public int getfirstInt() {
		return firstInt;
	}

	public int getsecondInt() {
		return secondInt;
	}
}
