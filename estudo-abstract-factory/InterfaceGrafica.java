interface Button {
  void render();
}

interface TextBox {
  void displayText();
}

class WindowsButton implements Button {
  @Override
  public void render() {
    System.out.println("Renderizando botão no estilo Windows");
  }
}

class WindowsTextBox implements TextBox {
  @Override
  public void displayText() {
    System.out.println("Exibindo texto no estilo Windows");
  }
}

class LinuxButton implements Button {
  @Override
  public void render() {
    System.out.println("Renderizando botão no estilo Linux");
  }
}

class LinuxTextBox implements TextBox {
  @Override
  public void displayText() {
    System.out.println("Exibindo texto no estilo Linux");
  }
}

abstract class GUIFactory {
  abstract Button criaButton();

  abstract TextBox criaTextBox();
}

class WindowsGUIFactory extends GUIFactory {
  Button criaButton() {
    return new WindowsButton();
  }

  TextBox criaTextBox() {
    return new WindowsTextBox();
  }
}

class LinuxGUIFactory extends GUIFactory {
  Button criaButton() {
    return new LinuxButton();
  }

  TextBox criaTextBox() {
    return new LinuxTextBox();
  }
}

// Interfaces e classes concretas mantêm-se inalteradas...

public class InterfaceGrafica {
  private Button button;
  private TextBox textBox;

  public InterfaceGrafica(Button button, TextBox textBox) {
    this.button = button;
    this.textBox = textBox;
  }

  public void renderGUI() {
    button.render();
    textBox.displayText();
  }

  public static void main(String[] args) {
    Button button;
    TextBox textBox;
    InterfaceGrafica app;

    String osType = "Windows"; // Você pode alterar esta variável para testar diferentes sistemas operacionais

    GUIFactory guiFactory;

    if ("windows".equalsIgnoreCase(osType)) {
      guiFactory = new WindowsGUIFactory();
    } else if ("linux".equalsIgnoreCase(osType)) {
      guiFactory = new LinuxGUIFactory();
    } else {
      System.out.println("Tipo de sistema operacional não suportado");
      return;
    }

    button = guiFactory.criaButton();
    textBox = guiFactory.criaTextBox();

    app = new InterfaceGrafica(button, textBox);
    app.renderGUI();
  }
}

