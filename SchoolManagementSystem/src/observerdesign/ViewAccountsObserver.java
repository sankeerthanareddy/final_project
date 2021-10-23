package observerdesign;
//Create concrete observer classes
import observerdesign.Accounts;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAccountsObserver extends AccountsObserver {
    public ViewAccountsObserver(Accounts accounts){
        this.accounts = accounts;
        this.accounts.attach(this);
    }

    @Override
    public void update() {
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("AccountsData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewAccountsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("Full Name: "+lines.get(i));
        System.out.println("Role: "+lines.get(i+1));
        System.out.println("Salary/Fees: "+lines.get(i+2));
        i=i+2;
        System.out.println("\n");
        }
    }
    
}
