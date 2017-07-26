package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaces.Display;

public class MessageDisplay extends JScrollPane implements Display{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public MessageDisplay(){		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		setBounds(80, 10, 345, 180);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setViewportView(panel);
	}
	@Override
	public void displaySent(String message){
		JEditorPane temp = new JEditorPane();
		temp.setText(message);
		temp.setBorder(new EmptyBorder(0, 150, 0, 0));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		panel.add(temp, c);
		validate();
		panel.validate();
		panel.repaint();
		repaint();
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}
	@Override
	public void displayRecived(String message){
		JEditorPane temp = new JEditorPane();
		temp.setText(message);
		temp.setBorder(new EmptyBorder(0, 0, 0, 150));	
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		panel.add(temp, c);
		validate();
		panel.validate();
		panel.repaint();
		repaint();
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}
	@Override
	public void clear() {
		panel.removeAll();
	}
}
