package factorydesign;
//Create concrete classes implementing the same interface.
import factorydesign.Attendance;
import observerdesign.ViewAccountsObserver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAttendance implements Attendance{
   public void viewEnterAttendance() {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("AttendanceData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
            Logger.getLogger(ViewAccountsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<lines.size();i++){
        System.out.println("Full Name: "+lines.get(i));
        System.out.println("Role: "+lines.get(i+1));
        System.out.println("This Months Attendance: "+lines.get(i+2));
        i=i+2;
        System.out.println("\n");
        }
   }    
}
