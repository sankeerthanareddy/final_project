package statedesign;
//Creating concrete classes implementing the same interface.
import statedesign.Context;
import observerdesign.ViewAccountsObserver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewState implements State {

   public void doAction(Context context) {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("HRData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
            Logger.getLogger(ViewAccountsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("Full Name: "+lines.get(i));
        System.out.println("Role: "+lines.get(i+1));
        System.out.println("Address: "+lines.get(i+2));
        i=i+2;
        System.out.println("\n");
        }
      context.setState(this);	
   }

   public String toString(){
      return "View HR Data State";
   }
}
