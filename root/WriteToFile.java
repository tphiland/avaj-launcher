package root;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt");
            myWriter.write(Main.writeTofile);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

