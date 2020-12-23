package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import characters.MainCharacter;
import main.Simulator;
import characters.RandomCharacter;

public class MainCharacterListener implements ActionListener{

	int val = Simulator.getOpt();
	
	
	public static String race2 = "Dragonborn"; //Default values
	static String c = null;
	static int[] num = new int[6];
	static String b = null;
	
	static RandomCharacter gen = new RandomCharacter();
	
	public static String race = gen.getRace(); //Static so it can be used throughout the program
	public static int str = gen.getStats()[0];
	public static int dex = gen.getStats()[1];
	
	public MainCharacterListener() {
		race = gen.getRace();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(val == 0) {//If it's a character sheet

			MainCharacter main = new MainCharacter();
			
		JOptionPane.showMessageDialog(null,
				"Player name: "+main.getCharName()
				+"\nRace: "+main.getRace()
				+"\nClass: "+main.getClasses()
				+"\nBackground: "+main.getBackground()
				+"\n"
				+"\nStats: "
				+"\nStrength: "+main.getStr()
				+"\nDexterity: "+main.getDex()
				+"\nConstitution: "+main.getCon()
				+"\nIntelligence: "+main.getIntel()
				+"\nWisdom: "+main.getWis()
				+"\nCharisma: "+main.getCha(),"This is you!",JOptionPane.PLAIN_MESSAGE);

		}
		
		if(val == 1) { //If it's a random character
			
		JOptionPane.showMessageDialog(null,
				"Player name: "+Simulator.yn
				+"\nRace: "+gen.getRace()
				+"\nClass: "+gen.getClassType()
				+"\nBackground: "+gen.getBackground()
				+"\n"
				+"\nStats: "
				+"\nStrength: "+gen.getStats()[0]
				+"\nDexterity: "+gen.getStats()[1]
				+"\nConstitution: "+gen.getStats()[2]
				+"\nIntelligence: "+gen.getStats()[3]
				+"\nWisdom: "+gen.getStats()[4]
				+"\nCharisma: "+gen.getStats()[5],"This is you!",JOptionPane.PLAIN_MESSAGE);

		}
	}

	public static String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}


}
