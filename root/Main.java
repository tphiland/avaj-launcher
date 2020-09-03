package root;

import java.util.ArrayList;

public class Main {
    public static String writeTofile = "";

    public static void main(String[] args) throws MyException {
        if (args[0] == null)
		throw new MyException("please parse an argument");
        ArrayList<String> scenario = new ReadFile().initialise(args[0]);
        Tower tower = new Tower();
        int simAmount = Integer.parseInt(scenario.get(0));

        for (int i = 1; i <= scenario.size() - 1; i++) {
            String[] a = scenario.get(i).split(" ");
            tower.register(new AircraftFactory().newAircraft(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4])));
        }
        for (int i = 0; i < simAmount; i++) {
            tower.conditionsChanged();
        }
        new WriteToFile().writeToFile();
    }
}
