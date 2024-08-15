package logic;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		if(!name.isBlank()) {
			this.name = name;
			}else {
				this.name = "Nowhere";
			}
		playerList = new ArrayList<>();
		questList = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(!name.isBlank()) {
		this.name = name;
		}else {
			this.name = "Nowhere";
		}
	}
	
	public ArrayList<Player> getPlayerList(){

		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public ArrayList<Quest> getQuestList(){
		return questList;
	}
	
	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	public double getRegionRank() {
		int totalRank = 0;
		for(Player player : playerList) {
			totalRank += player.getRank();
		}
		double averageRank = Math.round(((double) totalRank / playerList.size()) * 100.0) / 100.0;
		return averageRank;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer){
		ArrayList<Quest> availableQuests = new ArrayList<>();
		for(Quest quest: questList) {
			if(quest.getRegion().getName().equals(name)) {
				if(quest.getStatus().equals(Status.AVAILABLE)) {
					if(!quest.getAuthor().equals(viewer)) {
						availableQuests.add(quest);
					}
				}
			}
		}
		return availableQuests;
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion (Quest q) {
		questList.add(q);
	}


}
