public class Deposito extends Transaccion {

    public Deposito(Cuenta cuenta, Empleado empleado, Cliente cliente, double monto, String idTransaccion) {
        super(cliente, empleado, cuenta, monto, idTransaccion);
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
