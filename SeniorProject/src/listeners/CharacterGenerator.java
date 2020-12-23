package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import characters.RandomCharacter;
import main.Simulator;

public class CharacterGenerator implements ActionListener { //Class for the first random partner
	private String name;
	public String race;
	private String classType;
	private int stats[] = new int[6];
	private String background;
	
	RandomCharacter random = new RandomCharacter();
	public CharacterGenerator(RandomCharacter random) {
		this.random = random;
		race = random.getRace();
		classType = random.getClassType();
		stats = random.getStats();
		background = random.getBackground();
		name = Simulator.p1;
	}

	public void actionPerformed(ActionEvent arg0){ //Prints out the stats
		

		JOptionPane.showMessageDialog(null,
				"Name: "+name
				+"\nRace: "+race
				+"\nClass: "+classType
				+"\nBackground: "+background
				+"\n"
				+"\nStats: "
				+"\nStrength: " +stats[0]
						+"\nDexterity: "+stats[1]
								+"\nConstitution: "+stats[2]
										+"\nIntelligence: "+stats[3]
												+"\nWisdom: "+stats[4]
														+"\nCharisma: "+stats[5],"Party Member 1",JOptionPane.PLAIN_MESSAGE);


	}

}

