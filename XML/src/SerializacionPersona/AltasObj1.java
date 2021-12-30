package SerializacionPersona;

import Serializacion.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author mrnovoa
 */
public class AltasObj1 {

    public static void altas(File fichero) throws IOException {

        if (fichero.exists()) {

            String nombre = JOptionPane.showInputDialog("Escribe nombre");

            String apellido = JOptionPane.showInputDialog("Introduce su apellido");

            String codigo = JOptionPane.showInputDialog("Introduce el código de la zona");

            String telefono = JOptionPane.showInputDialog("Introduce el teléfono");

            String fax = JOptionPane.showInputDialog("Introduce el fax");

            int cod = Integer.parseInt(codigo);

            Person per = new Person();
            per.setFirstname(nombre);
            per.setLastname(apellido);
            per.setPhone(new PhoneNumber(cod, telefono));
            per.setFax(new PhoneNumber(cod, fax));

            if (fichero.length() == 0) {

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

                oos.writeObject(per);
                oos.close();

            } else {

                MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(fichero,true));

                moos.writeObject(per);
                moos.close();

            }
        } else {
            System.out.println("FICHERO INEXISTENTE");

        }
    }
}
