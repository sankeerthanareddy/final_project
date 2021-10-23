package factorydesign;
//Creating a AttendanceFactory to generate object of concrete class based on given information.

import factorydesign.Attendance;

public class AttendanceFactory {
   //use getAttendance method to get object of manager 
   public Attendance getAttendance(String getAttendance){
       if(getAttendance == null){
           return null;
       }
       if(getAttendance.equalsIgnoreCase("viewAttendance")){
           return new ViewAttendance();
       }
       else if(getAttendance.equalsIgnoreCase("enterAttendance")){
           return new EnterAttendance();
       }
       return null;
   }    
}
