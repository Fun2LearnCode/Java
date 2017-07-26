package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.IUser;
import interfaces.UserHandler;
import interfaces.Users;

public class UsersDisplay extends JScrollPane implements Users{
	private static final long serialVersionUID = 1L;
	private ArrayList<UserButton> users;
	private JPanel panel;
	private UserHandler userHandler;
	public UsersDisplay(UserHandler userHandler) {
		this.userHandler = userHandler;
		users = new ArrayList<UserButton>();
		userHandler.loadUserDisplay(this);
		setBounds(5, 10, 70, 180);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setViewportView(panel);
	}
	@Override
	public void removeUser(IUser user) {
		for(int x = 0; x < users.size();x++){
			if(users.get(x).getUser().equals(user)){
				users.get(x).remove();
				users.remove(x);
				break;
			}
	    }
		panel.validate();
		panel.repaint();
	}
	@Override
	public void addUser(IUser user) {
		UserButton temp = new UserButton(user);
		temp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userHandler.loadUser(((UserButton) e.getSource()).getUser());
			}
		});
		temp.setBorder(null);
		users.add(temp);
		panel.add(temp);
		validate();
	}

}
