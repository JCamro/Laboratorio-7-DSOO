public class Retiro extends Transaccion {

    public Retiro(Cuenta cuenta, Cliente cliente, Empleado empleado, double monto) {
        super(cliente, empleado, cuenta, monto);
    }

    public boolean realizarTransaccion() {
        double saldoActual = cuenta.getSaldo();

        if (monto > saldoActual) {
            System.out.println("Error: Fondos insuficientes. Saldo actual: S/." + saldoActual);
            return false;
        }

        cuenta.setSaldo(saldoActual - monto);
        toString();
        return true;
    }

    @Override
    public String toString() {
        return "--- RETIRO ---" + super.toString();
    }
}
