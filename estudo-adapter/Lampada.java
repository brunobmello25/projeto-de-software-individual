
interface LampAdapter {
  public void turnOn();

  public void turnOff();
}

class SimpleLamp {
  private boolean isOn = false;

  public void turnOn() {
    isOn = true;
    System.out.println("Simple Lamp is ON");
  }

  public void turnOff() {
    isOn = false;
    System.out.println("Simple Lamp is OFF");
  }
}

class SmartLamp {
  private int brightness = 0;

  public void setBrightness(int level) {
    this.brightness = level;
    System.out.println("Smart Lamp brightness is " + brightness);
  }
}

class SimpleLampAdapter implements LampAdapter {
  private SimpleLamp lamp;

  public SimpleLampAdapter(SimpleLamp lamp) {
    this.lamp = lamp;
  }

  public void turnOn() {
    this.lamp.turnOn();
  }

  public void turnOff() {
    this.lamp.turnOff();
  }

}

class SmartLampAdapter implements LampAdapter {
  private SmartLamp lamp;

  public SmartLampAdapter(SmartLamp lamp) {
    this.lamp = lamp;
  }

  public void turnOn() {
    this.lamp.setBrightness(100);
  }

  public void turnOff() {
    this.lamp.setBrightness(0);
  }

}

class Main {
  public static void main(String[] args) {
    SimpleLamp simpleLamp = new SimpleLamp();
    SmartLamp smartLamp = new SmartLamp();

    LampAdapter lampAdapter = new SimpleLampAdapter(simpleLamp);

    blinkLamp(lampAdapter);

    lampAdapter = new SmartLampAdapter(smartLamp);

    blinkLamp(lampAdapter);
  }

  private static void blinkLamp(LampAdapter lampAdapter) {
    lampAdapter.turnOn();
    lampAdapter.turnOff();
  }
}
