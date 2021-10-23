package commanddesign;
//We have concrete command classes EnterManager implementing Order interface which will do actual command processing

import commanddesign.Manager;

public class EnterManager implements Order {
    private Manager manager;

   public EnterManager(Manager manager){
      this.manager = manager;
   }

   public void execute() {
      manager.enter();
   }
}    

