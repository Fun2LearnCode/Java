package client;

import common.Message;
import common.StatusMessage;
import interfaces.Display;
import interfaces.IUser;
import interfaces.InputHandler;
import interfaces.MessageHandler;
import interfaces.OutputStream;
import interfaces.UserHandler;
import interfaces.Users;

public class LogicHandler implements UserHandler, InputHandler, MessageHandler {
	private Display messageDisplay;
	private Users usersDisplay;
	private OutputStream output;
	private Registry registry;
	private IUser me;
	public LogicHandler(OutputStream output){
		this.output = output;
		registry = new Registry();
	}
	public void loadMessageDisplay(Display messageDisplay) {
		this.messageDisplay = messageDisplay;
	}
	@Override
	public void handleIncomingMessage(Message message){
		System.out.println(message);
		switch(message.getStatus()){
			case MESSAGE:
				registry.addToRecivedHistory(message);
				if(registry.isChattingWith((message.getSender()))){
					messageDisplay.displayRecived(message.getMessage());
				}
				break;
			case REMOVEUSER:
				usersDisplay.removeUser(message.getSender());
				registry.remove(message.getSender());
				break;
			case NEWUSER:
				me = message.getReciver();
				break;
			case ADDUSER:
				usersDisplay.addUser(message.getSender());
				registry.register(message.getSender(), new UserHistory());
				break;
			default:
				break;
		}
		
		
	}
	@Override
	public void send(String message) {
		Message temp = new Message(message, registry.getChattingWith(), me, StatusMessage.MESSAGE);
		messageDisplay.displaySent(temp.getMessage());
		registry.addToSentHistory(temp);
		output.send(temp);
	}
	@Override
	public void loadUser(IUser user) {
		messageDisplay.clear();
		registry.loadChattingWith(user);
		for(Message foo : registry.getHistory()){
			if(foo.getSender().equals(me)){
				messageDisplay.displaySent(foo.getMessage());
			}else{
				messageDisplay.displayRecived(foo.getMessage());
			}
		}
	}
	@Override
	public void loadUserDisplay(Users usersDisplay) {
		this.usersDisplay = usersDisplay;		
	}
}
