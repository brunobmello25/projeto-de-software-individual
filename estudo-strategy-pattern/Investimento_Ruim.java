class Conta {
  private double saldo;

  public Conta(double saldoInicial) {
    this.saldo = saldoInicial;
  }

  public void depositar(double valor) {
    saldo += valor;
  }

  public double getSaldo() {
    return saldo;
  }

  // Método para investir de forma conservadora: rendimento de 2%
  public void investirConservador() {
    this.saldo += this.saldo * 0.02;
  }

  // Método para investir de forma moderada: rendimento de 5%
  public void investirModerado() {
    this.saldo += this.saldo * 0.05;
  }

  // Método para investir de forma agressiva: rendimento de 10%
  public void investirAgressivo() {
    this.saldo += this.saldo * 0.10;
  }
}

class Main {
  public static void main(String[] args) {
    Conta conta = new Conta(1000.0);
    System.out.println("Saldo inicial: " + conta.getSaldo());

    conta.investirConservador();
    System.out.println("Saldo após investimento conservador: " + conta.getSaldo());

    conta.investirModerado();
    System.out.println("Saldo após investimento moderado: " + conta.getSaldo());

    conta.investirAgressivo();
    System.out.println("Saldo após investimento agressivo: " + conta.getSaldo());
  }
}
