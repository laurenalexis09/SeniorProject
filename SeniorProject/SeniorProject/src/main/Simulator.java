package main;

import mechanics.Counter;
import mechanics.Dice;
import listeners.CharacterGenerator;
import listeners.CharacterGenerator2;
import listeners.DialogueListener;
import listeners.EquipmentListener;
import listeners.MainCharacterListener;
import characters.MainCharacter;
import characters.RandomCharacter;
import display.JPanelWithBackground;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;



public class Simulator extends JFrame{


	JPanel names = new JPanel(); //For customization

	JTextField partner1 = new JTextField(10);
	JTextField partner2 = new JTextField(10);
	JTextField yourName = new JTextField(10);	
	JTextField chrSht = new JTextField(20);

	public static String yn = null;
	public static String p1 = null;
	public static String p2 = null;
	public static String chr = null;

	private static int opt;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Screen dimensions


	private JPanel panel1 = new JPanel(); //For GUI
	private Color b;
	public static JPanel background = new JPanel();
	private JPanel panel = new JPanel();
	private JPanel border1 = new JPanel();
	private JPanel border2 = new JPanel();
	private JPanel border3 = new JPanel();
	private JPanel border4 = new JPanel();
	private JPanel buttons = new JPanel();
	public static JTextArea field = new JTextArea();

	JButton button1 = new JButton(); //Buttons
	JButton button2 = new JButton();
	public static JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();

	JLabel label1 = new JLabel(); //Labels for panels
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();

	static Dice dice; //Used for the dice roller

	Counter counter = new Counter(); //Used for story incrementing

	private	Border border = BorderFactory.createLineBorder(Color.BLACK, 2); //For adding black borders

	public Simulator() throws IOException {

		dice = new Dice();

		String race = null; //Stats for creating random party members
		String classType = null;
		int[] stats = null;
		String bg = null;

		RandomCharacter random = new RandomCharacter(race, classType, stats, bg);

		String race2 = null;
		String classType2 = null;
		int[] stats2 = null;
		String bg2 = null;

		RandomCharacter random2 = new RandomCharacter(race2, classType2, stats2, bg2);

		if(getOpt() == 1) { //The option pane for if the player decides to have a random character
			names.add(new JLabel("What's your name?: "));
			names.add(yourName);
			names.add(Box.createHorizontalStrut(15));
			names.add(new JLabel("Partner one's name?: "));
			names.add(partner1);
			names.add(Box.createHorizontalStrut(15));
			names.add(new JLabel("Partner two's name?: "));
			names.add(partner2);

			int result = JOptionPane.showConfirmDialog(null, names,
					"Greetings, adventurer! I need to know the names of you and your party members!", JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {

				yn = yourName.getText();
				p1 = partner1.getText();
				p2 = partner2.getText();


				if(yn.equals(null)||yn.equals("")){
					yn = "Player";
				}
				if(p1.equals(null)||p1.equals("")){
					p1 = "Partner 1";
				}
				if(p2.equals(null)||p2.equals("")){
					p2 = "Partner 2";
				}
			}
		}

		if(getOpt() == 0) { //If the player is using a character sheet
			names.add(Box.createHorizontalStrut(15));
			names.add(new JLabel("Partner one's name?: "));
			names.add(partner1);
			names.add(Box.createHorizontalStrut(15));
			names.add(new JLabel("Partner two's name?: "));
			names.add(partner2);
			names.add(Box.createHorizontalStrut(15));
			names.add(new JLabel("Path for character sheet: "));
			names.add(chrSht);


			int result = JOptionPane.showConfirmDialog(null, names,
					"Greetings, adventurer! I need to know the names of your party members, as well as the path to your character sheet!", JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION || result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {

				p1 = partner1.getText();
				p2 = partner2.getText();
				chr = chrSht.getText();


				if(p1.equals(null)||p1.equals("")){
					p1 = "Partner 1";
				}
				if(p2.equals(null)||p2.equals("")){
					p2 = "Partner 2";
				}
			}
		}

		int screenHeight = screenSize.height; //Height and width of screen
		int screenWidth = screenSize.width;

		button1.setPreferredSize(new Dimension(150,100)); //Setting button sizes
		button2.setPreferredSize(new Dimension(150,100));
		button3.setPreferredSize(new Dimension(150,100));
		button4.setPreferredSize(new Dimension(150,100));
		button5.setPreferredSize(new Dimension(150,100));
		button6.setPreferredSize(new Dimension(150,100));
		button7.setPreferredSize(new Dimension(150,100));
		getField().setPreferredSize(new Dimension(200,50));

		button1.setText("Dialogue option 1"); //Button texts
		button2.setText("Dialogue option 2");
		button3.setText("Begin");
		button4.setText("Equipment");
		button5.setText("Player");
		button6.setText("Party Member 1");
		button7.setText("Party Member 2");

		button3.addActionListener(new DialogueListener(counter, field)); //For the continue button, increments the story

		button4.addActionListener(new EquipmentListener()); //Equipment Button

		button5.addActionListener(new MainCharacterListener()); //Button for main character

		button6.addActionListener(new CharacterGenerator(random)); //Generating random party member

		button7.addActionListener(new CharacterGenerator2(random2)); //Random party member 2

		button5.doClick();

		buttons.add(button5); //adding buttons to screen
		buttons.add(button6);
		buttons.add(button7);
		buttons.add(button4);

		background.setLayout(new BorderLayout());//Sets the background layout


		border1.add(button1); //Dialogue Buttons
		border1.add(button2);
		border1.add(button3);

		panel.setLayout(new GridLayout(2,2)); //GUI
		panel.add(getField());
		panel.add(buttons);
		panel.add(border1);
		panel.add(dice);

		border2.setBackground(Color.GRAY); //Background colors
		border3.setBackground(Color.GRAY);
		border4.setBackground(Color.GRAY);

		background.setPreferredSize(new Dimension(500,500)); //Setting background dimensions
		border1.setPreferredSize(new Dimension(100,100));
		border2.setPreferredSize(new Dimension(40,40));
		border3.setPreferredSize(new Dimension(40,40));
		border4.setPreferredSize(new Dimension(40,40));

		background.setBorder(border); //Background border
		getField().setBorder(border);
		getField().setFont(label1.getFont().deriveFont(Font.PLAIN, 15f)); //Dialogue text field formatting

		setTitle("Simulator"); //General settings for the simulator
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent e) {
				e.getWindow().dispose();

			}
		});

		setLayout(new BorderLayout()); //setting up overall layout
		add(background, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		add(border2, BorderLayout.NORTH);
		add(border3, BorderLayout.EAST);
		add(border4, BorderLayout.WEST);

		getField().setText("Click \"begin\" to start your adventure..."); //Labels and fonts

		setSize(screenWidth,screenHeight); //Sets program to height of class
		setLocationRelativeTo(null); //Center of screen
		setVisible(true);
	}


	public static void main(String[] args) throws IOException {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		setOpt(JOptionPane.showConfirmDialog(null, "Welcome to the Dungeons and Dragons java simulator, created by Lauren Cugliotta!"
				+ "\nWould you like to use a custom character sheet? If so, select yes. "
				+ "\nSelecting no will generate a random character for you.", "Welcome", JOptionPane.YES_NO_OPTION)); //Main opening


		new Simulator();

	}

	public static int getOpt() { //Opt is used to decide whether the player wants a random character or a character sheet
		return opt;
	}


	public static void setOpt(int opt) {
		Simulator.opt = opt;
	}


	public JTextArea getField() {
		return field;
	}


	public void setField(JTextArea field) {
		this.field = field;
	}

}
