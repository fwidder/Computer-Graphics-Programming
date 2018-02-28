package assignment1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

import assignment1.objects.GraphicObject;
import assignment1.objects.Mountain;
import assignment1.objects.Plane;
import assignment1.objects.Stars;
import assignment1.objects.Static_Ground;
import assignment1.objects.Trees;

/**
 * 
 * @author Florian Widder
 *
 */
public class Main {

	public static void main(String[] args) {
		// Create frame
		JFrame frame = new JFrame("Assignment 1- 2D Animation: Planet xxx");
		// Set openGL settings
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		// Create a simple canvas for drawing
		GLCanvas canvas = new GLCanvas(capabilities);
		// Create Components
		Stars stars = new Stars();
		Trees trees = new Trees();
		Plane plane = new Plane();
		Mountain mountain = new Mountain();
		Static_Ground static_Ground = new Static_Ground();
		// Add Components to canvas
		canvas.addGLEventListener(stars);
		canvas.addGLEventListener(mountain);
		canvas.addGLEventListener(trees);
		canvas.addGLEventListener(static_Ground);
		canvas.addGLEventListener(plane);
		// Add Components to HashMap
		HashMap<String, GraphicObject> Graphics = new HashMap<String, GraphicObject>();
		Graphics.put("stars", stars);
		Graphics.put("plane", plane);
		Graphics.put("tree1", trees);
		Graphics.put("mountain", mountain);
		Graphics.put("static_ground", static_Ground);
		new Controller(Graphics);
		// Add canvas to frame
		frame.add(canvas);
		// Create Animator for canvas
		final Animator animator = new Animator(canvas);
		// Set frame settings
		frame.setLocation(0, 0);
		frame.setSize(1280, 1024);
		frame.setVisible(true);
		// Start Animator
		animator.start();
		// Set focus of frame to canvas
		canvas.requestFocusInWindow();

		// Make window close kill the app
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
	}
}
