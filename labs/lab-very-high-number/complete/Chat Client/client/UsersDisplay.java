package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UsersDisplay extends JScrollPane {
	private static final long serialVersionUID = 1L;
	private String currentUser;
	private ArrayList<JButton> users;
	private boolean newUser;
	private JPanel panel;
	public UsersDisplay() {
		currentUser = "0";
		newUser = false;
		users = new ArrayList<JButton>();
		setBounds(5, 10, 70, 180);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setViewportView(panel);
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void addUser(String id) {
		addButton(id);
	}
	
	public boolean newUser(){
		boolean temp = newUser;
		newUser = false;
		return temp;
	}
	public void removeUser(String string) {
		boolean removed = false;
		for(int x = 0; x < users.size();x++){
			if(users.get(x).getText().equals(string)){
				if(users.get(x).getText().equals(currentUser)){
					currentUser="0";
				}
				users.remove(x);
				removed = true;
			}
	    }
		if(removed){
			panel.removeAll();
			for (JButton foo : users) {
				panel.add(foo);	
			}
			panel.validate();
			panel.repaint();
		}
	}
	private void addButton(String id) {
		JButton temp = new JButton(id);
		temp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUser = ((JButton) e.getSource()).getText();
				newUser = true;
			}
		});
		temp.setBorder(null);
		users.add(temp);
		panel.add(temp);
		validate();
	}
}
