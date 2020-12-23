package characters;


import excel.ExcelImport;
public class MainCharacter extends Character{//Creates a main character from an excel import instance

	ExcelImport imp = new ExcelImport();
	
	String charName = imp.getCharName();
	private String race = imp.getRace();
	String classes = imp.getClasses();
	String alignment = imp.getAlignment();
	String gender = imp.getGender();
	String hairColor = imp.getHairColor();
	String eyeColor = imp.getEyeColor();
	String lang1 = imp.getLang1();
	String lang2 = imp.getLang2();
	String armor = imp.getArmor();
	String melee = imp.getMelee();
	String ranged = imp.getRanged();
	String shield = imp.getShield();
	String background = imp.getBackground();
	int level = imp.getLevel();
	int prof = imp.getProf();
	String size = imp.getSize();
	int weight = imp.getWeight();
	int str = imp.getStr();
	int dex = imp.getDex();
	int con = imp.getCon();
	int intel = imp.getIntel();
	int wis = imp.getWis();
	int cha = imp.getCha();

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getLang1() {
		return lang1;
	}

	public void setLang1(String lang1) {
		this.lang1 = lang1;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getShield() {
		return shield;
	}

	public void setShield(String shield) {
		this.shield = shield;
	}

	public String getRanged() {
		return ranged;
	}

	public void setRanged(String ranged) {
		this.ranged = ranged;
	}

	public String getMelee() {
		return melee;
	}

	public void setMelee(String melee) {
		this.melee = melee;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getLang2() {
		return lang2;
	}

	public void setLang2(String lang2) {
		this.lang2 = lang2;
	}
	
}
