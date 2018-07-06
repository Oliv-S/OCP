public class MyEnums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HI. This is enum Demo.");	
		
		//Season s = Season.SUMMER;
		for (Season curresntSeason : Season.values()) {
			switch (curresntSeason) {
			case SUMMER:
				printInfo(curresntSeason);
				break;
			case WINTER:
				printInfo(curresntSeason);
				break;
			case AUTUMN:
				printInfo(curresntSeason);
				break;
			default:
				printInfo(curresntSeason);
				break;
			}
			System.out.println("-------------");
		}

		
	


	}
	
	private static void printInfo(Season s) {
		System.out.println(s.name());
		System.out.println(s.ordinal());
		System.out.println(s.getInfo());
		s.printDayLength();
	}
	

}
