abstract class Persona {
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String residencia;
    protected String correo;

    public Persona (String nombres, String apellidos, int edad, String residencia, String correo) {
        setNombres(nombres);
        setApellidos(apellidos);
        setEdad(edad);
        setResidencia(residencia);
        setCorreo(correo);
    }

    public String getResidencia() {return residencia;}
    public String getApellidos() {return apellidos;}
    public int getEdad() {return edad;}
    public String getNombres() {return nombres;}
    public String getCorreo() {return correo;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setNombres(String nombres) {this.nombres = nombres;}
    public void setResidencia(String residencia) {this.residencia = residencia;    }
    public void setCorreo(String correo) {this.correo = correo;}
}