import java.awt.GridLayout;

import javax.swing.JFrame;

public class GameFrame extends WordleGame {

	
	
public GameFrame() { // constructor, initializing
	
	gameFrame = new JFrame("Wordle Game BAU Ver");
	
	gameFrame.setResizable(false);
	gameFrame.pack();
	
	time = new showTime();
	
	gameFrame.add(time);
	
	
	for (int i = 0; i < 6; i++) {  //initializng the wordpanel array
		wordPanelArray[i] = new WordPanel();
		gameFrame.add(wordPanelArray[i]);
	}
	
	
	userPanel = new UserPanel(); //initializing the userpanel
	userPanel.getEnterButton().addActionListener(this);
	
	gameFrame.add(userPanel);
	gameFrame.setSize(300, 300);
	gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	gameFrame.setLayout(new GridLayout(8, 1)); // 6 for tries, 1 for userinput
	gameFrame.setVisible(true);
	gameFrame.setLocationRelativeTo(null); //puts it in the center of our system
	
	
	gameFrame.revalidate();
	
	wordleString = getWordleString();
	System.out.println("Word: " + wordleString);
	
	
	
	

	
	
}
}
