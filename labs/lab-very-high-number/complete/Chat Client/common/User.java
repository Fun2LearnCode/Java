package common;

import java.io.Serializable;

import interfaces.IUser;

public class User implements Serializable, IUser{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	public User(int id, String username){
		this.id = id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setName(String username){
		this.username = username;
	}
}
