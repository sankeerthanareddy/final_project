package commanddesign;
//Manager uses command pattern to identify which object will execute which command based on the type of command
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
      public void view() throws IOException {
       ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("ManagerData.txt"))); // Handle a potential exception
       for(int i = 0; i<lines.size();i++){
       System.out.println("Staff/Teacher      Name: "+lines.get(i));
       System.out.println("Staff/Teacher      Duty: "+lines.get(i+1));
       System.out.println("Staff/Teacher Duty Time: "+lines.get(i+2));
       i=i+2;
       System.out.println("\n");
       }
   }
    
    public void enter(){
        try
        {
            Scanner sc=new Scanner(System.in);                //object of Scanner class  
            String name= "ManagerData.txt";                   //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode  

            System.out.print("Enter Staff/Teacher Name: ");         
            String staffTeacher=sc.nextLine()+"\n";           //str stores the string which we have entered  
            byte[] st = staffTeacher.getBytes();              //converts string into bytes  
            fos.write(st);  

            System.out.print("Enter Staff/Teacher Duty: ");
            String duty=sc.nextLine()+"\n";                   //str stores the string which we have entered  
            byte[] d = duty.getBytes();                       //converts string into bytes  
            fos.write(d); 

            System.out.print("Enter Staff/Teacher Duty Time (HH:MM): ");
            String dutyTime=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] dT = dutyTime.getBytes();                  //converts string into bytes  
            fos.write(dT);                                    
            
            fos.close();                                      //close the file  
            System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
  
}
  
  



