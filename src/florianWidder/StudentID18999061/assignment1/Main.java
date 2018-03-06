package florianWidder.StudentID18999061.assignment1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

import florianWidder.StudentID18999061.assignment1.objects.AbstractGraphicObject;
import florianWidder.StudentID18999061.assignment1.objects.Asteroid;
import florianWidder.StudentID18999061.assignment1.objects.Atmosphere;
import florianWidder.StudentID18999061.assignment1.objects.ButtonBar;
import florianWidder.StudentID18999061.assignment1.objects.DayNightCycle;
import florianWidder.StudentID18999061.assignment1.objects.Mountain;
import florianWidder.StudentID18999061.assignment1.objects.Plane;
import florianWidder.StudentID18999061.assignment1.objects.Stars;
import florianWidder.StudentID18999061.assignment1.objects.StaticGroundLayers;
import florianWidder.StudentID18999061.assignment1.objects.Tree;

/**
 * Main Class to start the Assignment 1 Project
 * 
 * Original by Jacqueline Whalley Modified by Florian Widder
 * 
 * @author Florian Widder
 * @author Student ID 18999061
 *
 */
public class Main implements GLEventListener {

	private static final int listGround = 1;
	private static final int listMountains = 2;
	private static final int listStars = 3;
	private static final int listTrees = 4;

	/**
	 * Number of {@link Asteroid Asteroids}
	 */
	private static final int numberOfAsteroids = 10;
	/**
	 * Number of {@link Plane Planes}
	 */
	private static final int numberOfPlanes = 2;

	/**
	 * Number of {@link Stars Stars}
	 */
	private static final int numberOfStars = 150;
	/**
	 * Number of {@link Tree Trees}
	 */
	private static final int numberOfTrees = 5;
	private static boolean preCompiled = false;
	private static final int winHeight = 800;
	private static final int winWidth = 1200;

	/**
	 * Startup Method. Creates a Window for openGL to draw in.
	 * 
	 * @param args
	 */
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
			@Override
			public void windowClosing(WindowEvent e) {
				new Thread(new Runnable() {

					@Override
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

	private final AbstractGraphicObject[] asteroids;
	private final AbstractGraphicObject atmosphere;

	private final AbstractGraphicObject buttonBar;
	private final AbstractGraphicObject dayNightCycle;
	private long lastDisplay = System.currentTimeMillis();
	private final AbstractGraphicObject mountain;

	private final AbstractGraphicObject[] planes;

	private final AbstractGraphicObject stars;

	private final AbstractGraphicObject staticGroundLayers;

	private final AbstractGraphicObject[] trees;

	/**
	 * STandart constructor initialing all needed objects
	 */
	public Main() {
		// Create Components
		stars = new Stars(numberOfStars);
		trees = new Tree[numberOfTrees];
		for (int i = 0; i < numberOfTrees; i++)
			trees[i] = new Tree((float) Math.random() * 2 - 1);
		planes = new Plane[numberOfPlanes];
		for (int i = 0; i < numberOfPlanes; i++) {
			planes[i] = new Plane((float) Math.random() - 0.13f);
			planes[i].setDx((float) (0.2 + Math.random() * 0.5));
		}
		mountain = new Mountain();
		staticGroundLayers = new StaticGroundLayers();
		asteroids = new Asteroid[numberOfAsteroids];
		for (int i = 0; i < numberOfAsteroids; i++) {
			asteroids[i] = new Asteroid((float) (0.05f + Math.random() * 0.02));
			asteroids[i].setDy((float) (0.5f + Math.random() * 0.5));
			asteroids[i].setColor(0.5f, 0.5f, 0.5f);
		}
		buttonBar = new ButtonBar();
		buttonBar.setColor(0.6f, 0.6f, 0.6f);
		atmosphere = new Atmosphere();
		atmosphere.setColor(0.53f, 0.81f, 0.98f, 0.6f);
		atmosphere.setVisible(false); // TODO Handle by Button
		dayNightCycle = new DayNightCycle(); // TODO Handle by Button
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		long now = System.currentTimeMillis();
		AbstractGraphicObject.increaseTime(now - lastDisplay);
		lastDisplay = now;
		GL2 gl = drawable.getGL().getGL2();
		// Pre compile if needed
		if (!preCompiled)
			preCompile(gl);
		// Clear screen
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		// Calculate updates
		for (AbstractGraphicObject plane : planes)
			plane.calculate();
		for (AbstractGraphicObject asteroid : asteroids)
			asteroid.calculate();
		dayNightCycle.calculate();
		// Redraw
		gl.glCallList(listStars);
		gl.glCallList(listMountains);
		for (AbstractGraphicObject asteroid : asteroids)
			asteroid.draw(gl);
		gl.glCallList(listTrees);
		gl.glCallList(listGround);
		for (AbstractGraphicObject plane : planes)
			plane.draw(gl);
		atmosphere.draw(gl);
		buttonBar.draw(gl);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
	}

	/**
	 * Pre compiles all static elements in the given GL2 element
	 * 
	 * @param gl
	 *            the GL2 element to draw in
	 */
	public void preCompile(GL2 gl) {
		preCompiled = true;
		// Per compile stars
		gl.glNewList(listStars, GL2.GL_COMPILE);
		stars.draw(gl);
		gl.glEndList();
		// Per compile trees
		gl.glNewList(listTrees, GL2.GL_COMPILE);
		for (AbstractGraphicObject tree : trees)
			tree.draw(gl);
		gl.glEndList();
		// Per compile mountains
		gl.glNewList(listMountains, GL2.GL_COMPILE);
		mountain.draw(gl);
		gl.glEndList();
		// Per compile ground
		gl.glNewList(listGround, GL2.GL_COMPILE);
		staticGroundLayers.draw(gl);
		gl.glEndList();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	}
}
