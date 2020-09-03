package root;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();
	private boolean landed = false;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		Main.writeTofile += String.format("Tower says: Helicopter#%s(%s) registered to weather tower.\n", name, id);
	}

	public void updateConditions() {
		if (!landed) {
			String weather = weatherTower.getWeather(coordinates);

			if (weather.equals("SUN")) {
				coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
				if (coordinates.getHeight() > 100)
					coordinates.setHeight(100);
				Main.writeTofile += String.format("Helicopter#%s(%s): SUNwhere over the rainbow\n", name, id);
			} else if (weather.equals("RAIN")) {
				coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
				Main.writeTofile += String.format("Helicopter#%s(%s): Caaandy Coated Raaain!\n", name, id);
			} else if (weather.equals("FOG")) {
				coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
				Main.writeTofile += String.format("Helicopter#%s(%s): This Fog tho\n", name, id);
			} else if (weather.equals("SNOW")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
				Main.writeTofile += String.format("Helicopter#%s(%s): Snow: Informer\n", name, id);
				if (coordinates.getHeight() <= 0) {
					Main.writeTofile += String.format("Helicopter#%s(%s): Landing at %s\n", name, id, coordinates.toString());
					Main.writeTofile += String.format("Tower says: Helicopter#%s(%s) unregistered from weather tower.\n", name, id);
					landed = true;
				}
			}
		}
	}

	public void registerTower(WeatherTower WeatherTower) {
	}

}
