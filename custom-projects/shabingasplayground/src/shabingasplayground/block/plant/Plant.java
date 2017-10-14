package shabingasplayground.block.plant;

import shabingasplayground.block.Block;

public abstract class Plant extends Block{
	protected int growthTime;
	protected byte stage;
	protected PlantStage plantStages[]; 
	public Plant() {
		super((byte)1);
	}

}
