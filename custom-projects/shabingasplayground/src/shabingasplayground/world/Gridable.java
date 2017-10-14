package shabingasplayground.world;

import shabingasplayground.vector.Vector2;

public interface Gridable<E>{
	Vector2 getPosition();
	E getAbove();
	E getBelow();
	E getLeft();
	E getRight();
	void setPosition(Vector2 position);
	void setAbove(E above);
	void setBelow(E below);
	void setLeft(E left);
	void setRight(E right);
}
