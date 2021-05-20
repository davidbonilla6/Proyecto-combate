package RaceBattle;

public class Player {
	int player_id;
	String player_name;
	public Player(int player_id, String player_name) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + "]";
	}
	
	
}
