package root;

import java.util.LinkedList;

public class Tower {
	private LinkedList<Flyable> observers = new LinkedList<>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}

}
