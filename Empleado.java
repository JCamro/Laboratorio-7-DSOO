public class Empleado extends Persona{

    private String idEmpleado;
    private String cargo;

    public Empleado(String nombres, String apellidos, int edad, String residencia, String correo, String idEmpleado, String cargo) {
        super(nombres, apellidos, edad, residencia, correo);
        setCargo(cargo);
        setIdEmpleado(idEmpleado);
    }
    
    public void setIdEmpleado(String idEmpleado) {this.idEmpleado = idEmpleado;}
    public void setCargo(String cargo) {this.cargo = cargo;}

    public String getIdEmpleado() {return idEmpleado;}
    public String getCargo() {return cargo;}
}