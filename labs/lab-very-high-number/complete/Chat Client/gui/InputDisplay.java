package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.InputHandler;


public class InputDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private InputHandler inputHandler;
	public InputDisplay(InputHandler inputHandler){
		this.inputHandler = inputHandler;
		setBounds(10, 205, 415, 45);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 300, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.requestFocusInWindow();
		btnNewButton.setBounds(320, 10, 90, 20);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				send();
			}
		});
		add(btnNewButton);
	}
	
	public void send(){
		inputHandler.send(textField.getText());
		textField.setText("");
	}
}
