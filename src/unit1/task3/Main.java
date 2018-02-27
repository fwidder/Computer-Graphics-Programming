package unit1.task3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame("Unit 1.3");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(capabilities);
		Points Pts = new Points();
		canvas.addGLEventListener(Pts);
		frame.add(canvas);
		frame.setSize(640, 480);

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

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas.requestFocusInWindow();
	}

}
