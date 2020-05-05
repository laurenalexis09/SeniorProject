package mechanics;

import javax.swing.JOptionPane;

import characters.MainCharacter;
import listeners.DiceListener;
import listeners.EquipmentListener;
import listeners.MainCharacterListener;
import main.Simulator;
import mechanics.Dice;

public class Battle1 {

	int val = Simulator.getOpt(); //Modifier for if the player is random or is using a character sheet

	
	
	public Battle1() {
		int choice = 0;
		int enemy1 = 25; //Enemy health
		int enemy2 = 25;
		int str = 0;
		int dex = 0;
		int strMod = 0;
		int dexMod = 0;
		int diceChoice = 0;
		int dmg = 0;

		String weapon = null;

		if(val == 1) { //Gets the weapon and the appropriate modifiers
			weapon = EquipmentListener.list.getMelee();	
			str = MainCharacterListener.str;
			dex = MainCharacterListener.dex;
		}

		if(val == 0) {
			MainCharacter main = new MainCharacter(); //Instance of the main character
			weapon = main.getMelee();	
			str = main.getStr();
			dex = main.getDex();
		}

		strMod = statModify(str, strMod); //Getting the strength and dex modifiers
		dexMod = statModify(dex, dexMod);

		int count = 0;

		while(true) { //Runs until both enemies are out of health

			String[] options = { "Enemy 1", "Enemy 2" };

			if(count == 0) {//For the first iteration

				if(enemy1 == 0) {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: Defeated!"
							+ "\nKobold 2: "+enemy2+" hit points"
							+ "\nOnly enemy 2 remains!", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);
				}

				else if(enemy2 == 0) {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: "+enemy1+" hit points"
							+ "\nKobold 2: Defeated!"
							+ "\nOnly enemy 1 remains!", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);
				}	

				else {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: "+enemy1+" hit points"
							+ "\nKobold 2: "+enemy2+" hit points"
							+ "\nDo you want to attack enemy 1, or enemy 2?", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);

				}

			}

			if(count > 0) { //So the message dialog doesn't talk about an attack on the first message

				if(enemy1 == 0) {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: Defeated!"
							+ "\nKobold 2: "+enemy2+" hit points"
							+ "\n"
							+ "\nYou attacked with your " +weapon+ " and cost the enemy kobold "+dmg+" hit points!"
							+ "\n" 
							+ "\nOnly enemy 2 remains!", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);
				}

				else if(enemy2 == 0) {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: "+enemy1+" hit points"
							+ "\nKobold 2: Defeated!"
							+ "\n"
							+ "\nYou attacked with your " +weapon+ " and cost the enemy kobold "+dmg+" hit points!"
							+ "\n"
							+ "\nOnly enemy 1 remains!", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);
				}	

				else {
					choice = JOptionPane.showOptionDialog(null, "Two kobolds are attacking!"
							+ "\nKobold 1: "+enemy1+" hit points"
							+ "\nKobold 2: "+enemy2+" hit points"
							+ "\n"
							+ "\nYou attacked with your " +weapon+ " and cost the enemy kobold "+dmg+" hit points!"
							+ "\n"
							+ "\nDo you want to attack enemy 1, or enemy 2?", "Battle",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]);

				}
			}

			if(choice == 0) { //Enemy 1

				dmg = diceRoll(weapon, diceChoice, strMod, dexMod);
				enemy1 -= dmg;
			}

			if(choice == 1) { //Enemy 2
				dmg = diceRoll(weapon, diceChoice, strMod, dexMod);
				enemy2 -= dmg;
			}

			if(enemy1 < 0) {
				enemy1 = 0;
			}

			if(enemy2 < 0) {
				enemy2 = 0;
			}

			if(enemy1 <=0 && enemy2 <=0) {
				JOptionPane.showMessageDialog(null, "The two kobolds were defeated!", "Victory!", JOptionPane.PLAIN_MESSAGE);
				break;
			}
			count++;
		}
	}

	int statModify(int stat, int mod) { //This method finds the appropriate stat modifier for whichever stat is read in
		if(stat == 1) {
			return mod = -5;
		}

		if(stat > 1 && stat <= 3) {
			return mod = -4;
		}

		if(stat >=4 && stat <= 5) {
			return mod = -2;
		}

		if(stat >=6 && stat <= 7) {
			return mod = -2;
		}

		if(stat >=8 && stat <= 9) {
			return mod = -1;
		}

		if(stat >=10 && stat <= 11) {
			return mod = 0;
		}

		if(stat >=12 && stat <= 13) {
			return mod = 1;
		}

		if(stat >=14 && stat <= 15) {
			return mod = 2;
		}

		if(stat >=16 && stat <= 17) {
			return mod = 3;
		}

		if(stat >=18 && stat <= 19) {
			return mod = 4;
		}

		if(stat == 20) {
			return mod = 5;
		}

		return mod;
	}

	int diceRoll(String weapon, int diceChoice, int strMod, int dexMod) { //This method calculates the weapon damage based on what the weapon is and a dice roll, plus the appropriate modifier for the weapon


		if(weapon.equals("Club")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d41 + strMod;
		}

		if(weapon.equals("Dagger")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d41 + dexMod;
		}

		if(weapon.equals("Great Club")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon.equals("Handaxe")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon.equals("Javelin")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon.equals("Light Hammer")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d41 + strMod;
		}

		if(weapon.equals("Mace")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon.equals("Quarterstaff")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon == "Sickle") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d41 + strMod;
		}

		if(weapon == "Spear") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon == "Battleaxe") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon == "Flail") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon == "Glaive") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d1011 + strMod;
		}

		if(weapon == "Great Axe") {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d121 + strMod;
		}

		if(weapon.equals("Great Sword")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61;
			Dice.rollButton.doClick();
			diceChoice += DiceListener.d61 + strMod;
		}

		if(weapon.equals("Halberd")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d1011 + strMod;
		}

		if(weapon.equals("Lance")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d121 + strMod;
		}

		if(weapon.equals("Long Sword")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon.equals("Maul")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61;
			Dice.rollButton.doClick();
			diceChoice += DiceListener.d61 + strMod;
		}

		if(weapon.equals("Morningstar")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon.equals("Pike")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d1011 + strMod;
		}

		if(weapon.equals("Rapier")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + dexMod;
		}

		if(weapon.equals("Scimitar")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + dexMod;
		}

		if(weapon.equals("Short Sword")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + dexMod;
		}

		if(weapon.equals("Trident")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d61 + strMod;
		}

		if(weapon.equals("War Pick")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d81 + strMod;
		}

		if(weapon.equals("Warhammer")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d1011 + strMod;
		}

		if(weapon.equals("Whip")) {
			Dice.rollButton.doClick();	
			diceChoice = DiceListener.d41 + dexMod;
		}

		if(diceChoice < 0) {
			diceChoice = 0;
		}

		return diceChoice;

	}
}
