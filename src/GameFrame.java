import java.awt.GridLayout;

import javax.swing.JFrame;



public class GameFrame extends WordleGame {
	

	
	
	
public GameFrame() { // constructor, initializing
	
	gameFrame = new JFrame("Wordle Game BAU Ver");
	
	//gameFrame.setResizable(false);
	gameFrame.pack();
	
	time = new showTime();
	
	gameFrame.add(time);
	
	
	for (int i = 0; i < 5; i++) {  //initializng the wordpanel array
		wordPanelArray[i] = new Harfler();
		gameFrame.add(wordPanelArray[i]);
	}
	board = new keyboard();
	gameFrame.add(board);
	userPanel = new UserInput(); //initializing the userpanel
	userPanel.getEnterButton().addActionListener(this);
	

	
	gameFrame.add(userPanel);
	
	
	gameFrame.setSize(670, 670);
	gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	gameFrame.setLayout(new GridLayout(8, 1)); // 6 for tries, 1 for userinput
	gameFrame.setVisible(true);
	gameFrame.setLocationRelativeTo(null); //puts it in the center of our system
	
	
	
	gameFrame.revalidate();
	
	wordleString = getWordleString();
	System.out.println("Word: " + wordleString);
	
	
	
	

	
	
}
}
