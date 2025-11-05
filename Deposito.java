public class Deposito extends Transaccion {

    public Deposito(double monto, Cuenta cuenta) {
        super(monto, cuenta);
    }

    public String realizarTransaccion() {
        double saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + monto);
        return "Depósito de S/." + monto + " realizado con éxito. "
                + "Saldo actual: S/." + cuenta.getSaldo();
    }

    @Override
    public String toString() {
        return "Depósito -> " + super.toString();
    }
}
