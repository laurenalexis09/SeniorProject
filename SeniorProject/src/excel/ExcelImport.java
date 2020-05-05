package excel;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import main.Simulator;

public class ExcelImport {
	
		int row = 0;
		int column = 0;

		private String charName = ReadStringCell(3,1);
		private String race = ReadStringCell(4,1);
		private String classes = ReadStringCell(5,1);
		private String alignment = ReadStringCell(6,1);
		private String gender = ReadStringCell(7,1);
		private String hairColor = ReadStringCell(8,1);
		private String eyeColor = ReadStringCell(9,1);
		private String lang1 = ReadStringCell(10,1);
		private String lang2 = ReadStringCell(11,1);
		private String armor = ReadStringCell(12,1);
		private String melee = ReadStringCell(13,1);
		private String ranged = ReadStringCell(14,1);
		private String shield = ReadStringCell(15,1);
		private String background = ReadStringCell(16,1);
		private int level = ReadNumericCell(17,1);
		private int prof = ReadNumericCell(18,1);
		private String size = ReadStringCell(19,1);
		private int weight = ReadNumericCell(20,1);
		private int str = ReadNumericCell(3,5);
		private int dex = ReadNumericCell(4,5);
		private int con = ReadNumericCell(5,5);
		private int intel = ReadNumericCell(6,5);
		private int wis = ReadNumericCell(7,5);
		private int cha = ReadNumericCell(8,5);

	public String ReadStringCell(int row, int column) {//Method for reading cells with words
		Cell shtCell = null;
		Row shtRow = null;
		XSSFWorkbook wb = null;

		String value = null;

		try{  
			File chrSht = new File(""+Simulator.chr);   //Locates file and imports it  
			FileInputStream stream = new FileInputStream(chrSht);   //obtaining bytes from the file   

			wb = new XSSFWorkbook(stream); //reference to the workbook   
			XSSFSheet sheet = wb.getSheetAt(0);     //Reference to the first sheet

			shtRow= sheet.getRow(row); //returns row  
			shtCell= shtRow.getCell(column); //returns cell based on the row and column  
			value = (String)shtCell.getStringCellValue();	
		}

		catch(Exception e){  
			JOptionPane.showMessageDialog(null, "That's an invalid path. The program will now close. Please reopen and try again.");
			System.exit(0);
		}

		return value;

	}
	
	public int ReadNumericCell(int row, int column) { //method for reading cells that have numbers
		Cell shtCell = null;
		Row shtRow = null;
		XSSFWorkbook wb = null;

		int value = 0;

		try{  
			File chrSht = new File("C:\\Users\\laure\\OneDrive\\Desktop\\DND\\Excel Character Sheet.xlsx");   //Locates file and imports it  
			FileInputStream stream = new FileInputStream(chrSht);   //obtaining bytes from the file   

			wb = new XSSFWorkbook(stream); //reference to the workbook   
			XSSFSheet sheet = wb.getSheetAt(0);//Reference to the first sheet

			shtRow= sheet.getRow(row); //returns row  
			shtCell= shtRow.getCell(column); //returns cell based on the row and column  
			value = (int)shtCell.getNumericCellValue();	
		}

		catch(Exception e){  
			e.printStackTrace();  
		}

		return value;

	}

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
