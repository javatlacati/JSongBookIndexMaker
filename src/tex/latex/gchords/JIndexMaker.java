/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tex.latex.gchords;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrador
 */
public class JIndexMaker {

    public static void main(String[] args) {
        System.out.println("Welcome to JIndexMaker this app was designed to work with the Songbook latex package");
        System.out.println("Usage: Select the file on the GUI, and this app will process it automatically according to the file extension");
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Index Preprocessed files", "aIdx", "tIdx", "kIdx");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            String filename = chooser.getSelectedFile().getName();
            int extensionIndex = filename.lastIndexOf(".");
            String filenamewoextension = filename.substring(0, extensionIndex );
            System.out.println("You chose to open this file: "
                    + filename);
            String extension = filename.substring(extensionIndex+1);
            System.out.println("The file has extension:" + extension);
            System.out.println("Su archivo se llama:"+filenamewoextension);
            String comando = "";
            switch (extension) {
                case "aIdx":
                    try {
                        System.out.println("Processing author index preprocessed file");
                        comando="makeindex -s songbook.ist -o " + filenamewoextension + ".adx " + filename;
                        System.out.println("Ejecutando:"+comando);
                        Runtime.getRuntime().exec(comando);
                    } catch (IOException ex) {
                        System.err.println("Erro executing due to " + ex.getMessage());
                    }
                    break;
                case "tIdx":
                    try {
                        System.out.println("Processing title index preprocessed file");
                        comando="makeindex -s songbook.ist -o " + filenamewoextension + ".tdx " + filename;
                        System.out.println("Ejecutando:"+comando);
                        Runtime.getRuntime().exec(comando);
                    } catch (IOException ex) {
                        System.err.println("Erro executing due to " + ex.getMessage());
                    }
                    break;
                    case "kIdx":
                    try {
                        System.out.println("Processing key index preprocessed file");
                        comando="makeindex -s songbook.ist -o " + filenamewoextension + ".kdx " + filename;
                        System.out.println("Ejecutando:"+comando);
                        Runtime.getRuntime().exec(comando);
                    } catch (IOException ex) {
                        System.err.println("Erro executing due to " + ex.getMessage());
                    }
                    break;
                default:
                    System.err.println("Invalid file type! O.o");
                    break;
            }
        } else {
            System.err.println("User cancelled");
        }
    }
}
