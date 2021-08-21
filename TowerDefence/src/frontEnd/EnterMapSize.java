package frontEnd;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

public class EnterMapSize {
	JFrame frame;
	JTextField textField;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EnterMapSize window = new EnterMapSize();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * @effect create the enter map size window
	 */
	public EnterMapSize() {
		init();
	}
	
	/**
	 * @effect initialize the window with button and text area
	 */
	public void init() {
		frame = new JFrame();
		frame.setTitle("Tower Defence Maker - Creating");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField MapSizeX = new JTextField();
		MapSizeX.setBounds(185, 85, 60, 21);
		frame.getContentPane().add(MapSizeX);
		MapSizeX.setColumns(10);
		
		JTextField MapSizeY = new JTextField();
		MapSizeY.setBounds(270, 85, 60, 21);
		frame.getContentPane().add(MapSizeY);
		MapSizeY.setColumns(10);
		
		JLabel Lable_MapSize = new JLabel("Please enter map size: ");
		Lable_MapSize.setBounds(50, 88, 180, 15);
		frame.getContentPane().add(Lable_MapSize);
		
		JLabel Lable_X = new JLabel(" X ");
		Lable_X.setBounds(250, 88, 30, 15);
		frame.getContentPane().add(Lable_X);
		
		JLabel Lable_eg = new JLabel("e.g.   8x8");
		Lable_eg.setBounds(165, 108, 60, 15);
		frame.getContentPane().add(Lable_eg);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModeSelectionPage msp = new ModeSelectionPage();
				msp.frame.setVisible(true);
			}
		});
		Back.setBounds(110, 171, 93, 23);
		frame.getContentPane().add(Back);
		
		JButton Button_Confirm = new JButton("Confirm");
		Button_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							int tmpX = checkInt(MapSizeX.getText());
							int tmpY = checkInt(MapSizeY.getText());
							if(tmpX != -1 && tmpY != -1) {
								@SuppressWarnings("unused")
								GUI StartGame = new GUI(tmpX, tmpY);
							}else{
								JFrame err = new JFrame();
								err.setBounds(100, 100, 450, 300);
								err.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								err.getContentPane().setLayout(null);
								JLabel errMessage = new JLabel("Please enter integers !!");
								errMessage.setBounds(150, 108, 160, 15);
								err.getContentPane().add(errMessage);
								err.setVisible(true);
								
								JButton Button_Back = new JButton("Back");
								Button_Back.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										err.dispose();
										EnterMapSize MapSize = new EnterMapSize();
										MapSize.frame.setVisible(true);
									}
								});
								Button_Back.setBounds(110, 171, 93, 23);
								err.getContentPane().add(Button_Back);
							}
						}
					});
				}
			}
		});
		Button_Confirm.setBounds(238, 171, 93, 23);
		frame.getContentPane().add(Button_Confirm);

		JButton btnNewButton = new JButton("Community");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new java.net.URI("http://towerdm.com/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(321, 10, 103, 23);
		frame.getContentPane().add(btnNewButton);
	}

	
	/**
	 * 
	 * @param input user input value
	 * @return the integer format of input value
	 */
	public int checkInt(String input) {
		try {
			return Integer.parseInt(input);
		}catch(Exception e) {
			return -1;
		}
	}
}
