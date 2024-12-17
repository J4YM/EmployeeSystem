package employee.backend;


public class creds {
    private String username;
    private String pass;
    
    public creds(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
    
    void setUser(String user) {
        this.username = user;
    
    }
    
    public String getUser() {
        return username;
    }
    
    void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getPass() {
        return pass;
    }
}
