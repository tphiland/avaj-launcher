package root;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();
	private boolean landed = false;

	JetPlane(String name, Coordinates coordinates)  {
		super(name, coordinates);
		Main.writeTofile += String.format("Tower says: JetPlane#%s(%s) registered to weather tower.\n", name, id);
	}

	public void updateConditions() {
		if (!landed) {
			String weather = weatherTower.getWeather(coordinates);

			if (weather.equals("SUN")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
				if (coordinates.getHeight() > 100)
					coordinates.setHeight(100);
				Main.writeTofile += String.format("JetPlane#%s(%s): It's getting hot in here!\n", name, id);
			} else if (weather.equals("RAIN")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
				Main.writeTofile += String.format("JetPlane#%s(%s): Mr Rainman, can we have a rainy day?\n", name, id);
			} else if (weather.equals("FOG")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
				Main.writeTofile += String.format("JetPlane#%s(%s): Too much FOG\n", name, id);
			} else if (weather.equals("SNOW")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
				Main.writeTofile += String.format("JetPlane#%s(%s): I'm about to freezze!\n", name, id);
				if (coordinates.getHeight() <= 0) {
					Main.writeTofile += String.format("JetPlane#%s(%s): Landing at %s\n", name, id, coordinates.toString());
					Main.writeTofile += String.format("Tower says: JetPlane#%s(%s) unregistered from weather tower.\n", name, id);
					landed = true;
				}
			}
		}
	}

	public void registerTower(WeatherTower WeatherTower) {
	}

}