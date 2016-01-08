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
 * @author Javatlacati
 */
public class JIndexMaker {

    public static void main(final String[] args) {
        System.out.println(org.openide.util.NbBundle.getBundle(JIndexMaker.class).getString("WELCOME"));
        System.out.println(org.openide.util.NbBundle.getBundle(JIndexMaker.class).getString("USAGE"));
        final JFileChooser chooser = new JFileChooser();
        final FileNameExtensionFilter filter = new FileNameExtensionFilter(
                org.openide.util.NbBundle.getBundle(JIndexMaker.class).getString("INDEXPREPROCESSEDFILES"), "aIdx", "tIdx", "kIdx"); //NOI18N
        chooser.setFileFilter(filter);
        final int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final String filename = chooser.getSelectedFile().getName();
            final int extensionIndex = filename.lastIndexOf("."); //NOI18N
            String filenamewoextension = filename.substring(0, extensionIndex);
            System.out.println(org.openide.util.NbBundle.getBundle(JIndexMaker.class).getString("YOUCHOSE")
                    + filename);
            String extension = filename.substring(extensionIndex + 1);
            System.out.println("The file has extension:" + extension);
            System.out.println("Su archivo se llama:" + filenamewoextension);
            String comando = "";
            switch (extension) {
                case "aIdx":
                    try {
                        System.out.println("Processing author index preprocessed file");
                        comando = "makeindex -s songbook.ist -o " + filenamewoextension + ".adx " + filename;
                        System.out.println("Ejecutando:" + comando);
                        Runtime.getRuntime().exec(comando);
                    } catch (IOException ex) {
                        System.err.println("Erro executing due to " + ex.getMessage());
                    }
                    break;
                case "tIdx":
                    try {
                        System.out.println("Processing title index preprocessed file");
                        comando = "makeindex -s songbook.ist -o " + filenamewoextension + ".tdx " + filename;
                        System.out.println("Ejecutando:" + comando);
                        Runtime.getRuntime().exec(comando);
                    } catch (IOException ex) {
                        System.err.println("Erro executing due to " + ex.getMessage());
                    }
                    break;
                case "kIdx":
                    try {
                        System.out.println("Processing key index preprocessed file");
                        comando = "makeindex -s songbook.ist -o " + filenamewoextension + ".kdx " + filename;
                        System.out.println("Ejecutando:" + comando);
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
