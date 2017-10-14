package shabingasplayground.world;

import shabingasplayground.vector.Vector2;

public abstract class Layer <E extends GridEntity<E>>{
	protected E matrix[][];
	public void setEntityAt(int r, int c, E entity){
		matrix[r][c] = entity;
		entity.setPosition(new Vector2(r,c));
	}
	public void setEntityAt(Vector2 vector, E entity){
		setEntityAt(vector.getIntY(), vector.getIntX(), entity);
	}
	public void setEntityAt(E oldEntity, E newEntity){
		setEntityAt(oldEntity.getPosition(), newEntity);
	}
	public E getEntityAt(int r, int c){
		return matrix[r][c];
	}
	public E getEntityAt(Vector2 vector){
		return matrix[vector.getIntY()][vector.getIntX()];
	}
	public E getEntityAbove(int r, int c){
		return matrix[r][c].getAbove();
	}
	public E getEntityAbove(Vector2 vector){
		return matrix[vector.getIntY()][vector.getIntX()].getAbove();
	}
	public E getEntityAbove(E entity){
		return entity.getAbove();
	}
	public E getEntityBelow(int r, int c){
		return matrix[r][c].getBelow();
	}
	public E getEntityBelow(Vector2 vector){
		return matrix[vector.getIntY()][vector.getIntX()].getBelow();
	}
	public E getEntityBelow(E entity){
		return entity.getBelow();
	}
	public E getEntityRight(int r, int c){
		return matrix[r][c].getRight();
	}
	public E getEntityRight(Vector2 vector){
		return matrix[vector.getIntY()][vector.getIntX()].getRight();
	}
	public E getEntityRight(E entity){
		return entity.getRight();
	}
	public E getEntityLeft(int r, int c){
		return matrix[r][c].getLeft();
	}
	public E getEntityLeft(Vector2 vector){
		return matrix[vector.getIntY()][vector.getIntX()].getLeft();
	}
	public E getEntityLeft(E entity){
		return entity.getLeft();
	}
	public void run(){}
}
