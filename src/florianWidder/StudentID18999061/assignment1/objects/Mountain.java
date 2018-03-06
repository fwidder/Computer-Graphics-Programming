package florianWidder.StudentID18999061.assignment1.objects;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class Mountain extends AbstractGraphicObject {

	/**
	 * Saving pre calculated points
	 */
	private Point[][] points;

	/**
	 * Creates a random amount of Mountains.<br>
	 * The Mountains a represented by a
	 * {@link com.jogamp.opengl.GL2#GL_TRIANGLE_STRIP GL_TRIANGLE_STRIP}.
	 */
	public Mountain() {
		super();
		ArrayList<Point[]> points = new ArrayList<Point[]>();
		for (double i = -1.1; i <= 1.1; i = i + (Math.random() * 0.2)) {
			Point[] p = new Point[3];
			p[0] = new Point((float) ((float) i - (0.1 + Math.random() * 0.2)), -1);
			p[1] = new Point((float) i, (float) ((Math.random() * -1) * 0.5));
			p[2] = new Point((float) ((float) i + (0.1 + Math.random() * 0.4)), -1);
			points.add(p);
		}
		this.points = points.toArray(new Point[0][0]);
	}

	@Override
	@Deprecated
	public void calculate() {
		// Nothing to calculate
	}

	@Override
	protected void realDraw(GL2 gl) {
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		for (int i = 0; i < points.length; i++) {
			gl.glColor3f(0.3f, 0.3f, 0.3f);
			gl.glVertex2f(points[i][0].getX(), points[i][0].getY());
			gl.glColor3f(1, 1, 1);
			gl.glVertex2f(points[i][1].getX(), points[i][1].getY());
			gl.glColor3f(0.3f, 0.3f, 0.3f);
			gl.glVertex2f(points[i][2].getX(), points[i][2].getY());
		}
		gl.glEnd();
	}

	/**
	 * Color is Static calculated!
	 */
	@Deprecated
	public void setColor(float red, float green, float blue) {
		return;
	}

	/**
	 * Color is Static calculated!
	 */
	@Deprecated
	public void setColor(float red, float green, float blue, float transparency) {
		return;
	}

}
