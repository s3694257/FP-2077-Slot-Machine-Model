package slotmachine.model;

import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;

import slotmachine.model.slots.LineNum;
import slotmachine.model.slots.SpinResult;
import slotmachine.model.slots.Wheel;
import slotmachine.model.slots.WheelImpl;
import slotmachine.model.slots.WinSettings;
import slotmachine.model.slots.WinSettingsImpl;
import slotmachine.view.ConsoleLoggerCallback;
import slotmachine.view.GameCallback;

public class SlotMachineImpl implements SlotMachine {

	public GameCallback currentCallback = new ConsoleLoggerCallback();
	public Collection<GameCallback> gameCallbackCollection = new ArrayList<GameCallback>();
	private Player player;
	public WinSettings winSettingsImpl;
	public int totalBet;
	
	
	public SlotMachineImpl() {
		Wheel wheel1 = WheelImpl.createWheel(0);
		Wheel wheel2 = WheelImpl.createWheel(1);
		Wheel wheel3 = WheelImpl.createWheel(2);
		System.out.println(wheel1);
		System.out.println(wheel2);
		System.out.println(wheel3);
		wheel1.nextSlot();
		wheel2.nextSlot();
		wheel3.nextSlot();
		System.out.println(wheel1);
		System.out.println(wheel2);
		System.out.println(wheel3);
		winSettingsImpl = new WinSettingsImpl();
	}
	
	public SlotMachineImpl(Wheel wheel1, Wheel wheel2, Wheel wheel3, WinSettings winSettings) {}
	
	@Override
	public int addCallback(GameCallback callback) {
		gameCallbackCollection.add(callback);
		return gameCallbackCollection.size()-1;
	}

	@Override
	public int removeCallback(GameCallback callback) {
		gameCallbackCollection.remove(callback);
		return gameCallbackCollection.size();
	}

	@Override
	public Player registerPlayer(String id, String name, int initialCredits) {
		this.player = new PlayerImpl(id, name, initialCredits);
		currentCallback.registerPlayer(player);
		return player;
	}

	@Override
	public Player cashOut() {
		this.resetBets();
		currentCallback.cashOutPlayer(player);
		return player;
	}

	@Override
	public void addCredits(int credits) throws IllegalStateException, IllegalArgumentException {
		player.addCredits(credits);
		currentCallback.addCredits(player, credits);
	}

	@Override
	public void placeBet(int amount) throws IllegalArgumentException, IllegalStateException {
		player.setBet(amount);
		totalBet += totalBet;
	}

	@Override
	public void resetBets() {
		// TODO Auto-generated method stub

	}

	@Override
	public SpinResult spinToWin(int turns, int delay) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpinResult spin(int turns, int delay) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int applySpinResult(SpinResult spinResult) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void placeBet(int amount, LineNum line) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeBet(int amount, Set<LineNum> lines) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeBet(int amount, LineNum... lines) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

}
