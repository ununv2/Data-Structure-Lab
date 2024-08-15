package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	public Database() {
		playerList = new ArrayList<>();
		regionList = new ArrayList<>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception{
		if(DatabaseUtil.isPlayerExists(playerList, name)){
				throw new Exception();	
			}
		Player p = new Player(name);
		playerList.add(p);
		region.addPlayerToRegion(p);
		return p;
		}
	
	public boolean addRegion(String name) {
		if(DatabaseUtil.isRegionExists(regionList, name)) {
				return false;
			
		}
		Region r = new Region(name);
		regionList.add(r);
		return true;
	}
	
	public Region getRegionByName(String name) {
		for(Region region:regionList) {
			if(region.getName().equals(name)) {
				return region;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest q = new Quest(author, region, name, description);
		region.addQuestToRegion(q);
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public ArrayList<Region> getRegionList(){
		return regionList;
	}
	
	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
	
	
}