/**
 * 
 */

/**
 * @author User
 *
 */
public enum Season {
	WINTER("5"){public void printDayLength() {System.out.println("5 Hour");}}, 
	SPRING("15"){public void printDayLength() {System.out.println("8 Hour");}}, 
	SUMMER("25"){public void printDayLength() {System.out.println("12 Hour");}}, 
	AUTUMN("11"){public void printDayLength() {System.out.println("7 Hour");}};
	private String info;

	private Season(String info) {
		this.info = info;
		//System.out.println(info);
	}

	public String getInfo() {
		return info;
	}
	
	public abstract void printDayLength();
	
}
