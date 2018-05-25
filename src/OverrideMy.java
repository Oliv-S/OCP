import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class OverrideMy {

	private String info;
	private int counter;
	
	public OverrideMy(String info, int counter) {
		super();
		this.info = info;
		this.counter = counter;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return null;
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}



	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}



	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + counter;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		*/
		return this.counter+7*this.info.hashCode();
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		//return EqualsBuilder.reflectionEquals(this, obj);
		if (!(obj instanceof OverrideMy)) {
			return false;
		}
		OverrideMy other = (OverrideMy) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(counter, other.counter).isEquals();
	}



	public OverrideMy() {
		// TODO Auto-generated constructor stub
	}

}
