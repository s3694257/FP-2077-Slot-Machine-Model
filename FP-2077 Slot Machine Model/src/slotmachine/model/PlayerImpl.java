package slotmachine.model;

public class PlayerImpl implements Player {

	private String id;
	private String name;
	private int initialCredits;
	private int currentCredits;
	private int availableCredits;
	private int currentBet;
	
	public PlayerImpl(String id, String name, int initialCredits) 
	throws java.lang.IllegalArgumentException {
		this.id = id;
		this.name = name;
		this.initialCredits = initialCredits;
		this.currentCredits = initialCredits;
		this.availableCredits = initialCredits;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getInitalCredits() {
		return initialCredits;
	}

	@Override
	public int getCredits() {
		return currentCredits;
	}

	@Override
	public int getAvailableCredits() {
		return availableCredits;
	}

	@Override
	public void addCredits(int credits) {
		availableCredits += credits;
		currentCredits += credits;
	}

	@Override
	public int getBet() {
		return currentBet;
	}

	@Override
	public void setBet(int bet) {
		currentBet += bet;
		availableCredits -= bet;
	}

	@Override
	public void resetBet() {
		availableCredits += currentBet;
		currentBet = 0;
	}

	@Override
	public void applyWin(int winAmount) {
		availableCredits += winAmount;
		currentCredits = availableCredits;
	}
	
	public String toString() {
		return String.format("Player %s, %s, credits %d, bet %d, available %d", id, name, currentCredits, currentBet, availableCredits);
	}

}
