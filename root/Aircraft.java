package root;

public class Aircraft {

	protected long 	id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);
	}

	private long nextId() {
		return idCounter++;
	}

}
//done
