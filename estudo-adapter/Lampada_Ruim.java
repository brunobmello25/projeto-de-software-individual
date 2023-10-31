public class Main {
  public static void main(String[] args) {
    SimpleLamp lamp = new SimpleLamp();
    lamp.turnOn();
    lamp.turnOff();
  }
}

// Sistema antigo
class SimpleLamp {
  private boolean isOn = false;

  public void turnOn() {
    isOn = true;
    System.out.println("Lamp is ON");
  }

  public void turnOff() {
    isOn = false;
    System.out.println("Lamp is OFF");
  }
}
