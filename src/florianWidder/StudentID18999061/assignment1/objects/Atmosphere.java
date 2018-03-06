/**
 * 
 */
package florianWidder.StudentID18999061.assignment1.objects;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class Atmosphere extends AbstractGraphicObject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * florianWidder.StudentID18999061.assignment1.objects.AbstractGraphicObject#realDraw(
	 * com.jogamp.opengl.GL2)
	 */
	@Override
	protected void realDraw(GL2 gl) {
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glColor4d(color[0], color[1], color[2], color[3]);
		gl.glBegin(GL2.GL_QUADS);

		gl.glVertex2f(-1, 1);
		gl.glVertex2f(1, 1);

		gl.glColor4d(color[0], color[1], color[2], 0);

		gl.glVertex2f(1, -1);
		gl.glVertex2f(-1, -1);

		gl.glEnd();

		gl.glDisable(GL2.GL_BLEND);

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
		// Nothing to calculate here

	}

}
