package slotmachine.model.slots;

public class SlotLineImpl implements SlotLine {

	public SlotItem slot1;
	public SlotItem slot2;
	public SlotItem slot3;
	public LineNum lineNum;
	
	public SlotLineImpl(LineNum lineNum,
            SlotItem slot1,
            SlotItem slot2,
            SlotItem slot3) {}
	
	@Override
	public SlotItem getSlot1() {
		return slot1;
	}

	@Override
	public SlotItem getSlot2() {
		return slot2;
	}

	@Override
	public SlotItem getSlot3() {
		return slot3;
	}

	@Override
	public boolean equals(SlotLine slotLine) {
	    if(this == slotLine) 
            return true; 
	    else return false;
	}

	@Override
	public LineNum getLineNum() {
		return lineNum;
	}
	
	@Override
	public int hashCode() {
		return hashCode();
	}
}
