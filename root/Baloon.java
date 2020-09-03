package root;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();
	private boolean landed = false;

	Baloon(String name, Coordinates coordinates)  {
		super(name, coordinates);
		Main.writeTofile += String.format("Tower says: Baloon#%s(%s) registered to weather tower.\n", name, id);
	}

	public void updateConditions() {
		if (!landed) {
			String weather = weatherTower.getWeather(coordinates);

			if (weather.equals("SUN")) {
				coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				if (coordinates.getHeight() > 100)
					coordinates.setHeight(100);
				Main.writeTofile += String.format("Baloon#%s(%s): Damn, sun\n", name, id);
			} else if (weather.equals("RAIN")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Main.writeTofile += String.format("Baloon#%s(%s): Can you stop the Rain?\n", name, id);
				if (coordinates.getHeight() <= 0) {
					Main.writeTofile += String.format("Baloon#%s(%s): Landing at %s\n", name, id, coordinates.toString());
					Main.writeTofile += String.format("Tower says: Baloon#%s(%s) unregistered from weather tower.\n", name, id);
					landed = true;
				}
			} else if (weather.equals("FOG")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				Main.writeTofile += String.format("Baloon#%s(%s): Fog you, weather\n", name, id);
				if (coordinates.getHeight() <= 0) {
					Main.writeTofile += String.format("Baloon#%s(%s): Landing at %s\n", name, id, coordinates.toString());
					Main.writeTofile += String.format("Tower says: Baloon#%s(%s) unregistered from weather tower.\n", name, id);
					landed = true;
				}
			} else if (weather.equals("SNOW")) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				Main.writeTofile += String.format("Baloon#%s(%s): Do you wanna be a snowman\n", name, id);
				if (coordinates.getHeight() <= 0) {
					Main.writeTofile += String.format("Baloon#%s(%s): Landing at %s\n", name, id, coordinates.toString());
					Main.writeTofile += String.format("Tower says: Baloon#%s(%s) unregistered from weather tower.\n", name, id);
					landed = true;
				}
			}
		}
	}

	public void registerTower(WeatherTower WeatherTower) {
	}

}