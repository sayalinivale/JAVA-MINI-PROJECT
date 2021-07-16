package sayali;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class game {
	
    public static void main(String[] args) {
    	
    	JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame f = new JFrame("Guessing Game");
		
		//Close the frame output 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lb_guessGame, lb_enterNum, lb_msg;
        
        JButton b_check, b_close;
        
        JTextField txt_enterNum;
        
        //label named "Guessing name - heading"
      	lb_guessGame = new JLabel("GUESSING GAME");
      	lb_guessGame.setBounds(115, 20, 200, 20);
      	lb_guessGame.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 20));
      	f.add(lb_guessGame);
      	
      	lb_enterNum = new JLabel("Guess a number between 1 to 100");
      	lb_enterNum.setBounds(68, 80, 300, 20);
      	lb_enterNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
      	f.add(lb_enterNum);
      	
      	lb_msg = new JLabel();
      	lb_msg.setBounds(80, 300, 600, 20);
      	lb_msg.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      	f.add(lb_msg);
      	
      	txt_enterNum = new JTextField();
      	txt_enterNum.setBounds(50, 130, 330, 20);
      	txt_enterNum.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
      	f.add(txt_enterNum);
      	
      //Check if the user enters numerical characters in the text field.
      	txt_enterNum.addKeyListener(new KeyAdapter() {
      			
      			public void keyPressed(KeyEvent e) {								

      				
      				char ce = e.getKeyChar();
      				
      				if((!Character.isDigit(ce)) || (Character.isLetter(ce)) || (Character.isWhitespace(ce))) {
      					txt_enterNum.setEditable(false);
      					lb_msg.setText("Enter a numerical value only");
      				}
      				else {
      					txt_enterNum.setEditable(true);
      				}				
      			}
      			
      		});
        
      	//button to check
      	b_check = new JButton("CHECK");
      	b_check.setBounds(50, 200, 100, 20);
      	f.add(b_check);
      	
      	//button to close
      	b_close = new JButton("CLOSE");
      	b_close.setBounds(280, 200, 100, 20);
      	f.add(b_close);
        
      	
      	int computerNumber = (int) (Math.random()*100 + 1);
		System.out.println("The correct guess would be " + computerNumber);
        f.setSize(600, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		//Action listener for b_check button
				b_check.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						
						int count =1;

						int guess = Integer.parseInt(txt_enterNum.getText());
						
						if (guess <=0 || guess >100) {
				            lb_msg.setText("Your guess is invalid"); 
				        }
				        else if (guess == computerNumber ){
				        	lb_msg.setText("Correct!");
				        }
				        else if (guess > computerNumber) {
				        	lb_msg.setText("Your guess is too high, try again." );
				        }
				        else if (guess < computerNumber) {
				        	lb_msg.setText("Your guess is too low, try again." ); 
				        }
				        else {
				        	lb_msg.setText("Your guess is incorrect ");
				        }

						if(computerNumber != guess) {
							
							count = count +1;							
						}	
						
						
								
					}
				});
				
				// Action listener to close the application
		        b_close.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		                f.dispose();
		            }
		        });
    }
}