/**
 * 
 */
package florianWidder.StudentID18999061.assignment1.objects;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class ButtonBar extends AbstractGraphicObject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * florianWidder.StudentID18999061.assignment1.objects.AbstractGraphicObject#realDraw(
	 * com.jogamp.opengl.GL2)
	 */
	@Override
	protected void realDraw(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(color[0], color[1], color[2]);

		gl.glVertex2f(-1, 1);
		gl.glVertex2f(1, 1);
		gl.glVertex2f(1, 0.93f);
		gl.glVertex2f(-1, 0.93f);

		gl.glEnd();

		gl.glFlush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * florianWidder.StudentID18999061.assignment1.objects.AbstractGraphicObject#calculate()
	 */
	@Override
	@Deprecated
	public void calculate() {
		// Noting to calculate here
	}

}
