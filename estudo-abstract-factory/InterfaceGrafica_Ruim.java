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

// Interfaces e classes concretas mantêm-se inalteradas...

class Application {
  private Button button;
  private TextBox textBox;

  public Application(Button button, TextBox textBox) {
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
    Application app;

    String osType = "Windows"; // Você pode alterar esta variável para testar diferentes sistemas operacionais

    if ("Windows".equalsIgnoreCase(osType)) {
      button = new WindowsButton();
      textBox = new WindowsTextBox();
      app = new Application(button, textBox);
      app.renderGUI();
    } else if ("Linux".equalsIgnoreCase(osType)) {
      button = new LinuxButton();
      textBox = new LinuxTextBox();
      app = new Application(button, textBox);
      app.renderGUI();
    } else {
      System.out.println("Tipo de sistema operacional não suportado");
    }
  }
}
