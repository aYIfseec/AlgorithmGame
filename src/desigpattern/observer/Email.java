package desigpattern.observer;

public class Email implements NotifyObserve {

    @Override
    public boolean sendMsg() {
        System.out.println("send email");
        return true;
    }

}
