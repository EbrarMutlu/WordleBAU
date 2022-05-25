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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class WordleGame implements ActionListener{ //implementing the actionlistener interface
	
	
	
	class WordPanel extends JPanel{ //creating the 5 boxes view
		
		JLabel Wordcolumns[]= new JLabel[5];
	
		
		public WordPanel() //constructor 
		{
			this.setLayout(new GridLayout(1,5));
			
			Border blackBorder = BorderFactory.createLineBorder(Color.gray,1);
			
			for(int i = 0; i<5; i++) {
				Wordcolumns[i]= new JLabel();
				Wordcolumns[i].setOpaque(true);
				Wordcolumns[i].setBorder(blackBorder);
				this.add(Wordcolumns[i]); //adding 5 little boxes to the same row
				
			}
		
			
		}
		
		
		public void setPanelText(String charValue, int position, Color color) {
			this.Wordcolumns[position].setText(charValue);
			this.Wordcolumns[position].setBackground(color);
			//setting the opaque=true helps us see the color
		}
	}
	
	class UserPanel extends JPanel{ //getting the user input 
		
		public JTextField userInput;
		public JButton enterButton;

		public UserPanel() {
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
	public WordPanel[] wordPanelArray = new WordPanel[6]; // creating 6 wordPanels because user has 6 tries
	public UserPanel userPanel;
	public String wordleString;
	public showTime time;
	public int count = 0;
	
	
	
	
	
	
	public WordleGame() { // constructor, initializing
		
		gameFrame = new JFrame("Wordle Game BAU Ver");
		gameFrame.setSize(300, 300);
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.setLayout(new GridLayout(8, 1)); // 6 for tries, 1 for userinput
		gameFrame.setVisible(true);
		gameFrame.setLocationRelativeTo(null); //puts it in the center of our system
		
		
		time = new showTime();
		
		gameFrame.add(time);
		
		
		for (int i = 0; i < 6; i++) {  //initializng the wordpanel array
			wordPanelArray[i] = new WordPanel();
			gameFrame.add(wordPanelArray[i]);
		}
		
		
		userPanel = new UserPanel(); //initializing the userpanel
		userPanel.getEnterButton().addActionListener(this);
		
		gameFrame.add(userPanel);
		
		
		gameFrame.revalidate();
		
		wordleString = getWordleString();
		System.out.println("Word for the day : " + wordleString);
		
		
		
		
	 }


	public String obtainValidUserWord (List<String> wordList) {
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        String userWord = myScanner.nextLine();  // Read user input
        userWord = userWord.toLowerCase(); // covert to lowercase

        // check the length of the word and if it exists
        while ((userWord.length() != 5) || !(wordList.contains(userWord))) {
            if ((userWord.length() != 5)) {
                System.out.println("The word " + userWord + " does not have 5 letters.");
            } else {
                System.out.println("The word " + userWord + " is not in the word list.");
            }
            // Ask for a new word
            System.out.println("Please, submit a new 5-letter word.");
            
            userWord = myScanner.nextLine();
        }
        return userWord;
    }
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		String userWord = this.userPanel.getUserInput().getText();

		if (userWord.length() > 4) {
			 isWordleWordEqualTo(userWord.trim().toUpperCase());
			 
			}
		
		count++;	
		
	}
	
	
	
	public WordPanel getActivePanel() {
		return this.wordPanelArray[count];
	}

	
	public String getWordleString() {
		Path path = Paths.get("C:\\Users\\LENOVO\\eclipse-workspace\\WordleBAU\\Words.txt");

		
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
    

	private boolean isWordleWordEqualTo(String userWord) {
		List<String> wordleWordsList = Arrays.asList(wordleString.split(""));
		String[] userWordsArray = userWord.split("");
		List<Boolean> wordMatchesList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			if (wordleWordsList.contains(userWordsArray[i])) {
				if (wordleWordsList.get(i).equals(userWordsArray[i])) {
					getActivePanel().setPanelText(userWordsArray[i], i, Color.GREEN);
					wordMatchesList.add(true);
				} else {
					getActivePanel().setPanelText(userWordsArray[i], i, Color.YELLOW);
					wordMatchesList.add(false);
				}
			} else {
				getActivePanel().setPanelText(userWordsArray[i], i, Color.GRAY);
				wordMatchesList.add(false);
			}
		}
		return !wordMatchesList.contains(false);
	}


    
    
    
   
}
