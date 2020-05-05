package characters;

import listeners.CharacterGenerator;

public class RandomCharacter{ //Arrays for choosing aspects of a character
	public String race;
	private String classType;
	private int stats[] = new int[6];
	private String background;
	String raceArray[] = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"}; //races
	String classArray[] = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard"}; //classes
	String backgrounds[] = {"Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Gladiator", "Guild Artisan",
			"Hermit", "Knight", "Noble", "Outlander", "Pirate", "Sage", "Sailor", "Soldier", "Urchin"}; //backgrounds

	public RandomCharacter(String race, String classType, int[] statsClass, String background) { //Creates a random character
		race = races(race);
		classType = classes(classType);
		this.setStats(statsClass(classType, getStats()));
		this.setStats(raceMod(race, getStats()));
		this.setBackground(back(background));

		return;
	}

	public String races(String race) { //chooses a race

		int i = (int)(Math.random()*9);
		this.setRace(raceArray[i]);
		return raceArray[i];
	}

	public String classes(String classType) { //chooses a class 
		int i = (int)(Math.random()*11);
		this.setClassType(classArray[i]);
		return classArray[i];
	}

	public int[] raceMod(String race, int[] stats) { //Adds respective race bonuses

		if(race.equals("Dragonborn")){
			stats[0] += 2;
			stats[5] += 1;
			return stats;
		}

		if(race.equals("Dwarf")) {
			stats[2] += 2;
			return stats;
		}

		if(race.equals("Elf")) {
			stats[1] += 2;
			return stats;
		}

		if(race.equals("Gnome")) {
			stats[3] += 2;
			return stats;
		}

		if(race.equals("Half-Elf")) {
			int i = (int)Math.random()*5+1;
			int j = (int)Math.random()*5+1;
			stats[5] += 2;
			stats[i] += 1;
			stats[j] += 1;
			return stats;
		}

		if(race.equals("Halfling")) {
			stats[1] += 2;
			return stats;
		}

		if(race.equals("Half-Orc")) {
			stats[0] += 2;
			stats[2] += 1;
			return stats;
		}

		if(race.equals("Human")) {
			stats[0] += 1;
			stats[1] += 1;
			stats[2] += 1;
			stats[3] += 1;
			stats[4] += 1;
			stats[5] += 1;
			return stats;
		}

		if(race.equals("Tiefling")) {
			stats[5] += 2;
			stats[3] += 1;
			return stats;
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


		if(classType == (classArray[0])) { //Barbarian 

			stats[0] = s1;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s5;
			stats[4] = s6;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[1])) { //Bard

			stats[0] = s6;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s5;
			stats[4] = s4;
			stats[5] = s1;

			return stats;
		}

		if(classType == (classArray[2])) { //Cleric

			stats[0] = s6;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s5;
			stats[4] = s1;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[3])) { //Druid

			stats[0] = s6;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s5;
			stats[4] = s1;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[4])) { //Fighter

			stats[0] = s1;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s6;
			stats[4] = s5;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[5])) { //Monk

			stats[0] = s6;
			stats[1] = s1;
			stats[2] = s3;
			stats[3] = s5;
			stats[4] = s2;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[6])) { //Paladin

			stats[0] = s1;
			stats[1] = s4;
			stats[2] = s3;
			stats[3] = s6;
			stats[4] = s5;
			stats[5] = s2;

			return stats;
		}

		if(classType == (classArray[7])) { //Ranger

			stats[0] = s6;
			stats[1] = s1;
			stats[2] = s3;
			stats[3] = s5;
			stats[4] = s2;
			stats[5] = s4;

			return stats;
		}

		if(classType == (classArray[8])) { //Rogue

			stats[0] = s5;
			stats[1] = s1;
			stats[2] = s3;
			stats[3] = s4;
			stats[4] = s6;
			stats[5] = s2;

			return stats;
		}

		if(classType == (classArray[9])) { //Sorcerer

			stats[0] = s6;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s4;
			stats[4] = s5;
			stats[5] = s1;

			return stats;
		}

		if(classType == (classArray[10])) { //Wizard

			stats[0] = s6;
			stats[1] = s3;
			stats[2] = s2;
			stats[3] = s1;
			stats[4] = s4;
			stats[5] = s5;

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

	public String back(String background) { //selects background

		int i = (int)(Math.random()*16);
		return background = backgrounds[i];
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
