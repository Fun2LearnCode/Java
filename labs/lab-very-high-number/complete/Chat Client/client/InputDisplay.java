package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	private boolean newMessage;
	private String message;
	private JTextField textField;
	public InputDisplay(){
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
				sendMessage();
			}
		});
		add(btnNewButton);
	}
	public void sendMessage(){
		if(!textField.getText().equals("")){
			newMessage = true;
			message = textField.getText();
			textField.setText("");
		}
	}
	public boolean newMessage(){
		return newMessage;
	}
	public String getMessage(){
		newMessage = false;
		return message;
	}
}
