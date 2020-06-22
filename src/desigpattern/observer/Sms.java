package desigpattern.observer;

public class Sms implements NotifyObserve {

    @Override
    public boolean sendMsg() {
        System.out.println("send sms");
        return true;
    }

}
