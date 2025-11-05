public class Deposito extends Transaccion {

    public Deposito(Cuenta cuenta, Empleado empleado, Cliente cliente, double monto) {
        super(cliente, empleado, cuenta, monto);
    }

    public void realizarTransaccion() {
        double saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + monto);
    }

    @Override
    public String toString() {
        return "--- DEPOSITO --- " + super.toString();
    }
}
