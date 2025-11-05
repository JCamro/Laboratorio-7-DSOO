import java.time.LocalDateTime;

public class Cuenta {
    private int numeroCuenta;
    private String tipoCuenta;
    private double saldo;
    private int clave;
    private LocalDateTime fechaApertura;
    
    public Cuenta(int numeroCuenta, String tipoCuenta, double saldo, int clave) {
        setNumeroCuenta(numeroCuenta);
        setTipoCuenta(tipoCuenta);
        setSaldo(saldo);
        setClave(clave);
        this.fechaApertura = LocalDateTime.now();
    }
    //SETTERS
    public void setNumeroCuenta(int numeroCuenta) {this.numeroCuenta = numeroCuenta;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public void setTipoCuenta(String tipoCuenta) {this.tipoCuenta = tipoCuenta;}
    public void setClave(int clave) {this.clave = clave;}

    //GETTERS
    public LocalDateTime getFechaApertura() {return fechaApertura;}
    public int getNumeroCuenta() {return numeroCuenta;}
    public double consultarSaldo() {return saldo;}
    public String getTipoCuenta() {return tipoCuenta;}
    public int getClave() {return clave;}

    //DEPOSITA DINERO
    public void deposito(double monto) {this.saldo-=monto;}
    //RETIRA DINERO
    public void retiro(double monto) {this.saldo-=monto;}

    public String toString() {
        return "---Contrado de apertura de Cuenta---"+
                "\nNum. Cuenta: "+numeroCuenta+
                "\nTipo de Cuenta: "+tipoCuenta+
                "\nFecha de Apertura: "+fechaApertura;
    }
}
