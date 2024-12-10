import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();


        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);


        int returnValue = fileChooser.showOpenDialog(null);


        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File selected: " + selectedFile.getAbsolutePath());

          
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file was selected.");
        }
    }
}
