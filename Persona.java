import java.time.LocalDateTime;

abstract class Persona {
    protected String nombres;
    protected String apellidos;
    protected int dni;
    protected int edad;
    protected LocalDateTime fechaCreacion;
    protected String residencia;
    protected String correo;

    public Persona (String nombres, String apellidos, int edad, int dni, String residencia, String correo) {
        setNombres(nombres);
        setApellidos(apellidos);
        setEdad(edad);
        setResidencia(residencia);
        setCorreo(correo);
        setDni(dni);
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getResidencia() {return residencia;}
    public String getApellidos() {return apellidos;}
    public int getEdad() {return edad;}
    public String getNombres() {return nombres;}
    public String getCorreo() {return correo;}
    public int getDni() {return dni;}
    public LocalDateTime getFechaCreacion() {return fechaCreacion;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setNombres(String nombres) {this.nombres = nombres;}
    public void setResidencia(String residencia) {this.residencia = residencia;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setDni(int dni) {this.dni = dni;}
}


