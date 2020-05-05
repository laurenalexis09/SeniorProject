package mechanics;

import buttons.DiceButton;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.DiceListener;

public class Dice extends JPanel {

	private JPanel block = new JPanel(); //Overall panel
	private JPanel diceNames = new JPanel(); //Panel for names
	private JPanel diceValues = new JPanel();//Panel for values
	
	static DiceButton rollButton = new DiceButton();
	
	private JTextField d4 = new JTextField(); //Types of dice
	private JTextField d6 = new JTextField();
	private JTextField d8 = new JTextField();
	private JTextField d101 = new JTextField();
	private JTextField d102 = new JTextField();
	private JTextField d12 = new JTextField();
	private JTextField d20 = new JTextField();
	
	private	JLabel d4Label = new JLabel("D4", JLabel.CENTER); //Labeling dice
	private	JLabel d6Label = new JLabel("D6", JLabel.CENTER);
	private	JLabel d8Label = new JLabel("D8", JLabel.CENTER);
	private	JLabel d101Label = new JLabel("D10(x1)", JLabel.CENTER);
	private	JLabel d102Label = new JLabel("D10(x10)", JLabel.CENTER);
	private	JLabel d12Label = new JLabel("D12", JLabel.CENTER);
	private	JLabel d20Label = new JLabel("D20", JLabel.CENTER);
	
	public Dice() {
	
		add(block);
		
		rollButton.setText("Roll Dice");
		
		d4.setText("0"); //Initial zeros
		d6.setText("0");
		d8.setText("0");
		d101.setText("0");
		d102.setText("0");
		d12.setText("0");
		d20.setText("0");
		
		d4.setHorizontalAlignment(JTextField.CENTER); //Centers the numbers
		d6.setHorizontalAlignment(JTextField.CENTER);
		d8.setHorizontalAlignment(JTextField.CENTER);
		d101.setHorizontalAlignment(JTextField.CENTER);
		d102.setHorizontalAlignment(JTextField.CENTER);
		d12.setHorizontalAlignment(JTextField.CENTER);
		d20.setHorizontalAlignment(JTextField.CENTER);
		
		block.setLayout(new GridLayout(3,1)); //Sets overall layout
		diceNames.setLayout(new GridLayout(1,7));
		diceValues.setLayout(new GridLayout(1,7));

		diceNames.add(d4Label); //Adding labels
		diceNames.add(d6Label);
		diceNames.add(d8Label);
		diceNames.add(d101Label);
		diceNames.add(d102Label);
		diceNames.add(d12Label);
		diceNames.add(d20Label);
		
		diceValues.add(d4); //Adding dice values
		diceValues.add(d6);
		diceValues.add(d8);
		diceValues.add(d101);
		diceValues.add(d102);
		diceValues.add(d12);
		diceValues.add(d20);
		
		block.add(diceNames);
		block.add(diceValues);
		block.add(rollButton);
	
		rollButton.addActionListener(new DiceListener(this, d4, d6, d8, d101, d102, d12, d20)); //Listener for rolls
		setSize(50,100);
	}
	
}
