package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.owner = owner;
		this.memberList = new ArrayList<>();
		this.channelList = new ArrayList<>();
		addUser(owner);
		setName(name);
		String channelName = null;
		switch(template) {
		case TemplateType.BASIC: 
			channelName = "general";
			break;
		case TemplateType.GAMING:
			channelName = "gaming";
			break;
		case TemplateType.STUDY:
			channelName = "homework-help";
			break;
		}
		
		addChannel(owner,channelName);
	}
	
	public boolean isMemberInServer(User user) {
		if(memberList.contains(user)) {
			return true;
		}
		return false;
	}
	
	public Channel addChannel(User user, String channelName) {
		if(user.equals(owner)) {
			Channel c = new Channel(channelName);
			channelList.add(c);
			return c;
		}
		return null;
	}
	
	public User addUser(User user) {
		if(!memberList.contains(user)) {
			memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
		return null;
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if(!kicker.equals(owner)) {
			throw new Exception();
		}
		else if(!memberList.contains(kicked) || kicked.equals(owner)) {
			return false;
		}
		else {
			kicked.getJoinedServersList().remove(this);
			memberList.remove(kicked);
			return true;
		}
	}
	
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = owner.getName()+" home";
		}else {
			this.name = name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public ArrayList<Channel> getChannelList(){
		return channelList;
	}
	
	public ArrayList<User> getMemberList(){
		return memberList;
	}
	
}
