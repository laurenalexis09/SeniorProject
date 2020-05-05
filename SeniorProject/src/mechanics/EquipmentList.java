package mechanics;

import characters.RandomCharacter;
import listeners.MainCharacterListener;
import main.Simulator;

public class EquipmentList { //Arrays that store all of the different possible items in game
	String[] lArmor = {"Padded Armor","Leather Armor","Studded Leather"};
	String[] mArmor = {"Hide Chain Shirt", "Scale Mail", "Breastplate", "Half Plate"};
	String[] hArmor = {"Ring Mail", "Chain Mail", "Splint", "Plate"};

	String[]sMelee = {"Club", "Dagger", "Great Club", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear"};
	String[]mMelee = {"Battleaxe", "Flail", "Glaive", "Great Axe", "Great Sword", "Halberd", "Lance", "Long Sword", "Maul", "Morningstar", "Pike", "Rapier", "Scimitar", "Short Sword", "Trident", "War Pick", "Warhammer", "Whip"}; 

	String[] sRanged = {"Light Crossbow","Dart", "Shortbow", "Sling"};
	String[] mRanged = {"Blowgun", "Hand Crossbow", "Heavy Crossbow", "Longbow", "Net"};

	String[] shield = {"No Shield", "Shield"};

	String[] size = {"Small", "Medium"};

	private String armor;
	private String melee;
	private String ranged;
	private String shields;
	private String language1 = "Common";
	private String language2;
	private String sizes;
	private int weight;
	String race;
	String classType;
	int[] stats;
	String bg;

	public EquipmentList() { //Generates a set list of items
		race = MainCharacterListener.getRace();
		armor = armored(armor);
		melee = meleed(melee);
		this.setRanged(rangeds(ranged));
		shields = shielded(shields);
		language2 = slanguage(race, language2);
		sizes = sized(race, sizes);
		weight = weighted(race, weight);
	}

	public String armored(String armor) { //Decides the armor

		int j = (int)(Math.random()*2);

		if(j == 0) {
			int i = (int)(Math.random()*2);
			this.setArmor(lArmor[i]);
			return lArmor[i];			
		}

		if(j == 1) {
			int i = (int)(Math.random()*3);
			this.setArmor(mArmor[i]);
			return mArmor[i];			
		}

		if(j == 2) {
			int i = (int)(Math.random()*3);
			this.setArmor(hArmor[i]);
			return hArmor[i];			
		}

		return lArmor[0];

	}

	public String meleed(String melee) { //Decides the melee weapon

		int j = (int)(Math.random()*1);

		if(j == 0) {
			int i = (int)(Math.random()*9);
			this.setMelee(sMelee[i]);
			return sMelee[i];			
		}

		if(j == 1) {
			int i = (int)(Math.random()*17);
			this.setArmor(mMelee[i]);
			return mMelee[i];			
		}


		return mMelee[0];

	}

	public String rangeds(String ranged) { //Decides the ranged weapon

		int j = (int)(Math.random()*1);

		if(j == 0) {
			int i = (int)(Math.random()*3);
			this.setRanged(sRanged[i]);
			return sRanged[i];			
		}

		if(j == 1) {
			int i = (int)(Math.random()*17);
			this.setRanged(mRanged[i]);
			return mRanged[i];			
		}


		return mRanged[0];

	}

	public String shielded(String shields) { //chooses a shield
		int i = (int)(Math.random()*1);
		this.setShield(shield[i]);
		return shield[i];
	}
	
	public String slanguage(String race, String language2) { //Chooses the second language
		
		String[] languages = {"Dwarvish", "Elvish", "Giant", "Gnoll", "Gnomish", "Goblin", "Halfling", "Orc", "Abyssal", "Auran", "Celestial", "Deep Speech", "Draconic", "Infernal", "Primordial", "Sylvan", "Undercommon", "Common"};

		if(race.equals("Dragonborn")){
			language2 = "Draconic";
			return language2;
		}

		if(race.equals("Dwarf")) {
			language2 = "Dwarvish";
			return language2;
		}

		if(race.equals("Elf")) {
			language2 = "Elvish";
			return language2;
		}

		if(race.equals("Gnome")) {
			language2 = "Gnomish";
			return language2;
		}

		if(race.equals("Half-Elf")) {
			language2 = "Elvish";
			return language2;
		}

		if(race.equals("Halfling")) {
			language2 = "Halfling";
			return language2;
		}

		if(race.equals("Half-Orc")) {
			language2 = "Orc";
			return language2;
		}

		if(race.equals("Human")) {
			int i = (int)(Math.random()*17);
			language2 = languages[i];
			return language2;
		}

		if(race.equals("Tiefling")) {
			language2 = "Infernal";
			return language2;
		}
		return language2;


	}

	public String sized(String race, String size) { //Chooses their size

		if(race.equals("Dragonborn")){
			size = "Medium";
			return size;
		}

		if(race.equals("Dwarf")) {
			size = "Medium";
			return size;
		}

		if(race.equals("Elf")) {
			size = "Medium";
			return size;
		}

		if(race.equals("Gnome")) {
			size = "Small";
			return size;
		}

		if(race.equals("Half-Elf")) {
			size = "Medium";
			return size;
		}

		if(race.equals("Halfling")) {
			size = "Small";
			return size;
		}

		if(race.equals("Half-Orc")) {
			size = "Medium";
			return size;
		}

		if(race.equals("Human")) {
			size = "Medium";
			return size;
		}

		if(race.equals("Tiefling")) {
			size = "Medium";
			return size;
		}
		return size;

	}
	
	public int weighted(String race, int weight) { //Chooses their weight 

		if(race.equals("Dragonborn")){
			weight = 250;
			return weight;
		}

		if(race.equals("Dwarf")) {
			weight = 150;
			return weight;
		}

		if(race.equals("Elf")) {
			weight = 175;
			return weight;
		}

		if(race.equals("Gnome")) {
			weight = 40;
			return weight;
		}

		if(race.equals("Half-Elf")) {
			weight = 175;
			return weight;
		}

		if(race.equals("Halfling")) {
			weight = 40;
			return weight;
		}

		if(race.equals("Half-Orc")) {
			weight = 190;
			return weight;
		}

		if(race.equals("Human")) {
			weight = 175;
			return weight;
		}

		if(race.equals("Tiefling")) {
			weight = 175;
			return weight;
		}
		return weight;

	}
	
	
	public String getArmor() { //Getters and setters
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getMelee() {
		return melee;
	}

	public void setMelee(String melee) {
		this.melee = melee;
	}

	public String getRanged() {
		return ranged;
	}

	public void setRanged(String ranged) {
		this.ranged = ranged;
	}

	public String getShield() {
		return shields;
	}

	public void setShield(String shields) {
		this.shields = shields;
	}

	public String getLanguage1() {
		return language1;
	}

	public void setLanguage1(String language1) {
		this.language1 = language1;
	}
	
	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}
	
	public String getSize() {
		return sizes;
	}

	public void setSize(String sizes) {
		this.sizes = sizes;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
