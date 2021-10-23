package factorydesign;
//Create concrete classes implementing the same interface.
import factorydesign.Attendance;
import java.io.FileOutputStream;
import java.util.Scanner;


public class EnterAttendance implements Attendance{
   public void viewEnterAttendance() {
      try{
            Scanner sc=new Scanner(System.in);                //object of Scanner class  
            String name= "AttendanceData.txt";                  //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode  

            System.out.print("Enter Full Name: ");         
            String fullName=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] fn = fullName.getBytes();                  //converts string into bytes  
            fos.write(fn);  
            
            System.out.print("Enter Role[Staff/Teacher/Student]): ");         
            String role=sc.nextLine()+"\n";                   //str stores the string which we have entered  
            byte[] r = role.getBytes();                       //converts string into bytes  
            fos.write(r); 

            System.out.print("Enter Staff/Teacher/Student This Months Attendance: ");
            String salaryfees=sc.nextLine()+"\n";             //str stores the string which we have entered  
            byte[] sf = salaryfees.getBytes();                //converts string into bytes  
            fos.write(sf);                                  
            
            fos.close();                                      //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }    
}
