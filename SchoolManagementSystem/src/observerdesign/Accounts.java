package observerdesign;
//Accounts is an object having methods to attach and detach observers to a client object
import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private List<AccountsObserver> accountsobservers = new ArrayList<AccountsObserver>();
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(AccountsObserver accountobserver){
        accountsobservers.add(accountobserver);
    }

    public void notifyAllObservers(){
        for (AccountsObserver accountsobserver : accountsobservers) {
        accountsobserver.update();
        }
    } 	
    
}
