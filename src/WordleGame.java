import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
//import java.lang.WeakPairMap.Pair.Weak;
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
	
	public JFrame gameFrame;
	public WordPanel[] wordPanelArray = new WordPanel[6]; // creating 6 wordPanels because user has 6 tries
	public UserPanel userPanel;
	public String wordleString;
	public int count = 0;
	
	
	public WordleGame() { // constructor, initializing
		
		gameFrame = new JFrame("Wordle Game BAU Ver");
		gameFrame.setSize(300, 300);
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.setLayout(new GridLayout(7, 1)); // 6 for tries, 1 for userinput
		gameFrame.setVisible(true);
		gameFrame.setLocationRelativeTo(null); //puts it in the center of our system
		
		
		for (int i = 0; i < 6; i++) {  //initializng the wordpanel array
			wordPanelArray[i] = new WordPanel();
			gameFrame.add(wordPanelArray[i]);
		}
		
		
		userPanel = new UserPanel(); //initializing the userpanel
		userPanel.getEnterButton().addActionListener(this);
		
		
		gameFrame.add(userPanel);
		gameFrame.revalidate();
		
		
		
		
	 }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		if("Enter".equals(action)) {
			System.out.println(this.userPanel.getUserInput().getText());
			
		}
	}
	
	public List<String> readWordsFile(String fileName){
   	 
   	 ArrayList<String> arr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("Words.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return arr;

    
    }
    
    // get a random word from the dictionary arraylist
    public String getRandomWord(List<String> arr) {
        Random rand = new Random(); //instance of random class
        int upperbound = arr.size();
        //generate random values from 0 to arrayList size
        int int_random = rand.nextInt(upperbound);
        return arr.get(int_random);
    }
    
	
	   

	
}


	
	