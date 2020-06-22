package desigpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class RegisterSubject {

    private List<NotifyObserve> notifyObserves;

    private boolean registerState;

    public RegisterSubject() {
        this.notifyObserves = new ArrayList<>();
    }

    public boolean register() {
        boolean registerState = true;
        registerNotify();
        return registerState;
    }

    public boolean attach(NotifyObserve notifyObserve) {
        return notifyObserves.add(notifyObserve);
    }

    public boolean remove(NotifyObserve notifyObserve) {
        return notifyObserves.remove(notifyObserve);
    }

    private void registerNotify() {
        for (NotifyObserve notifyObserve : notifyObserves) {
            notifyObserve.sendMsg();
        }
    }


    public static void main(String[] args) {
        RegisterSubject register = new RegisterSubject();
        register.attach(new Email());
        register.attach(new Sms());
        register.register();
    }

}
