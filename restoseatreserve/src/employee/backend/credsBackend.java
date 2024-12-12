package employee.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author james
 */
public class credsBackend {
    public List<employee> getAll() {
        List<employee> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("DATABASE/reservedatabase.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                employee item = new employee(itemInfo[0], itemInfo[1],
                        itemInfo[2], itemInfo[3], itemInfo[4]);

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
    public synchronized boolean checkCreds(String name, String pass) {
        List<employee> itemList = getAll();
        int indexToBeDeleted = -1;
        // find the cred to log in
        for (int i = 0; i < itemList.size(); i++) {
            try (Scanner scanner = new Scanner(new FileInputStream("DATABASE/reservedatabase.txt"))) {
                while (scanner.hasNextLine()) {
                    String itemLine = scanner.nextLine();

                    String itemInfo[] = itemLine.split(",");
                    employee item = new employee(itemInfo[0], itemInfo[1],
                        itemInfo[2], itemInfo[3], itemInfo[4]);
                
                    if (item.getName().equals(name) && item.getID().equals(pass)) {
                        return true;
                    }
                }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }
        }    
        
        if (indexToBeDeleted == -1) {
            return false;
        }
        return true;
        
    }
}
