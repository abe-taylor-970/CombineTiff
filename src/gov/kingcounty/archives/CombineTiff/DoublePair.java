package gov.kingcounty.archives.CombineTiff;


/**
 * 
 * @author Abraham Taylor
 *
 */
public class DoublePair {
	private final double firstdouble;
	private final double seconddouble;
	
	public DoublePair(double firstdouble, double seconddouble) {
		this.firstdouble = firstdouble;
		this.seconddouble = seconddouble;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)firstdouble;
		result = prime * result + (int)seconddouble;
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
		DoublePair other = (DoublePair) obj;
		if (firstdouble != other.firstdouble)
			return false;
		if (seconddouble != other.seconddouble)
			return false;
		return true;
	}

	public double getfirstdouble() {
		return firstdouble;
	}

	public double getseconddouble() {
		return seconddouble;
	}
}
