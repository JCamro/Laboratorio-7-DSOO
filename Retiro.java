public class Retiro extends Transaccion {

    public Retiro(double monto, Cuenta cuenta) {
        super(monto, cuenta);
    }

    public String realizarTransaccion() {
        double saldoActual = cuenta.getSaldo();

        if (monto > saldoActual) {
            return "Error: Fondos insuficientes. Saldo actual: S/." + saldoActual;
        }

        cuenta.setSaldo(saldoActual - monto);
        return "Retiro de S/." + monto + " realizado con éxito. "
                + "Saldo actual: S/." + cuenta.getSaldo();
    }

    @Override
    public String toString() {
        return "Retiro -> " + super.toString();
    }
}
