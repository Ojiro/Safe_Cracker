import java.io.Serializable;


public class player implements Serializable{

	static int loot; // Loot is the currency of the game. Player gains and looses loot based on winning/losing safes. default is 3000 
	static int totalBreakIns; // Counts the number of safes cracked in a players career default is 0
	static int wantedLevel; // Wanted level dictates the cost of bail and increments based on how many safes the player has cracked
	static int explosives; // holds the number of TNT charges owned by the player
	static int snips;  // hold the number of snips owned by the player
	static int picks; // hold the number of lock picks owned by the player
	static boolean career=true;  // boolean keeps a dead carer from playing by turning it false and saving it in load file

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
}
