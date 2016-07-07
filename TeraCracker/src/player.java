import java.io.Serializable;


public class player implements Serializable{

	/* player class represents a player and the vital information about their career this far */
	public int loot; // Loot is the players bankroll of the game. Player starts with $3000
	public int totalBreakIns; // Counts the number of safes cracked
	public int wantedLevel; // Wanted level increases as the player breaks more and harder safes
	public int explosives; // holds the number of TNT charges owned by the player
	public int snips;  // hold the number of snips owned by the player
	public int picks; // hold the number of lock picks owned by the player
	public boolean career=true;  // boolean keeps a dead carer from playing by turning it false and saving it in load file

	player(int loot, int totalBreakIns, int wantedLevel, int explosives, int snips, int picks, boolean career)
	{
		this.loot=loot;
		this.totalBreakIns=totalBreakIns;
		this.wantedLevel=wantedLevel;
		this.explosives=explosives;
		this.snips=snips;
		this.picks=picks;
		this.career=career;
	}
	
	player()
	{}
}
