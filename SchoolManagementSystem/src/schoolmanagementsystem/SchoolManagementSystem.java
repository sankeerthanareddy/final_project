package schoolmanagementsystem;

import statedesign.ViewState;
import statedesign.EnterState;
import statedesign.Context;
import factorydesign.AttendanceFactory;
import factorydesign.Attendance;
import observerdesign.ViewAccountsObserver;
import observerdesign.EnterAccountsObserver;
import observerdesign.Accounts;
import commanddesign.EnterManager;
import commanddesign.ManagerInvoker;
import commanddesign.Manager;
import commanddesign.ViewManager;
import java.io.IOException;

public class SchoolManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int swValue;
        int ManagerValue;
        int AccountsValue;
        int AttendanceValue;
        int hrValue;
        int choice;
        while(true){
            // Displaying menu graphics
            System.out.println("=============================");
            System.out.println("|| SCHOOL MANAGEMENT SYSTEM ||");
            System.out.println("=============================");
            System.out.println("|| Options:                 ||");
            System.out.println("||        1. MANAGER        ||");
            System.out.println("||        2. ACCOUNTES      ||");
            System.out.println("||        3. ATTENDANCE     ||");
            System.out.println("||        4. HUMAN RESOURCE ||");
            System.out.println("||        5. Exit           ||");
            System.out.println("============================");
            swValue = Keyin.inInt(" Select option: ");
            System.out.println("\n");
            
            switch (swValue) {
//CASE 1 IS MANAGERIAL ROLE USING COMMAND DESIGN PATTERN   
//In this command design pattern we are encapsulating  a request as an object,
//which lets us parameterize other objects with different requests and support undoable operations.
//We have created an interface Order.java which is acting as a command                
//will use Manager class to demonstrate command pattern.                
                case 1:
                    System.out.println("||Enter 1 to View Staff/Teacher Schedule   ||");
                    System.out.println("||Enter 2 to Assign Staff/Teacher Schedule ||");
                    ManagerValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    if(ManagerValue==1){
//Create a command interface.                        
                        Manager man = new Manager();                        
//Create a request class.                        
                        ViewManager viewManagerOrder = new ViewManager(man);
//Creating a command invoker class.                         
                        ManagerInvoker managerInvoker = new ManagerInvoker();
                      
                        managerInvoker.takeOrder(viewManagerOrder);
                        managerInvoker.placeOrders();
                    }
                    else if(ManagerValue==2){
//Create a command interface.
                        Manager man = new Manager();
//Create a request class.                        
                        EnterManager enterManagerOrder = new EnterManager(man);
//Creating a command invoker class.                      
                        ManagerInvoker managerInvoker = new ManagerInvoker();
                      
                        managerInvoker.takeOrder(enterManagerOrder);
                        managerInvoker.placeOrders();
                        break;
                    }
                    break;

//CASE 2 IS ACCOUNTS ROLE USING OBSERVER DESIGN PATTERN 
//Observer pattern uses three actor classes. Accounts, Observer and Client                    
                case 2:
                    System.out.println("||Enter 1 to View Accounts Details   ||");
                    System.out.println("||Enter 2 to Enter Accounts Details  ||");
                    AccountsValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    Accounts accounts = new Accounts();
                    
                    if(AccountsValue==1){
//Using ViewAccountObserver and concrete observer objects.
                        new ViewAccountsObserver(accounts);
//Accounts is an object having methods to attach and detach observers to a client object                        
                        accounts.setState(1);
                    }
                     else if(AccountsValue==2){
//Using ViewAccountObserver and concrete observer objects.                         
                        new EnterAccountsObserver(accounts);
//Accounts is an object having methods to attach and detach observers to a client object                        
                        accounts.setState(1);
                        break;
                    }
                    
                    break;
                    
//CASE 3 IS ATTENDANCE USING FACTORY DESIGN PATTERN
//We will use AttendaceFactory to get a object. It will pass information (viewAttendance,enterAttendce) 
//to AttendanceFactory to get the type of object it needs.                    
                case 3:
                    System.out.println("||Enter 1 to View Attendance Details   ||");
                    System.out.println("||Enter 2 to Enter Attendance Details  ||");
                    AttendanceValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
//Using the AttendanceFactory to get object of concrete class by passing an information such as type.                    
                    AttendanceFactory attendanceFactory = new AttendanceFactory();

                    if(AttendanceValue==1){
//get an object of ViewAttendance and call its viewEnterAttendance method.
                        Attendance viewAttendance = attendanceFactory.getAttendance("viewAttendance");
                        viewAttendance.viewEnterAttendance();
                    }
                    else if(AttendanceValue==2){
//get an object of EnterAttendance and call its viewEnterAttendance method.
                        Attendance enterAttendance = attendanceFactory.getAttendance("enterAttendance");
                        enterAttendance.viewEnterAttendance();
                    }
                    
                    break;
                    
//CASE 4 IS HUMAN RESOURCE USING STATE DESIGN PATTERN                   
//In State Design Pattern, we have created objects which represent various states 
//And a context object whose behavior varies as its state object changes.                    
                case 4:
                     System.out.println("||Enter 1 to View HR Details   ||");
                    System.out.println("||Enter 2 to Enter HR Details  ||");
                    hrValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");

//Using the Context to see change in behaviour when State changes 
//Context is a class which carries a State
                    Context context = new Context();

                    if(hrValue==1){
//We are using Context and state objects to demonstrate change in Context 
//behavior based on type of state it is in.                        
                        ViewState viewState = new ViewState();
                        viewState.doAction(context);
                    }
                    else if(hrValue==2){   
                        EnterState enterState = new EnterState();
                        enterState.doAction(context);
                    }
                    break;
                    
//CASE 5 IS EXITING PROGRAM 
                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    
//CASE DEFAULT IS PRINTING OUT THE INVALID SELECTION BY THE USER
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary but its a formality
    }
   
    }
  }




// keyin methos is for input of character and numeric types only in main menu

class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  //********************************
  //  data input methods for
  //string, int, char, and double
  //********************************
  public static String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public static double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}
        
    }
    

