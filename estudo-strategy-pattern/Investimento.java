interface Investimento {
  public double getSaldoAtualizado(double saldoAtual);
}

class InvestimentoConservador implements Investimento {
  public double getSaldoAtualizado(double saldoAtual) {
    return saldoAtual * 1.02;
  }
}

class InvestimentoModerado implements Investimento {
  public double getSaldoAtualizado(double saldoAtual) {
    return saldoAtual * 1.05;
  }
}

class InvestimentoAgressivo implements Investimento {
  public double getSaldoAtualizado(double saldoAtual) {
    return saldoAtual * 1.10;
  }
}

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

  public void investir(Investimento investimento) {
    this.saldo = investimento.getSaldoAtualizado(this.saldo);
  }
}

class Main {
  public static void main(String[] args) {
    Conta conta = new Conta(1000.0);
    System.out.println("Saldo inicial: " + conta.getSaldo());

    Investimento investimentoConservador = new InvestimentoConservador();
    conta.investir(investimentoConservador);
    System.out.println("Saldo após investimento conservador: " + conta.getSaldo());

    Investimento investimentoModerado = new InvestimentoModerado();
    conta.investir(investimentoModerado);
    System.out.println("Saldo após investimento moderado: " + conta.getSaldo());

    Investimento investimentoAgressivo = new InvestimentoAgressivo();
    conta.investir(investimentoAgressivo);
    System.out.println("Saldo após investimento agressivo: " + conta.getSaldo());
  }
}
