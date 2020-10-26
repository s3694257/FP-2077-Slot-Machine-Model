package slotmachine.model.slots;

import java.util.ArrayList;
import java.util.Collections;

public class WheelImpl implements Wheel {

	private ArrayList<SlotItem> wheelContents = new ArrayList<SlotItem>();
	private int wheelNumber;
	private int topIndex = 0;
	private int centreIndex = 1;
	private int bottomIndex = 2;

	public static Wheel createWheel(int wheelNum) {
		Wheel wheel = new WheelImpl(wheelNum);
		return wheel;
	}
	
	private WheelImpl(int wheelNum) {
		this.wheelNumber = wheelNum + 1;
		this.wheelContents = generateSlots();
	}
	
	public java.util.ArrayList<SlotItem> generateSlots() {
		for (SlotItem e : SlotItem.values()) {
			int i = 0;
			while (i < e.getCount()) {
				wheelContents.add(e);
				i++;
			}
		}
		Collections.shuffle(wheelContents);
		System.out.println(wheelContents);
		return wheelContents;
	}
	
	@Override
	public SlotItem getTopSlot() {
		return wheelContents.get(topIndex);
	}

	@Override
	public SlotItem getCentreSlot() {
		return wheelContents.get(centreIndex);
	}

	@Override
	public SlotItem getBottomSlot() {
		return wheelContents.get(bottomIndex);
	}

	@Override
	public Wheel nextSlot() {
		if (this.topIndex == wheelContents.size()) {this.topIndex = 0;}
		else topIndex += 1;
		if (this.centreIndex == wheelContents.size()) {this.centreIndex = 0;}
		else centreIndex += 1;
		if (this.bottomIndex == wheelContents.size()) {this.bottomIndex = 0;}
		else bottomIndex += 1;
		return null;
	}
	
	public String toString() {
		String wheelString = String.format("Wheel #%d %-11s/ %-11s/ %-11s", this.wheelNumber, this.getTopSlot(), this.getCentreSlot(), this.getBottomSlot());
		return wheelString;
	}
}