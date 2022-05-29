import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	int tries = 0;
	
	
	
	
	
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
			        
			        System.out.println(tries);
			        String s = Integer.toString(tries);
			        
					JOptionPane.showMessageDialog(gameFrame, "CONGRATS! WANT TO PLAY AGAIN?", "YOU WIN!", JOptionPane.INFORMATION_MESSAGE,icon);
					HighScores();
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
		List<String> userWordsList = Arrays.asList(userWord.split(""));
		

		for (int i = 0; i < 5; i++) {
			if (wordleWordsList.contains(userWordsList.get(i))) {
				if (wordleWordsList.get(i).equals(userWordsList.get(i))) {
					
					
				 getActivePanel().setText(userWordsList.get(i), i, Color.green);
					
				
					
					
					CorrectLetterCount++;
				} else {
					getActivePanel().setText(userWordsList.get(i), i, Color.yellow);
					
				}
			} else {
				getActivePanel().setText(userWordsList.get(i), i,Color.gray);
				
			}
		}
		tries++;
		
		
		
	}
	
	public void HighScores() {
	
	try {   // this is for monitoring runtime Exception within the block 
		File file = new  File("HighScores.txt");
		String textString = Integer.toString(tries);
    
    // if file doesnt exists, then create it
    if (!file.exists()) {   // checks whether the file is Exist or not
        file.createNewFile();   // here if file not exist new file created 
    }

    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); // creating fileWriter object with the file
    BufferedWriter bw = new BufferedWriter(fw); // creating bufferWriter which is used to write the content into the file
    bw.write(textString+ "\r\n");
    
    // write method is used to write the given content into the file
    bw.close(); // Closes the stream, flushing it first. Once the stream has been closed, further write() or flush() invocations will cause an IOException to be thrown. Closing a previously closed stream has no effect. 


	} catch (IOException e) { // if any exception occurs it will catch
    e.printStackTrace();
	}

	
    
	}  
   
}
