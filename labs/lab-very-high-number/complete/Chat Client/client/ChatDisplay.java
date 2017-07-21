package client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import common.Message;

public class ChatDisplay extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String toId;
	public ChatDisplay(){		
		toId = "0";
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		setBounds(80, 10, 345, 180);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setViewportView(panel);
	}
	public void displayMessage(Message message){
		JEditorPane temp = new JEditorPane();
		temp.setText(message.getMessage());
		if(toId.equals(message.getTo())){	
			temp.setBorder(new EmptyBorder(0, 150, 0, 0));
		}else{
			temp.setBorder(new EmptyBorder(0, 0, 0, 150));	
		}
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		panel.add(temp, c);
		validate();
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}
	public void loadNewUser(String id, ArrayList<Message>history){
		panel.removeAll();
		panel.validate();
		panel.repaint();
		validate();
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
		toId = id;
		for(Message message : history){
			displayMessage(message);
		}
	}
}
