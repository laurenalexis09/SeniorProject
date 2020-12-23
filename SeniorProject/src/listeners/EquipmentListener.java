package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import characters.MainCharacter;
import characters.RandomCharacter;
import main.Simulator;
import mechanics.EquipmentList;

public class EquipmentListener implements ActionListener{

	int val = Simulator.getOpt();
	String race;
	String classType;
	int[] stats;
	String bg;
	
public static EquipmentList list;

	static {
		try {
			list = new EquipmentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {//Pulls from character sheet and displays it
		
		MainCharacterListener gen = new MainCharacterListener();
		if(val == 0) {
		
		MainCharacter main = new MainCharacter();
		
		JOptionPane.showMessageDialog(null,
				"Player name: "+main.getCharName()
				+"\nLevel "+main.getLevel()
				+"\nProficiency Bonus: "+main.getProf()
				+"\nLanguage 1: "+main.getLang1()
				+"\nLanguage 2: "+main.getLang2()
				+"\nArmor: "+main.getArmor()
				+"\nMelee Weapon: "+main.getMelee()
				+"\nRanged Weapon "+main.getRanged()
				+"\nShield: "+main.getShield()
				+"\nSize: "+main.getSize()
				+"\nWeight: "+main.getWeight()+" Pounds"
				,"Player's equipment/Other stats",JOptionPane.PLAIN_MESSAGE);
		}
		
		if(val == 1) { //Equipment list for a random character
			JOptionPane.showMessageDialog(null,
					"Player name: "+Simulator.yn
					+"\nLevel: 5 "
					+"\nProficiency Bonus: 3"
					+"\nLanguage 1: "+list.getLanguage1()
					+"\nLanguage 2: "+list.getLanguage2()
					+"\nArmor: "+list.getArmor()
					+"\nMelee Weapon: "+list.getMelee()
					+"\nRanged Weapon: "+list.getRanged()
					+"\nShield: "+list.getShield()
					+"\nSize: "+list.getSize()
					+"\nWeight: "+list.getWeight()+" Pounds"
					,"Player's equipment/Other stats",JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
