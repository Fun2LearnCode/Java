package client;

import java.util.ArrayList;
import java.util.HashMap;

import common.Message;
import common.User;
import interfaces.IUser;

public class Registry {
	private HashMap<Integer, UserHistory> registry;
	private IUser chattingWith;
	public Registry(){
		registry = new HashMap<Integer, UserHistory>();
		chattingWith = new User(0,"server");
		register(chattingWith, new UserHistory(100));
	}
	public void register(IUser user, UserHistory userHistory){
		registry.put(user.getId(), userHistory);
	}
	public IUser getChattingWith(){
		return chattingWith;
	}
	public void loadChattingWith(IUser user){
		chattingWith = user;
	}
	public void addToSentHistory(Message message){
		registry.get(message.getReciver().getId()).add(message);
	}
	public void addToRecivedHistory(Message message){
		registry.get(message.getSender().getId()).add(message);
	}
	public ArrayList<Message> getHistory(){
		return registry.get(chattingWith.getId()).getHistory();
	}
	public void remove(IUser iUser){
		registry.remove(iUser.getId());
	}
	public boolean isChattingWith(IUser user){
		return chattingWith.getId() == user.getId();
	}
	
}
