package florianWidder.StudentID18999061.assignment1.objects;

import java.time.LocalDateTime;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public abstract class AbstractGraphicObject {

	/**
	 * Standard value: white #ffffff
	 */
	protected float[] color = { 0, 0, 0, 1 };

	/**
	 * Horizontal movement per second.<br>
	 * Standard value: 0f
	 */
	protected float dx = 0f;

	/**
	 * Vertical movement per second.<br>
	 * Standard value: 0f
	 */
	protected float dy = 0f;

	/**
	 * Last time {@link #calculate()} were called .
	 */
	protected long lastUpdate;

	/**
	 * Current time
	 */
	private static LocalDateTime time = LocalDateTime.now();

	/**
	 * @param ms adds the converted ingame time to the actual ingame time
	 */
	public static void increaseTime(long ms) {
		double timeToAdd = ms / 30;
		time = time.plusMinutes((long) timeToAdd);
	}

	/**
	 * Standard value: see
	 * {@link florianWidder.StudentID18999061.assignment1.objects.Point#Point()
	 * Point()}
	 */
	protected Point position = new Point();

	/**
	 * Standard value: true
	 */
	protected boolean visible = true;

	/**
	 * 
	 */
	public AbstractGraphicObject() {
		super();
	}

	/**
	 * @param position
	 */
	public AbstractGraphicObject(Point position) {
		super();
		this.position = position;
	}

	/**
	 * Calculates Position Updates
	 */
	public abstract void calculate();;

	/**
	 * Draws the Object with the passed GL2 Object, if {@link #visible} is true, by
	 * calling {@link #realDraw(GL2)}.
	 * 
	 * @param gl
	 */
	public void draw(GL2 gl) {
		if (!visible)
			return;
		realDraw(gl);
	}

	/**
	 * Help function for drawing a filled circle using the last set Color.
	 * 
	 * @param gl
	 *            the drawing Object
	 * @param xPos
	 *            the x-Position
	 * @param yPos
	 *            the y-Position
	 * @param radius
	 *            the Radius
	 * @param step
	 *            the step with
	 */
	protected void drawCircle(GL2 gl, float xPos, float yPos, float radius, int step) {
		float x1, y1, x2, y2;
		float angle;

		x1 = xPos;
		y1 = yPos;

		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		gl.glVertex2f(x1, y1);

		for (angle = 1.0f; angle < 361.0f; angle += step) {
			x2 = (float) (x1 + Math.sin(angle) * radius);
			y2 = (float) (y1 + Math.cos(angle) * radius);
			gl.glVertex2f(x2, y2);
		}

		gl.glEnd();
	}

	/**
	 * @return the color: [0] red, [1] green, [2] blue, [3] transparency
	 */
	public float[] getColor() {
		return color;
	}

	/**
	 * @return the dx
	 */
	public float getDx() {
		return dx;
	}

	/**
	 * @return the dy
	 */
	public float getDy() {
		return dy;
	}

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Draws the Object with the passed GL2 Object.
	 * 
	 * @param gl
	 *            the drawing Object
	 */
	protected abstract void realDraw(GL2 gl);

	/**
	 * Setting color with no transparency.
	 * 
	 * @param red
	 *            the red-value
	 * @param green
	 *            the green-value
	 * @param blue
	 *            the blue-value
	 * 
	 * @see #setColor(float, float, float, float)
	 */
	public void setColor(float red, float green, float blue) {
		this.color[0] = red;
		this.color[1] = green;
		this.color[2] = blue;
		this.color[3] = 1;
	}

	/**
	 * Setting color with transparency.
	 * 
	 * @param red
	 *            the red-value
	 * @param green
	 *            the green-value
	 * @param blue
	 *            the blue-value
	 * @param transparency
	 *            the transparency-value
	 * 
	 * @see #setColor(float, float, float)
	 */
	public void setColor(float red, float green, float blue, float transparency) {
		setColor(red, green, blue);
		this.color[3] = transparency;
	}

	/**
	 * @param dx
	 *            the dx to set
	 */
	public void setDx(float dx) {
		this.dx = dx;
	}

	/**
	 * @param dy
	 *            the dy to set
	 */
	public void setDy(float dy) {
		this.dy = dy;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the time
	 */
	public static LocalDateTime getTime() {
		return time;
	}
}
