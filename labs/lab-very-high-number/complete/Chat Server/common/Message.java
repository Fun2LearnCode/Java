package common;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String to;
	private String from;
	private String message;
	private StatusMessage status;
	public Message(String message, String to, String from, StatusMessage status){
		this.to = to;
		this.message = message;
		this.from = from;
		this.status = status;
	}
	public String getTo(){
		return to;
	}
	public String getFrom(){
		return from;
	}
	public String getMessage(){
		return message;
	}
	public StatusMessage getStatus(){
		return status;
	}
	public int getToIndex(){
		return Integer.parseInt(to.substring(0,2));
	}
	public int getFromIndex(){
		return Integer.parseInt(from.substring(0,2));
	}
	@Override
	public String toString(){
		return message + "\n" + "From: "+ from + "\n" + "To: " + to + "\n" + status;
	}
}
