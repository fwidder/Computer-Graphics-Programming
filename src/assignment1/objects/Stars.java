package assignment1.objects;

import com.jogamp.opengl.GL2;

public class Stars extends GraphicObject {

	protected Point[] stars;
	protected int[] size;

	public Stars(int count) {
		stars = new Point[count];
		size = new int[count];
		color = new float[count];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Point((float) (Math.random() * 2) - 1, (float) (Math.random() * 2) - 1);
			size[i] = (int) (1.0 + (Math.random() * 3));
			color[i] = (float) (0.8 + Math.random() * 0.2);
		}
	}

	@Override
	protected void realDraw(GL2 gl) {
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
	public void calculate() {
		// Nothing to calculate
	}

	/**
	 * Color is Static calculated!
	 */
	public void setColor(float red, float green, float blue) {
		return;
	}

	/**
	 * Color is Static calculated!
	 */
	public void setColor(float red, float green, float blue, float transparency) {
		return;
	}

}
