package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.IUser;

public class UserButton extends JButton{
	private static final long serialVersionUID = 1L;
	private IUser user;
	public UserButton(IUser user2){
		super(user2.getUsername());
		this.user = user2;
	}
	public String getUsername(){
		return user.getUsername();
	}
	public int getId(){
		return user.getId();
	}
	public IUser getUser(){
		return user;
	}
	public void remove(){
		JPanel temp = (JPanel) getParent();
		temp.remove(this);
		temp.validate();
		temp.repaint();
	}
}
