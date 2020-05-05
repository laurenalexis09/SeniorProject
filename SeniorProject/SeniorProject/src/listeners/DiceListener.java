package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import mechanics.Dice;

public class DiceListener implements ActionListener {

	Dice dice;
	
	private JTextField d4; //Fields for the gui
	private JTextField d6;
	private JTextField d8;
	private JTextField d101;
	private JTextField d102;
	private JTextField d12;
	private JTextField d20;
	
	public static int d41 = 0; //Static for use in battle mode
	public static int d61 = 0;
	public static int d81 = 0;
	public static int d1011 = 0;
	public static int d1021 = 0;
	public static int d121 = 0;
	public static int d201 = 0;
	
	
	//Establishing dice for the specific instance
	public DiceListener(Dice dice, JTextField d4, JTextField d6, JTextField d8, JTextField d101, JTextField d102, JTextField d12, JTextField d20) {
		this.dice = dice;
		this.d4 = d4;
		this.d6 = d6;
		this.d8 = d8;
		this.d101 = d101;
		this.d102 = d102;
		this.d12 = d12;
		this.d20 = d20;
	}
	
	
	public void actionPerformed(ActionEvent e) { //Rolls the dice
		d41 = (int)((Math.random()*4)+1);
		d4.setText(""+d41);
		d61 = (int)((Math.random()*6)+1);
		d6.setText(""+d61);
		d81 = (int)((Math.random()*8)+1);
		d8.setText(""+d81);
		d1011 = (int)((Math.random()*10));
		d101.setText(""+d1011);
		d1021 = 10*(int)((Math.random()*10));
		d102.setText(""+d1021);
		d121 = (int)((Math.random()*12)+1);
		d12.setText(""+d121);
		d201 = (int)((Math.random()*20)+1);
		d20.setText(""+d201);
		
	}

}
