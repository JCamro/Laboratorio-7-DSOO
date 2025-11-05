public class Cliente extends Persona {
    private String idCliente;
    private String estado;
    
    public Cliente(String nombres, String apellidos, int edad, String residencia, String idCliente, String correo){
        super(residencia, residencia, edad, residencia, correo);
        setIdCliente(idCliente);
        this.estado = "activo";
    }

    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}
    public void setEstado(String estado) {this.estado = estado;}
    public String getIdCliente() {return idCliente;}
    public String getEstado() {return estado;}

}