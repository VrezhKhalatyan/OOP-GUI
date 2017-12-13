package lab11;

public class MonsterAttack {
	private int id;
	private int day;
	private int month;
	private int year;
	private String nameOfMonster;
	private String locationOfAttack;
	private int numOfVictims;

	public MonsterAttack(int idIn, int dayOfMonthIn, int monthIn, int yearIn, String nameOfMonsterIn,
			String locationOfAttackIn, int numOfVictimsIn) {
		id = idIn;
		day = dayOfMonthIn;
		month = monthIn;
		year = yearIn;
		nameOfMonster = nameOfMonsterIn;
		locationOfAttack = locationOfAttackIn;
		numOfVictims = numOfVictimsIn;

		String sDate = "MM/DD/YYYY";
		String[] splitDate = sDate.split("/");
		@SuppressWarnings("unused")
		String day = splitDate[0];
		@SuppressWarnings("unused")
		String month = splitDate[1];
		@SuppressWarnings("unused")
		String year = splitDate[2];

	}

	public int getId() {
		return id;
	}

	public void setId(int idIn) {
		this.id = idIn;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int dayOfMonthIn) {
		this.day = dayOfMonthIn;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int monthIn) {
		this.month = monthIn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int yearIn) {
		this.year = yearIn;
	}

	public String getNameOfMonster() {
		return nameOfMonster;
	}

	public void setNameOfMonster(String nameOfMonsterIn) {
		this.nameOfMonster = nameOfMonsterIn;
	}

	public String getLocationOfAttack() {
		return locationOfAttack;
	}

	public void setLocationOfAttack(String locationOfAttackIn) {
		this.locationOfAttack = locationOfAttackIn;
	}

	public int getNumOfVictims() {
		return numOfVictims;
	}

	public void setNumOfVictims(int numOfVictimsIn) {
		this.numOfVictims = numOfVictimsIn;
	}

	public String toString() {
		return "Attack # " + id + " occured on " + day + "/" + month + "/" + year + ". " + nameOfMonster + " attacked "
				+ locationOfAttack + ", resulting in " + numOfVictims + " tragic fatalities.";
	}

}
