package assignment1.objects;

import com.jogamp.opengl.GL2;

public abstract class GraphicObject {

	/**
	 * @param position
	 */
	public GraphicObject(Point position) {
		super();
		this.position = position;
	}

	/**
	 * @param position
	 */
	public GraphicObject() {
		super();
	}

	/**
	 * Standard value: true
	 */
	protected boolean visible = true;
	protected Point position;

	/**
	 * Last time called {@link #calculate()}.
	 */
	protected long lastUpdate;

	/**
	 * Standard value: white #ffffff
	 */
	protected float[] color = { 0, 0, 0, 1 };

	/**
	 * Standard value: 0f
	 */
	protected float speed = 0f;

	/**
	 * Standard value: 0f
	 */
	protected float dx = 0f;

	/**
	 * Standard value: 0f
	 */
	protected float dy = 0f;

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
	};

	/**
	 * Draws the Object with the passed GL2 Object.
	 * 
	 * @param gl
	 *            the drawing Object
	 */
	protected abstract void realDraw(GL2 gl);

	/**
	 * Calculates Position Updates
	 */
	public abstract void calculate();

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
	 */
	protected void drawCircle(GL2 gl, float xPos, float yPos, float radius) {
		float x1, y1, x2, y2;
		float angle;

		x1 = xPos;
		y1 = yPos;

		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glVertex2f(x1, y1);

		for (angle = 1.0f; angle < 361.0f; angle += 0.2) {
			x2 = (float) (x1 + Math.sin(angle) * radius);
			y2 = (float) (y1 + Math.cos(angle) * radius);
			gl.glVertex2f(x2, y2);
		}

		gl.glEnd();
	}

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
		this.color[0] = green;
		this.color[0] = blue;
		this.color[0] = 1;
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
		this.color[0] = red;
		this.color[0] = green;
		this.color[0] = blue;
		this.color[0] = transparency;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the dx
	 */
	public float getDx() {
		return dx;
	}

	/**
	 * @param dx
	 *            the dx to set
	 */
	public void setDx(float dx) {
		this.dx = dx;
	}

	/**
	 * @return the dy
	 */
	public float getDy() {
		return dy;
	}

	/**
	 * @param dy
	 *            the dy to set
	 */
	public void setDy(float dy) {
		this.dy = dy;
	}

	/**
	 * @return the color: [0] red, [1] green, [2] blue, [3] transparency
	 */
	public float[] getColor() {
		return color;
	}
}
