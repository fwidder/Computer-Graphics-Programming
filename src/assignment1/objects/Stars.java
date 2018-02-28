package assignment1.objects;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Stars extends GraphicObject {

	private Point[] stars;
	private int[] size;
	private float[] color;

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		for (int i = 0; i < size.length; i++) {
			gl.glPointSize(size[i]);
			gl.glColor3f(1f, color[i], 0f);
			gl.glBegin(GL2.GL_POINTS);
			gl.glVertex2f(stars[i].getX(), stars[i].getY());
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
		stars = new Point[150];
		size = new int[150];
		color = new float[150];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Point((float) (Math.random() * 2) - 1, (float) (Math.random() * 2) - 1);
			size[i] = (int) (1.0 + (Math.random() * 3));
			color[i] = (float) (0.8 + Math.random() * 0.2);
		}
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(float f) {
		// TODO Auto-generated method stub

	}

}
