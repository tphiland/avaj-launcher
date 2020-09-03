package root;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public ArrayList<String> initialise(String filname) throws MyException {
        ArrayList<String> scenario = new ArrayList<>();

        try {
            File file = new File(filname);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!data.isBlank())
                    scenario.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new MyException("File not found");
        }
        try {
            int i = Integer.parseInt(scenario.get(0));
            if (i <= 0)
                throw new MyException("First arg must be a positive number");
        } catch (NumberFormatException e) {
            throw new MyException("First arg must be a positive number");
        }

        for (int i = 1; i < scenario.size(); i++) {
            String[] row = scenario.get(i).split(" ");
            if (row.length != 5)
                throw new MyException("Each row must have format: \"(type) (name) (long) (lat) (height)\"");
            if (!row[0].equals("Baloon") && !row[0].equals("JetPlane") && !row[0].equals("Helicopter")) {
                throw new MyException("Type must be Baloon/JetPlane/Helicopter");
            }
            try {
                int a = Integer.parseInt(row[2]);
                int b = Integer.parseInt(row[3]);
                int c = Integer.parseInt(row[4]);
                if (a <= 0 || b <= 0 || c <= 0)
                    throw new MyException("Coordinates must be positive numbers");
            } catch (NumberFormatException e) {
                throw new MyException("Coordinates must be positive numbers");
            }
        }

        return scenario;
    }

}

