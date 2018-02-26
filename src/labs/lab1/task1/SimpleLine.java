package labs.lab1.task1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 * Draws a line from x to y
 * 
 * @author Florian Widder
 *
 */
public class SimpleLine implements GLEventListener {

	/**
	 * Creates a new Line between Point a and b with the given RGB-Color
	 * 
	 * @param point_a_x
	 * @param point_a_y
	 * @param point_b_x
	 * @param point_b_y
	 * @param color_red
	 * @param color_green
	 * @param color_blue
	 */
	public SimpleLine(float point_a_x, float point_a_y, float point_b_x, float point_b_y, float color_red,
			float color_green, float color_blue) {
		super();
		this.point_a_x = point_a_x;
		this.point_a_y = point_a_y;
		this.point_b_x = point_b_x;
		this.point_b_y = point_b_y;
		this.color_red = color_red;
		this.color_green = color_green;
		this.color_blue = color_blue;
	}

	private float point_a_x, point_a_y, point_b_x, point_b_y, color_red, color_green, color_blue;

	@Override
	public void display(GLAutoDrawable gld) {
		// Set openGL settings
		GL2 gl = gld.getGL().getGL2();
		// set line color
		gl.glColor3d(color_red, color_green, color_blue);
		// Set drawing type to line
		gl.glBegin(GL2.GL_LINES);
		// Draw line from a to b
		gl.glVertex2f(point_a_x, point_a_y);
		gl.glVertex2f(point_b_x, point_b_y);
		// End line
		gl.glEnd();
		// Flush data to Graphics Card
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the point_a_x
	 */
	public float getPoint_a_x() {
		return point_a_x;
	}

	/**
	 * @param point_a_x
	 *            the point_a_x to set
	 */
	public void setPoint_a_x(float point_a_x) {
		this.point_a_x = point_a_x;
	}

	/**
	 * @return the point_a_y
	 */
	public float getPoint_a_y() {
		return point_a_y;
	}

	/**
	 * @param point_a_y
	 *            the point_a_y to set
	 */
	public void setPoint_a_y(float point_a_y) {
		this.point_a_y = point_a_y;
	}

	/**
	 * @return the point_b_x
	 */
	public float getPoint_b_x() {
		return point_b_x;
	}

	/**
	 * @param point_b_x
	 *            the point_b_x to set
	 */
	public void setPoint_b_x(float point_b_x) {
		this.point_b_x = point_b_x;
	}

	/**
	 * @return the point_b_y
	 */
	public float getPoint_b_y() {
		return point_b_y;
	}

	/**
	 * @param point_b_y
	 *            the point_b_y to set
	 */
	public void setPoint_b_y(float point_b_y) {
		this.point_b_y = point_b_y;
	}

	/**
	 * @return the color_red
	 */
	public float getColor_red() {
		return color_red;
	}

	/**
	 * @param color_red
	 *            the color_red to set
	 */
	public void setColor_red(float color_red) {
		this.color_red = color_red;
	}

	/**
	 * @return the color_green
	 */
	public float getColor_green() {
		return color_green;
	}

	/**
	 * @param color_green
	 *            the color_green to set
	 */
	public void setColor_green(float color_green) {
		this.color_green = color_green;
	}

	/**
	 * @return the color_blue
	 */
	public float getColor_blue() {
		return color_blue;
	}

	/**
	 * @param color_blue
	 *            the color_blue to set
	 */
	public void setColor_blue(float color_blue) {
		this.color_blue = color_blue;
	}

}
