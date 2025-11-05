public class Cliente extends Persona {
    private String idCliente;
    private String estado;
    
    
    public Cliente(String nombres, String apellidos, int edad, int dni, String residencia, String idCliente, String correo){
        super(nombres, apellidos, edad, dni, correo, residencia);
        setIdCliente(idCliente);
        this.estado="activo";
    }

    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}
    public void setEstado(String estado) {this.estado = estado;}
    public String getIdCliente() {return idCliente;}
    public String getEstado() {return estado;}  
    
    public String toString() {
        return "---Informacion Cliente---"+
                "\nNombres y Apellidos: "+nombres + " " + apellidos+
                "\nIdCliente: "+idCliente+
                "\nEdad: "+edad+
                "\nDNI: "+dni+
                "\nCorreo: "+correo+
                "\nResidencia: "+residencia; 
    }
}