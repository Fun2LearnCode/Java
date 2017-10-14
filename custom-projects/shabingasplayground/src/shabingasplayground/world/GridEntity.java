package shabingasplayground.world;

import shabingasplayground.vector.Vector2;

public class GridEntity <E extends Gridable<E>> implements Gridable<E> {
	private Vector2 position;
	private E above;
	private E below;
	private E left;
	private E right;
	@Override
	public E getAbove() {
		return above;
	}
	@Override
	public E getBelow() {
		return below;
	}
	@Override
	public E getLeft() {
		return left;
	}
	@Override
	public E getRight() {
		return right;
	}
	@Override
	public void setAbove(E above) {
		this.above = above;
	}
	@Override
	public void setBelow(E below) {
		this.below = below;
	}
	@Override
	public void setLeft(E left) {
		this.left = left;
	}
	@Override
	public void setRight(E right) {
		this.right = right;
	}
	@Override
	public Vector2 getPosition() {
		return position;
	}
	@Override
	public void setPosition(Vector2 position) {
		this.position = position;		
	}
	
}
