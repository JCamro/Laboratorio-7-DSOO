import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Titularidad {
    private String tipo;
    private Cliente cliente;
    private Cuenta cuenta;
    private LocalDateTime fechaCreacion;

    public Titularidad(String tipo, Cliente cliente, Cuenta cuenta) {
        this.tipo = tipo;
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.fechaCreacion = LocalDateTime.now();
    }

    // --- Getters y Setters ---
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    
    public String cambiarTipo(String nuevoTipo) {
        this.tipo = nuevoTipo;
        return this.tipo;
    }
}
