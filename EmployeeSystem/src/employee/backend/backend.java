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
 * @author
 */
public class backend {

    public backend() {
        
    }

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

    public employee getItemByIndex(int index) {
        List<employee> listOfItem = getAll();
        
        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }
        
        return null;
    }

    public void create(employee item) {//Writing Data
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt", true))) {
            pw.println(item.getID() + "," + item.getName() + "," + item.getSalary() + "," + item.getBalance() + "," + item.getDaT());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized boolean delete(String id) {

        List<employee> itemList = getAll();

        int indexToBeDeleted = -1;
        // find the item to be deleted
        for (int i = 0; i < itemList.size(); i++) {
            employee item = itemList.get(i);

            if (item.getID().equalsIgnoreCase(id)) {
                indexToBeDeleted = i;
            }
        }

        if (indexToBeDeleted == -1) {
            return false;
        }
        itemList.remove(indexToBeDeleted);
        
        try {
            // Delete the entire file
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Create a new file and write new data into the file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getID() + "," + item.getName() + "," + item.getSalary() + "," + item.getBalance() + "," + item.getDaT());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public synchronized boolean update(String srcName, employee updatedItem) {
        List<employee> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("DATABASE/reservedatabase.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                employee item = new employee(itemInfo[0], itemInfo[1],
                        itemInfo[2], itemInfo[3], itemInfo[4]);
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            employee item = itemList.get(i);

            if (item.getID().equalsIgnoreCase(srcName)) {
                itemIndexToUpdate = i;
            }
        }

        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getID() + "," + item.getName() + "," + item.getSalary() + "," + item.getBalance() + "," + item.getDaT());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public synchronized void reduceItemQuantityByItemName(String itemName, int reduceNumber) {
        List<employee> itemList = getAll();

        for (int i = 0; i < itemList.size(); i++) {

            employee item = itemList.get(i);

            if (item.getName().equalsIgnoreCase(itemName)) {
                itemList.set(i, item);
            }
        }

        try {
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getID() + "," + item.getName() + "," + item.getSalary() + "," + item.getBalance() + "," + item.getDaT());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(backend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

