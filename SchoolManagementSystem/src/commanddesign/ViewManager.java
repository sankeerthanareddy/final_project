package commanddesign;
//We have concrete command classes ViewManager implementing Order interface which will do actual command processing
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewManager implements Order {
    private Manager manager;

   public ViewManager(Manager manager){
      this.manager = manager;
   }

    public void execute() {
        try {
            manager.view();
        } catch (IOException ex) {
            Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    

