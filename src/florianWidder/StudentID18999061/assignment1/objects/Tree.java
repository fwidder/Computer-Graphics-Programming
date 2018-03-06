package florianWidder.StudentID18999061.assignment1.objects;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class Tree extends AbstractGraphicObject {
	/**
	 * Creates a Tree at the passed x position.
	 * 
	 * @param x
	 *            the x position for the Tree
	 */
	public Tree(float x) {
		super(new Point(x, 0));
	}

	@Override
	protected void realDraw(GL2 gl) {
		// Treetrunk
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.25f, 0.1f);

		gl.glVertex2f(position.getX(), -1);
		gl.glVertex2f(position.getX() + 0.02f, -0.5f);
		gl.glVertex2f(position.getX() + 0.08f, -0.5f);
		gl.glVertex2f(position.getX() + 0.1f, -1f);

		gl.glEnd();

		// Left Tree Leaves
		gl.glColor3f(0.2f, 0.95f, 0.2f);
		drawCircle(gl, position.getX() + 0.05f, -0.5f, 0.1f,10);

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
