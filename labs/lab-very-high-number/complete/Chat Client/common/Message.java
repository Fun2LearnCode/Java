package common;

import java.io.Serializable;

import interfaces.IUser;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private IUser reciver;
	private IUser sender;
	private String message;
	private StatusMessage status;
	public Message(String message, IUser reciver, IUser sender, StatusMessage status){
		this.reciver = reciver;
		this.message = message;
		this.sender = sender;
		this.status = status;
	}
	public IUser getReciver(){
		return reciver;
	}
	public IUser getSender(){
		return sender;
	}
	public String getMessage(){
		return message;
	}
	public StatusMessage getStatus(){
		return status;
	}
	@Override
	public String toString(){
		return message + "\n" + "senderId: "+ sender.getId() + "\n" + "reciverId: " + reciver.getId() + "\n" + status;
	}
}
