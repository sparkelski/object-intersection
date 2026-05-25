package Intersection1;

// throws exception when shape arguments are out of bounds
public class ShapeArgumentException extends Exception {
	private static final long serialVersionUID = 1L;

	public ShapeArgumentException(String message) {
        super(message);
    }
}
