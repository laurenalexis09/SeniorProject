package characters;

public class RandomCharacter extends Character { //Arrays for choosing aspects of a character

	
	public String race;
	private String classType;
	private int stats[] = new int[6];
	private String background;
	String raceArray[] = {RACE_DRAGONBORN,RACE_DWARF, RACE_ELF, RACE_GNOME, RACE_HALF_ELF, RACE_HALFLING, RACE_HALF_ORC, RACE_HUMAN, RACE_TIEFLING}; //races
	String classArray[] = {CLASS_BARBARIAN, CLASS_BARD, CLASS_CLERIC, CLASS_DRUID, CLASS_FIGHTER, CLASS_MONK, CLASS_PALADIN, CLASS_RANGER, CLASS_ROGUE, CLASS_SORCERER, CLASS_WIZARD}; //classes
	String backgrounds[] = {"Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Gladiator", "Guild Artisan",
			"Hermit", "Knight", "Noble", "Outlander", "Pirate", "Sage", "Sailor", "Soldier", "Urchin"}; //backgrounds

	public RandomCharacter() { //Creates a random character
		randomizeRace();
		randomizeClass();
		this.setStats(statsClass(classType, getStats()));
		this.setStats(raceMod(race, getStats()));
		randomizeBackground();
	}

	public void randomizeRace() { //chooses a race
		int i = (int)(Math.random()*9);
		this.setRace(raceArray[i]);
	}

	public void randomizeClass() { //chooses a class 
		int i = (int)(Math.random()*11);
		this.setClassType(classArray[i]);
	}

	public int[] raceMod(String race, int[] stats) { //Adds respective race bonuses

		if(race.equals(RACE_DRAGONBORN)){
			stats[STAT_STRENGTH] += 2;
			stats[STAT_CHARMING] += 1;
		} else if(race.equals(RACE_DWARF)) {
			stats[STAT_CONSTITUTION] += 2;
		} else if(race.equals(RACE_ELF)) {
			stats[STAT_DEXTERITY] += 2;
		} else if(race.equals(RACE_GNOME)) {
			stats[STAT_INTELLIGENCE] += 2;
		} else if(race.equals(RACE_HALF_ELF)) {
			int i = (int)Math.random()*5+1;
			int j = (int)Math.random()*5+1;
			stats[STAT_CHARMING] += 2;
			stats[i] += 1;
			stats[j] += 1;
		} else if(race.equals(RACE_HALFLING)) {
			stats[STAT_DEXTERITY] += 2;
		} else if(race.equals(RACE_HALF_ORC)) {
			stats[STAT_STRENGTH] += 2;
			stats[STAT_CONSTITUTION] += 1;
		} else if(race.equals(RACE_HUMAN)) {
			stats[STAT_STRENGTH] += 1;
			stats[STAT_DEXTERITY] += 1;
			stats[STAT_CONSTITUTION] += 1;
			stats[STAT_INTELLIGENCE] += 1;
			stats[STAT_WISDOM] += 1;
			stats[STAT_CHARMING] += 1;
		} else if(race.equals(RACE_TIEFLING)) {
			stats[STAT_CHARMING] += 2;
			stats[STAT_INTELLIGENCE] += 1;
		}

		return stats;


	}

	public int[] statsClass(String classType, int[] stats) { //generates the stats 
		//[0]Strength, [1]dexterity, [2]constitution, [3]intelligence, [4]wisdom, [5]charisma

		int s1, s2, s3, s4, s5, s6 = 0;

		s1 = statsRoller(); //rolls the dice for each stat
		s2 = statsRoller();
		s3 = statsRoller();
		s4 = statsRoller();
		s5 = statsRoller();
		s6 = statsRoller();

		int[] values = {s1, s2, s3, s4, s5, s6};

		selectionSort(values); //sorts them

		s1 = values[0];
		s2 = values[1];
		s3 = values[2];
		s4 = values[3];
		s5 = values[4];
		s6 = values[5];


		if(classType.equals(CLASS_BARBARIAN)) {

			stats[STAT_STRENGTH] = s1;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s6;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_BARD)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s4;
			stats[STAT_CHARMING] = s1;

			return stats;
		}

		if(classType.equals(CLASS_CLERIC)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s1;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_DRUID)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s1;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_FIGHTER)) {

			stats[STAT_STRENGTH] = s1;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s6;
			stats[STAT_WISDOM] = s5;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_MONK)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s1;
			stats[STAT_CONSTITUTION] = s3;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s2;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_PALADIN)) {

			stats[STAT_STRENGTH] = s1;
			stats[STAT_DEXTERITY] = s4;
			stats[STAT_CONSTITUTION] = s3;
			stats[STAT_INTELLIGENCE] = s6;
			stats[STAT_WISDOM] = s5;
			stats[STAT_CHARMING] = s2;

			return stats;
		}

		if(classType.equals(CLASS_RANGER)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s1;
			stats[STAT_CONSTITUTION] = s3;
			stats[STAT_INTELLIGENCE] = s5;
			stats[STAT_WISDOM] = s2;
			stats[STAT_CHARMING] = s4;

			return stats;
		}

		if(classType.equals(CLASS_ROGUE)) {

			stats[STAT_STRENGTH] = s5;
			stats[STAT_DEXTERITY] = s1;
			stats[STAT_CONSTITUTION] = s3;
			stats[STAT_INTELLIGENCE] = s4;
			stats[STAT_WISDOM] = s6;
			stats[STAT_CHARMING] = s2;

			return stats;
		}

		if(classType.equals(CLASS_SORCERER)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s4;
			stats[STAT_WISDOM] = s5;
			stats[STAT_CHARMING] = s1;

			return stats;
		}

		if(classType.equals(CLASS_WIZARD)) {

			stats[STAT_STRENGTH] = s6;
			stats[STAT_DEXTERITY] = s3;
			stats[STAT_CONSTITUTION] = s2;
			stats[STAT_INTELLIGENCE] = s1;
			stats[STAT_WISDOM] = s4;
			stats[STAT_CHARMING] = s5;

			return stats;
		}

		

		return stats;
	}

	public int statsRoller() { //Method for rolling dice for stats
		int value = 0;

		int median = 0;

		int r1 = (int)(Math.random()*6+1);

		int r2 = (int)(Math.random()*6+1);

		int r3 = (int)(Math.random()*6+1);

		int r4 = (int)(Math.random()*6+1);


		median = r1;


		if(r2 < median) {
			median = r2;
		}

		if(r3 < median) {
			median = r3;
		}

		if(r4 < median) {
			median = r4;
		}

		value = (r1+r2+r3+r4-median); //Rolls 4 dice, takes the best 3 and returns it

		return value;
	}

	public void randomizeBackground() { //selects background

		int i = (int)(Math.random()*16);
		background = backgrounds[i];
	}

	public static void selectionSort(int[] list){
		int i, j, first, temp; 
		for ( i = list.length - 1; i > 0; i--) 
		{
			first = 0;   //initialize to subscript of first element
			for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
			{
				if( list[ j ] < list[ first ] )         
					first = j;
			}
			temp = list[ first ];   //swap smallest found with element in position i.
			list[ first ] = list[ i ];
			list[ i ] = temp; 
		}           
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int[] getStats() {
		return stats;
	}

	public void setStats(int stats[]) {
		this.stats = stats;
	}
	
	
}
