/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.backend;
import employeemanage.userGUI;
/**
 *
 * @author Rubs
 */
public class employee {
    private String id;
    private String name;
    private String salary;
    private String balance;
    private String DaT;
    
    public employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public employee(String id, String name, String salary, String balance, String DaT) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.balance = balance;
        this.DaT = DaT;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public String getID() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    public String getBalance() {
        return balance;
    }
    
    public void setDaT(String DaT) {
        this.DaT = DaT;
    }
    
    public String getDaT() {
        return DaT;
    }
}
