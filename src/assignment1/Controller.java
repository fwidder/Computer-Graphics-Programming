package assignment1;

import java.util.HashMap;

public class Controller {
	private HashMap<String, GraphicObject> Objects;

	public Controller(HashMap<String, GraphicObject> Objects) {
		this.Objects = Objects;
		init();
	}

	public void refresh() {
		//TODO Refresh everything
	}

	public void init() {
		Objects.get("plane").setMoving(false);
		//TODO Buttons init
	}

	public HashMap<String, GraphicObject> getObjects() {
		return Objects;
	}

}
