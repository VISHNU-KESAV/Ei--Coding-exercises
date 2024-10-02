interface TV {
    void on();
    void off();
}

class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is OFF");
    }
}

class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV is OFF");
    }
}

abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void turnOn();
    abstract void turnOff();
}

class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    void turnOn() {
        tv.on();
    }
    @Override
    void turnOff() {
        tv.off();
    }
}
public class Main {
    public static void main(String[] args) {
        TV sonyTV = new SonyTV();
        RemoteControl sonyRemote = new AdvancedRemoteControl(sonyTV);
        sonyRemote.turnOn();
        sonyRemote.turnOff();
    }
}
