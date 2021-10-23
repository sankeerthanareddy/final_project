package observerdesign;
//Creating Observer class named AccountsObserver.

import observerdesign.Accounts;


public abstract class AccountsObserver {
    protected Accounts accounts;
    public abstract void update();
}
