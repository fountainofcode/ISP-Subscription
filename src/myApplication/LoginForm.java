/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import businessLayer.BLUser;
import objectFactory.User;

/**
 *
 * @author Kriss
 */
public class LoginForm extends JFrame {
    /*Declaring our swing components*/
	JLabel l_name, l_pass;
	JTextField t_name;
	JPasswordField t_pass;
	JButton button;
	Container c;
	
	/*A separate class for processing database connection and authentication*/
	BLUser blUser;
	User user;
	
	public LoginForm() {
		//super("Login Form"); //Maybe not need
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		blUser = new BLUser();
		user = new User();
		
		/*Swing components*/
		l_name = new JLabel("Username");
		l_pass = new JLabel("Password");
		t_name = new JTextField(25);
		t_pass = new JPasswordField(12);
		button = new JButton("Login");
		
		/*Adding ActionListener to the button*/
		button.addActionListener(new MyEventHandler());
		
		/*Add to container*/
		c.add(l_name);
		c.add(t_name);
		c.add(l_pass);
		c.add(t_pass);
		c.add(button);
		
		/*Visual*/
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //to close the form
		setSize(200, 200);
	}
	
	
	/*An inner class*/
	public class MyEventHandler implements ActionListener {

		/*This is triggered whenever the user clicks the login button*/
		public void actionPerformed(ActionEvent ae) {

			/*Checks if the button clicked*/
			if(ae.getSource() == button) {
				char[] temp_pwd = t_pass.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(temp_pwd);
				
				/*The entered username and password are sent via "checkLogin()" with return boolean*/
				try {
					blUser = new BLUser();
					user = new User();
					
					user.setUsername(t_name.getText());
					user.setPassword(pwd);
					
					if(blUser.checkLogin()) {
						user = blUser.getUser();
						JOptionPane.showMessageDialog(null, "Welcome" + user.getUsername() + ", you are logged in successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						setVisible(false);

						DesktopFrame f1 = new DesktopFrame();
						f1.setUser(user);
						f1.setVisible(true);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Login failed! System will now exit", "Failed!!", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
						
					}
						
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
				}
			}//if
			
		}//method
	}//inner class

        public static void main(String args[]) {
            LoginForm frm = new LoginForm();
        }
    
}
