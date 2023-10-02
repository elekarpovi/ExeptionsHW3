import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterPerson {
    public static void write(Person person) {
        File file = new File(person.surname + ".txt");

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(person.toString());
            System.out.println("The information was saved to a file.");
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }

}
