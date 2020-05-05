# SeniorProject
This is my senior project from Elizabethtown College

My program is a simulation of the game Dungeons and Dragons. 

I will go over what each class does:

In the button package -
  
	DiceButton: A custom JButton used for the dice roller.
  
In the characters package -
  
	MainCharacter: The class where character information is stored from the excel sheet.
  
	RandomCharacter: The class that stores random character information that several classes pull from to create random characters.
  
In the display package -
  
	JPanelWithBackground: JPanels don't naturally allow for photos, so this class allows for pictures.  

In the excel package - 
	
	ExcelImport: This class imports data from the Excel character sheet.
  
	ExcelImportTest: This class is just a test of the Excel import class.
  
In the listeners package -
	
	CharacterGenerator: This class is where the data is generated and stored for the first player.
  
	CharacterGenerator2: This class is where the data is generated and stored for the second player.
  
	DialogueListener: This class is what runs the story - it initializes the story and shows the respective images and text for each iteration.
  
	DiceListener: When the dice button is pressed, this class rolls all of the dice.
  
	EquipmentListener: This class is activated by a button and it generates the equipment for the main player. Also contains extras such as weight, size, and language.
  
	MainCharacterListener: This class displays the character information for either the character sheet or the random main character, depending on which the player chooses. 
  
In the main package -
  
	Simulator: The main method, it initializes all of the GUI information about the project, sets the look and feel, and runs it. 
  
In the mechanics package -
  
	Battle1: This is all of the code behind the example battle I have provided in the project to show how one would flow in a major story. 
  
	Counter: The DialogueListener class uses this class as an iteration counter to progress the story.
  
	Dice: Sets the GUI for the dice roller.
  
	EquipmentList: This class contains all the information needed for randomly generating equipment.
  
This project uses a specific excel file as a character sheet.
This project also references several external libraries for reading in the excel sheet. 
