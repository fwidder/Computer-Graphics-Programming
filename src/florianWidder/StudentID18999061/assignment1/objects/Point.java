package florianWidder.StudentID18999061.assignment1.objects;

/**
 * Saving a 2D point
 * 
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class Point {
	/**
	 * Creates a new {@link #Point} with the position 0, 0
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Creates a new {@link #Point} with the passed position
	 * 
	 * @param x
	 *            the x-position of the point
	 * @param y
	 *            the y-position of the point
	 */
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	private float x, y;

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
}
