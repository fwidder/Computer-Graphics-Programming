package unit1.task1;

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
		for (int i = 0; i < 100; i++) {
			gl.glColor3f((float) Math.random(), (float) Math.random(), (float) Math.random());
			gl.glVertex2f((float) Math.random() * 2 - 1, (float) Math.random() * 2 - 1);
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
