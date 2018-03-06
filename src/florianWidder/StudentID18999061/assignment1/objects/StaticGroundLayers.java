package florianWidder.StudentID18999061.assignment1.objects;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class StaticGroundLayers extends AbstractGraphicObject {
	/**
	 * Creates two static Ground Layers.
	 */
	public StaticGroundLayers() {
		super();
	}

	@Override
	protected void realDraw(GL2 gl) {
		// Middle Layer
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(0f, 0.4f, 0f);

		gl.glVertex2f(-1, -1);
		gl.glVertex2f(1, -1);
		gl.glVertex2f(1, -0.7f);
		gl.glVertex2f(0.9f, -0.698f);
		gl.glVertex2f(0.8f, -0.695f);
		gl.glVertex2f(0.7f, -0.692f);
		gl.glVertex2f(0.6f, -0.69f);
		gl.glVertex2f(0.5f, -0.689f);
		gl.glVertex2f(0.4f, -0.688f);
		gl.glVertex2f(0f, -0.687f);
		gl.glVertex2f(-0.4f, -0.688f);
		gl.glVertex2f(-0.5f, -0.689f);
		gl.glVertex2f(-0.6f, -0.69f);
		gl.glVertex2f(-0.7f, -0.692f);
		gl.glVertex2f(-0.8f, -0.695f);
		gl.glVertex2f(-0.9f, -0.698f);
		gl.glVertex2f(-1, -0.7f);

		gl.glEnd();

		// Front Layer
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.3f, 0.1f);

		gl.glVertex2f(-1, -1);
		gl.glVertex2f(1, -1);
		gl.glVertex2f(1, -0.8f);
		gl.glVertex2f(-1, -0.8f);

		gl.glEnd();

		gl.glFlush();
	}

	@Override
	@Deprecated
	public void calculate() {
		// Nothing to calculate

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
