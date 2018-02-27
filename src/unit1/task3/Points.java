package unit1.task3;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Points implements GLEventListener {

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		// clear the drawing canvas
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPointSize(4);
		gl.glBegin(GL2.GL_POINTS);
		for (float x = -1; x <= 1; x = x + 0.04f)
			for (float y = -1; y <= 1; y = y + 0.04f) {
				gl.glVertex2f(x, y);
			}
		gl.glEnd();
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
