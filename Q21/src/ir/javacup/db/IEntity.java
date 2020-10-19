package ir.javacup.db;

public interface IEntity<I> {

	void setId(I id);
	
	I getId();
}
