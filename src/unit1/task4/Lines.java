package unit1.task4;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Lines implements GLEventListener {

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		// clear the drawing canvas
		// Draw vertical lines
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		for (float x = -1; x <= 1; x = x + 0.2f) {
			gl.glBegin(GL2.GL_LINES);
			gl.glVertex2f(x, -1);
			gl.glVertex2f(x, 1);
			gl.glEnd();
			gl.glBegin(GL2.GL_LINES);
			gl.glVertex2f(-1, x);
			gl.glVertex2f(1, x);
			gl.glEnd();
		}
		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

}
