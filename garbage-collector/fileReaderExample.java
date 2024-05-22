import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReaderExample {

  /**
   *
   * Not Closing Resources effectively might lead to memory leaks
   **/
  public static void readFile() {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("read.txt"));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   *
   * Using this ensures that your files are resources are closed at the end of the
   * statement
   **/
  public static void readFileSafely() {
    try (BufferedReader reader = new BufferedReader(new FileReader("readsafe.txt"))) {

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // readFile();
    readFileSafely();
  }
}
