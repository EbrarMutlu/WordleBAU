import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

import javax.crypto.BadPaddingException;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class WordleGame implements ActionListener{ //implementing the actionlistener interface
	
	
	
	class Harfler extends JPanel{ //creating the 5 boxes view
		
		JLabel harfler[]= new JLabel[5];
	
		
		public Harfler() //constructor 
		{
			this.setLayout(new GridLayout(1,5));
			
			Border blackBorder = BorderFactory.createLineBorder(Color.gray,1);
			
			for(int i = 0; i<5; i++) {
				harfler[i]= new JLabel();
				harfler[i].setOpaque(true);
				harfler[i].setBorder(blackBorder);
				this.add(harfler[i]); //adding 5 little boxes to the same row
				
			}
		
			
		}
		
		public void clearWordPanel() {
			for (int i = 0; i < 5; i++) {
				harfler[i].setText("");
			}
		}
		
		public void setText(String charValue, int position, Color color) {
			this.harfler[position].setText(charValue);
			this.harfler[position].setBackground(color);
			//setting the opaque=true helps us see the color
		}
	}
	
	class UserInput extends JPanel{ //getting the user input 
		
		public JTextField userInput;
		public JButton enterButton;

		public UserInput() {
			this.setLayout(new GridLayout(1, 2));
			userInput = new JTextField();
			userInput.setBackground(Color.decode("#717bff"));
			userInput.setForeground(Color.BLACK.darker());
			userInput.setFont(new Font("Serif", Font.BOLD, 12));
			this.add(userInput);
			enterButton = new JButton("Enter");
			enterButton.setFont(new Font("Serif", Font.BOLD, 12));
			enterButton.setBackground(Color.decode("#ffc425"));
			enterButton.setForeground(Color.BLACK.darker());
			
			this.add(enterButton);
		}

		public JTextField getUserInput() {
			return userInput;
		}

		public JButton getEnterButton() {
			return enterButton;
		}
		
	}
	
	class showTime extends JPanel{
		
		
		public showTime() {
		this.setLayout(new GridLayout(1, 1));
		ZonedDateTime now = ZonedDateTime.now();
		ZoneId z = ZoneId.of( "Europe/Istanbul" );
		ZonedDateTime zdt = ZonedDateTime.now( z );
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
		String formattedString = now.format(formatter);
		
		JLabel heading  = new JLabel(formattedString);
		heading.setFont(new Font("Serif", Font.BOLD, 21));
		heading.setForeground(Color.pink.darker());
		
		this.add(heading);
		}
		
		
	}
	
    
	     	
	
	public JFrame gameFrame;
	public Harfler[] wordPanelArray = new Harfler[6]; // creating 6 wordPanels because user has 6 tries
	public UserInput userPanel;
	public String wordleString;
	public showTime time;
	public int count = 0;
	public int CorrectLetterCount = 0;
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String userWord = this.userPanel.getUserInput().getText();

		if (userWord.length() == 5) {
			 playWordle(userWord.trim().toUpperCase());
			 if(CorrectLetterCount>4) {
				 clearAllPanels();
				    
				    Icon icon = new ImageIcon("fireworks.gif");
			       
			        JLabel label = new JLabel(icon);
			       
			        ImageIcon icon2 = new ImageIcon("congrats.png");
			        
					JOptionPane.showMessageDialog(gameFrame, "Congratulations! Want to play again?", "You have won!", JOptionPane.INFORMATION_MESSAGE,icon);
					gameFrame.dispose();
					//f.dispose();
					return;
			 }
			 count++;
		}
			 if(userWord.length() > 5 || userWord.length() < 5 ) {
				 JOptionPane.showMessageDialog(null, "Word should  be 5 letter word, try again","!", JOptionPane.INFORMATION_MESSAGE);
					return;
					}
			 
			 if (count == 6 && CorrectLetterCount<=4) {
					JOptionPane.showMessageDialog(null, "You Lost.Better luck next time.", "Oops",
							JOptionPane.INFORMATION_MESSAGE);
					gameFrame.dispose();
					return;
				 
			}
		
		CorrectLetterCount=0;	
		
	}
	
	private void clearAllPanels() {
		for (int i = 0; i <= count; i++) {
			wordPanelArray[i].clearWordPanel();
		}
	}
	
	
	public Harfler getActivePanel() {
		return this.wordPanelArray[count];
	}

	
	public String getWordleString() {
		Path path = Paths.get("Words.txt");

		
		List<String> wordList = new ArrayList<>();
		try {
			wordList = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random random = new Random();
		int position = random.nextInt(wordList.size());
		return wordList.get(position).trim().toUpperCase();
	}
    

	private void playWordle(String userWord) {
		List<String> wordleWordsList = Arrays.asList(wordleString.split(""));
		String[] userWordsArray = userWord.split("");
		

		for (int i = 0; i < 5; i++) {
			if (wordleWordsList.contains(userWordsArray[i])) {
				if (wordleWordsList.get(i).equals(userWordsArray[i])) {
					
					
					getActivePanel().setText(userWordsArray[i], i, Color.GREEN);
					
					CorrectLetterCount++;
				} else {
					getActivePanel().setText(userWordsArray[i], i, Color.YELLOW);
					
				}
			} else {
				getActivePanel().setText(userWordsArray[i], i, Color.GRAY);
				
			}
		}
		
	}


    
    
    
   
}
