package mechanics;

import characters.Character;
import listeners.MainCharacterListener;

public class EquipmentList { //Arrays that store all of the different possible items in game
	String[] lArmor = {"Padded Armor","Leather Armor","Studded Leather"};
	String[] mArmor = {"Hide Chain Shirt", "Scale Mail", "Breastplate", "Half Plate"};
	String[] hArmor = {"Ring Mail", "Chain Mail", "Splint", "Plate"};

	String[]sMelee = {"Club", "Dagger", "Great Club", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear"};
	String[]mMelee = {"Battleaxe", "Flail", "Glaive", "Great Axe", "Great Sword", "Halberd", "Lance", "Long Sword", "Maul", "Morningstar", "Pike", "Rapier", "Scimitar", "Short Sword", "Trident", "War Pick", "Warhammer", "Whip"}; 

	String[] sRanged = {"Light Crossbow","Dart", "Shortbow", "Sling"};
	String[] mRanged = {"Blowgun", "Hand Crossbow", "Heavy Crossbow", "Longbow", "Net"};

	String[] shield = {"No Shield", "Shield"};

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

	public EquipmentList() throws Exception { //Generates a set list of items
		race = MainCharacterListener.getRace();
		armor = armored();
		melee = meleed();
		this.setRanged(rangeds());
		shields = shielded();
		language2 = slanguage(race);
		sizes = sized(race);
		weight = weighted(race);
	}

	public String armored() { //Decides the armor

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

	public String meleed() { //Decides the melee weapon

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

	public String rangeds() { //Decides the ranged weapon

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

	public String shielded() { //chooses a shield
		int i = (int)(Math.random()*1);
		this.setShield(shield[i]);
		return shield[i];
	}
	
	public String slanguage(String race) { //Chooses the second language
		String language2 = null;
		String[] languages = {"Dwarvish", "Elvish", "Giant", "Gnoll", "Gnomish", "Goblin", "Halfling", "Orc", "Abyssal", "Auran", "Celestial", "Deep Speech", "Draconic", "Infernal", "Primordial", "Sylvan", "Undercommon", "Common"};

		if(race.equals(Character.RACE_DRAGONBORN)){
			language2 = "Draconic";

		}

		if(race.equals(Character.RACE_DWARF)) {
			language2 = "Dwarvish";
		}

		if(race.equals(Character.RACE_ELF)) {
			language2 = "Elvish";
		}

		if(race.equals(Character.RACE_GNOME)) {
			language2 = "Gnomish";
		}

		if(race.equals(Character.RACE_HALF_ELF)) {
			language2 = "Elvish";
		}

		if(race.equals(Character.RACE_HALFLING)) {
			language2 = "Halfling";
		}

		if(race.equals(Character.RACE_HALF_ORC)) {
			language2 = "Orc";
		}

		if(race.equals(Character.RACE_HUMAN)) {
			int i = (int)(Math.random()*17);
			language2 = languages[i];
		}

		if(race.equals(Character.RACE_TIEFLING)) {
			language2 = "Infernal";
		}
		return language2;


	}

	public String sized(String race) throws Exception { //Chooses their size
		String size = null;

		switch(race) {
			case Character.RACE_DRAGONBORN:
			case Character.RACE_DWARF:
			case Character.RACE_ELF:
			case Character.RACE_HALF_ELF:
			case Character.RACE_HALF_ORC:
			case Character.RACE_HUMAN:
			case Character.RACE_TIEFLING:
				size = "Medium";
				break;
			case Character.RACE_GNOME:
			case Character.RACE_HALFLING:
				size = "Small";
		}
		if ( size == null ) {
			throw new Exception("Character race does not have an associated size");
		}
		return size;

	}
	
	public int weighted(String race) throws Exception { //Chooses their weight
		Integer weight = null;
		if(race.equals(Character.RACE_DRAGONBORN)){
			weight = 250;
		}

		if(race.equals(Character.RACE_DWARF)) {
			weight = 150;
		}

		if(race.equals(Character.RACE_ELF)) {
			weight = 175;
		}

		if(race.equals(Character.RACE_GNOME)) {
			weight = 40;
		}

		if(race.equals(Character.RACE_HALF_ELF)) {
			weight = 175;
		}

		if(race.equals(Character.RACE_HALFLING)) {
			weight = 40;
		}

		if(race.equals(Character.RACE_HALF_ORC)) {
			weight = 190;
		}

		if(race.equals(Character.RACE_HUMAN)) {
			weight = 175;
		}

		if(race.equals(Character.RACE_TIEFLING)) {
			weight = 175;
		}
		if ( weight == null ) {
			throw new Exception("Character race does not have an associated weight");
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
