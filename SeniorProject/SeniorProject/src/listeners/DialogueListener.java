package listeners;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import characters.MainCharacter;
import display.JPanelWithBackground;
import main.Simulator;
import mechanics.Battle1;
import mechanics.Counter;
import mechanics.EquipmentList;

public class DialogueListener implements ActionListener{ //Class that runs the story, this is a mini sample story to show off how the program works 
	int val = Simulator.getOpt();
	int count = 0;
	JTextArea field;





	Counter counter = new Counter(); //For incrementing

	public DialogueListener(Counter counter, JTextArea field) {	




		this.counter = counter;
		this.field = field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		URL imgURL = getClass().getResource("/Backgrounds/dnd.jpg");
		URL imgURL2 = getClass().getResource("/Backgrounds/inside.v2.jpg");
		URL imgURL3 = getClass().getResource("/Backgrounds/townfire.v2.cropped.jpg");	
		URL imgURL4 = getClass().getResource("/Backgrounds/dragon.v2.jpg");	
		URL imgURL5 = getClass().getResource("/Backgrounds/koboldscrop.jpg");	
		URL imgURL6 = getClass().getResource("/Backgrounds/forest.jpg");	




		JPanelWithBackground pan = null; //pan, throughout this class, acts as the background panel
		try {

			pan = new JPanelWithBackground(imgURL);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		Simulator.background.add(pan, BorderLayout.CENTER);


		counter.increment();

		if(counter.getCount() == 1) {
			if(val == 1) {
				Simulator.field.setText("Welcome to the simulator, "+Simulator.yn+"!, are you ready? Press continue!");
			}
			if(val == 0) {
				MainCharacter main = new MainCharacter();
				Simulator.field.setText("Welcome to the simulator, "+main.getCharName()+"!, are you ready? Press continue!");
			}
		}
		Simulator.button3.setText("Continue");

		if(counter.getCount() == 2) {
			Simulator.field.setText("You wake up one morning to the feeling of the ground shaking below you."
					+ "\nYou think to yourself, \"What's going on out there?\""
					+ "\nYou wake up your two friends who spent the night "+Simulator.p1+" and "+Simulator.p2+ " and look out the window.");

			Simulator.background.remove(pan);

			try {

				pan = new JPanelWithBackground(imgURL2);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Simulator.background.add(pan, BorderLayout.CENTER);
		}

		if(counter.getCount() == 3) {
			Simulator.field.setText("You notice that the buildings around yours have caught on fire!"
					+ "\n\"Oh dear, how could this have happened?\""
					+ "\n With that you hear a roar that shakes the world around you.");

			Simulator.background.remove(pan);
			try {
				pan = new JPanelWithBackground(imgURL3);				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);
		}

		if(counter.getCount() == 4) {
			Simulator.field.setText("That's when you notice... it's a dragon!");

			Simulator.background.remove(pan);
			try {
				pan = new JPanelWithBackground(imgURL4);					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);
		}

		if(counter.getCount() == 5) {
			if(val == 1) {
				Simulator.field.setText("You run in the basement and grab your "+EquipmentListener.list.getMelee()+
						".\nYou realize that you have a mission to save the town!");
			}

			if(val == 0) {
				MainCharacter main = new MainCharacter();
				Simulator.field.setText("You run in the basement and grab your "+main.getMelee()+
						".\nYou realize that you have a mission to save the town!");
			}
			Simulator.background.remove(pan);
			try {
				pan = new JPanelWithBackground(imgURL4);					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);
		}

		if(counter.getCount() == 6) {
			Simulator.field.setText("You and your friends run out into the town."
					+ "\nBut suddenly, you're stopped by some monsters!");

			Simulator.background.remove(pan);
			try {
				pan = new JPanelWithBackground(imgURL5);				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);
		}

		if(counter.getCount() == 7) {
			Simulator.background.remove(pan);
			new Battle1(); //Battle initiation 

			try {
				pan = new JPanelWithBackground(imgURL3);				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);

			Simulator.field.setText("\"Wow guys, that was scary!"
					+ "\nI guess that's what it's going to take to save the town, though.\""
					+ "\nAnd with that, the dragon flies off into the mountains.");

		}

		if(counter.getCount() == 8) {
			Simulator.background.remove(pan);

			try {
				pan = new JPanelWithBackground(imgURL6);				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Simulator.background.add(pan, BorderLayout.CENTER);

			Simulator.field.setText("\"I know what we need to do, guys."
					+ "\nIt's time to chase and defeat that dragon!\""
					+ "\nAnd from there, they set off into the forest on their journey to find the dragon.");

		}
	}
}
