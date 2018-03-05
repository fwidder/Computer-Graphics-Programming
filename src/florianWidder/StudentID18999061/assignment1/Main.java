package florianWidder.StudentID18999061.assignment1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

import florianWidder.StudentID18999061.assignment1.objects.GraphicObject;
import florianWidder.StudentID18999061.assignment1.objects.Mountain;
import florianWidder.StudentID18999061.assignment1.objects.Plane;
import florianWidder.StudentID18999061.assignment1.objects.Stars;
import florianWidder.StudentID18999061.assignment1.objects.StaticGroundLayers;
import florianWidder.StudentID18999061.assignment1.objects.Tree;

/**
 * Main Class to start the Assignment 1 Project
 * 
 * Original by Jacqueline Whalley
 * Modified by Florian Widder
 * 
 * @author Florian Widder
 * @author Student ID 18999061
 *
 */
public class Main implements GLEventListener {

	private GraphicObject stars;
	private GraphicObject[] trees;
	private GraphicObject[] planes;
	private GraphicObject mountain;
	private GraphicObject staticGroundLayers;

	public Main() {
		// Create Components
		stars = new Stars(250);
		trees = new Tree[3];
		trees[0] = new Tree(-0.6f);
		trees[1] = new Tree(0f);
		trees[2] = new Tree(0.6f);
		planes = new Plane[2];
		planes[0] = new Plane(0.3f);
		planes[0].setDx(0.2f);
		planes[1] = new Plane(0.5f);
		planes[1].setDx(0.35f);
		mountain = new Mountain();
		staticGroundLayers = new StaticGroundLayers();
	}

	private static int winWidth = 1280;
	private static int winHeight = 1020;

	public static void main(String[] args) {
		Frame frame = new Frame("Assignment 1 - 2D Animation: Planet Earth 2.0");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(capabilities);
		Main simple = new Main();
		canvas.addGLEventListener(simple);
		frame.add(canvas);
		frame.setSize(winWidth, winHeight);
		final Animator animator = new Animator(canvas);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Thread(new Runnable() {

					public void run() {
						animator.stop();
						System.exit(0);
					}
				}).start();
			}
		});
		animator.start();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas.requestFocusInWindow();

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		// Clear screen
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		// Calculate updates
		for (GraphicObject plane : planes)
			plane.calculate();
		// Redraw
		stars.draw(gl);
		mountain.draw(gl);
		for (GraphicObject tree : trees)
			tree.draw(gl);
		staticGroundLayers.draw(gl);
		for (GraphicObject plane : planes)
			plane.draw(gl);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	}
}
