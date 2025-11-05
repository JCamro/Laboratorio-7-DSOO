import java.util.ArrayList;

public class GestorBanco {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    private ArrayList<Titularidad> listaTitularidades = new ArrayList<>();
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    
    // - METODO PARA REGISTRAR EMPLEADOS -
    public void registrarEmpleado(String nombres, String apellidos, int edad, int dni, String idEmpleado, String correo, String residencia, String cargo) {
        
        //Verifica que las entradas en datos String no sean null ni ""
        if (!stringValido(nombres) || !stringValido(apellidos) || !stringValido(idEmpleado) || !stringValido(correo) || !stringValido(residencia) || !stringValido(cargo)) {
            System.out.println("Valores ingresados (Nombres, Apellidos, IDEMPLEADO, correo, cargo) no deben estar vacios");
            return;
        }

        //Verifica la edad es valida
        if (!numeroPositivo(edad)) {
            System.out.println("Edad ingresada para registrar al cliente no valida");
            return;
        }

        //Verifica si el formato del DNI es valido
        if (!DNIValido(dni)) {
            System.out.println("DNI ingresado para registrar cliente no es valido");
            return;
        }
        
        //Verifica si no existe un mismo dni registrado
        if (buscarEmpleado(dni)!=null) {
            System.out.println("DNI ya registrado en el sistema, no se registro al Empleado");
            return;
        }

        //Verifica si no existe otro empleado con el mismo codigo
        if (buscarEmpleado(idEmpleado)!=null) {
            System.out.println("El codigo asignado ya esta registrado");
            return;
        }

        //Se crea el objeto empleado
        Empleado empleado = new Empleado(nombres, apellidos, edad, dni, residencia, idEmpleado, correo, cargo);
        
        //Se agrega el objeto en el registro
        listaEmpleados.add(empleado);
        
        //Se muestra el proceso realizado
        System.out.println("---REGISTRO DE EMPLEADO---");
        System.out.println(empleado);
    }


    // - METODO PARA REGISTRAR CLIENTES -
    public void registrarCliente(String nombres, String apellidos, int edad, int dni, String idCliente, String correo, String residencia) {
        
        //Verifica que las entradas en datos String no sean null ni ""
        if (!stringValido(nombres) || !stringValido(apellidos) || !stringValido(idCliente) || !stringValido(correo) || !stringValido(residencia)) {
            System.out.println("Valores ingresados (Nombres, Apellidos, IDCLIENTE, correo) no deben estar vacios");
            return;
        }
        
        //Verifica si la edad es positiva
        if (!numeroPositivo(edad)) {
            System.out.println("Edad ingresada para registrar al cliente no valida");
            return;
        }
        
        //Verifica si DNI corresponde al formato indicado
        if (!DNIValido(dni)) {
            System.out.println("DNI ingresado para registrar cliente no es valido");
            return;
        }

        //Verifica si no existe un mismo dni registrado
        if (buscarCliente(dni)!=null) {
            System.out.println("DNI ya registrado en el sistema, no se registro al Cliente");
            return;
        }
        
        //Verifica si existe otro cliente con el mismo codigo
        if (buscarCliente(idCliente)!=null) {
            System.out.println("El codigo asignado ya esta registrado");
            return;
        }
        
        //Se crea objeto cliente
        Cliente cliente = new Cliente(nombres, apellidos, edad, dni, residencia, idCliente, correo);
        
        //Se añade al registro
        listaClientes.add(cliente);
        
        //Se muestra el REGISTRO
        System.out.println("---REGISTRO DE CLIENTE---");
        System.out.println(cliente);
    }
    

    // - METODO PARA ABRIR UNA CUENTA -
    public void abrirCuenta(String idCliente, int numeroCuenta, String tipoCuenta, double saldo, int clave ) {
        
        //Verifica que las entradas en datos String no sean null ni ""
        if (!stringValido(tipoCuenta) || !stringValido(idCliente)) {
            System.out.println("No se permiten datos nulos, no se creo la cuenta");
            return;
        }
        
        //Verifica si el cliente existe
        Cliente cliente = buscarCliente(idCliente);
        if (cliente==null) {
            System.out.println("No se encontro al cliente para crear una cuenta");
            return;
        }
        
        //Verifica si existe una cuenta con el mismo numero de cuenta 
        if (buscarCuenta(numeroCuenta)!=null) {
            System.out.println("Este numero de cuenta ya existe, no se creo la cuenta");
            return;
        }
        
        //Verifica que las entradas Int y Double sean positivas
        if (!numeroPositivo(saldo) || !numeroPositivo(numeroCuenta) || !numeroPositivo(clave)) {
            System.out.println("Saldo, Numero de Cuenta y Clave tienen que ser numeros positivos");
            return;
        }
        
        //Se crea el objeto cuenta
        Cuenta cuenta = new Cuenta(numeroCuenta, tipoCuenta, saldo, clave);
        
        //Se añade el objeto al registro
        listaCuentas.add(cuenta);
        
        //Se muestra el proceso realizado
        System.out.println(cuenta);
        System.out.println("---APERTURA DE CUENTA---");
        
        //Se registra la primera titularidad de la cuenta dando por echo que el Cliente que abrio la cuenta es el principal
        Titularidad titular = new Titularidad("Principal", cliente, cuenta);
        listaTitularidades.add(titular);
        System.out.println(titular);
    }


    // - METODO PARA AÑADIR TITULARES -
    public void añadirTitular(String idCliente, int numeroCuenta, int clave) {
        
        //Verifica que las entradas en datos String no sean null ni ""
        if (!stringValido(idCliente)) {
            System.out.println("No se permiten datos nulos, no se creo la cuenta");
            return;
        }
        
        //Verifica si el cliente existe
        Cliente cliente = buscarCliente(idCliente);
        
        if (cliente==null) {
            System.out.println("No se encontro al cliente para añadir titularidad");
            return;
        }
        
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        
        //Verifica si existe una cuenta con el mismo numero de cuenta 
        if (cuenta==null) {
            System.out.println("Numero de cuenta no registrada, la cuenta no existe, no se realizo el proceso");
            return;
        }
        
        //Comprueba la clave ingresada para realizar el proceso
        if (clave != cuenta.getClave()) {
            System.out.println("Clave incorrecta, no se realizo la asignacion de titularidad");
            return;
        }

        //Se registra la titularidad de la cuenta dando por echo que el Cliente es Secundario
        Titularidad titular = new Titularidad("Secundario", cliente, cuenta);
        System.out.println(titular);
    }


    // - REALIZAR TRANSACCION TIPO DEPOSITO -
    public void realizarDeposito(String idCliente, String idEmpleado, int numeroCuenta, double monto) {
        
        //Verifica que las entradas en datos String no sean null ni ""
        if (!stringValido(idCliente) || !stringValido(idEmpleado)) {
            System.out.println("Valores ingresados (IdCliente, IdEmpleado) no deben estar vacios");
            return;
        }
        
        //Verifica que el monto a depositar sea positivo
        if (!numeroPositivo(monto)) {
            System.out.println("Monto a depositar debe de ser positivo");
            return;
        }
        
        //Se verifica si existe cada agente en este movimiento
        Cliente cliente = buscarCliente(idCliente);
        Empleado empleado = buscarEmpleado(idEmpleado);
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cliente==null) {System.out.println("Codigo de cliente no existente, no se realizo el deposito"); return;}
        if (cuenta==null) {System.out.println("Numero de cuenta no existente, no se realizo el deposito"); return;}
        if (empleado==null) {System.out.println("Codigo de Empleado no existente, no se realizo el deposito"); return;}
        
        //Se crea el objeto deposito
        Deposito deposito = new Deposito(cuenta, empleado, cliente, monto);
        //Se realiza el movimiento
        deposito.realizarTransaccion();
        //Se añade al registro de transacciones de la cuenta
        cuenta.añadirTransaccion(deposito);
        System.out.println(deposito);
    }
    

    // - REALIZAR TRANSACCION TIPO DEPOSITO -
    public void realizarRetiro(String idCliente, String idEmpleado, int numeroCuenta, double monto, int clave) {
        
        //Verifica que las entradas en datos String no sean null ni ""        
        if (!stringValido(idCliente) || !stringValido(idEmpleado)) {
            System.out.println("Valores ingresados (IdCliente, IdEmpleado) no deben estar vacios");
            return;
        }
        
        //Se verifica si existe cada agente en este movimiento
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        Cliente cliente = buscarCliente(idCliente);
        Empleado empleado = buscarEmpleado(idEmpleado);
        if (cliente==null) {System.out.println("Codigo de cliente no existente, no se realizo el deposito"); return;}
        if (cuenta==null) {System.out.println("Numero de cuenta no existente, no se realizo el deposito"); return;}
        if (empleado==null) {System.out.println("Codigo de Empleado no existente, no se realizo el deposito"); return;}
        
        //Se comprueba si la clave es correcta para realizar el deposito
        if (clave!=cuenta.getClave()) {
            System.out.println("Clave incorrecta, no se realizo el retiro");
            return;
        }
        
        //Se valida que el monto a retirar sea positivo
        if (!numeroPositivo(monto)) {
            System.out.println("Monto a retirar debe de ser positivo");
            return;
        }
        //Se crea el objeto retiro
        Retiro retiro = new Retiro(cuenta, cliente, empleado, monto);

        //Si cumple la condicion, no se realiza el retiro 
        if (!retiro.realizarTransaccion()) {
            System.out.println("No se realizo el retiro");    
            return;
        }
        
        //Se añade la transaccion realizada a la cuenta
        cuenta.añadirTransaccion(retiro);
    }

    // - MUESTRA LOS TITULARES DE UNA CUENTA -
    public void mostrarTitulares(int codigoCuenta) {
        ArrayList<Cliente> clientes = titularesCuenta(codigoCuenta);
        if (clientes.size()==0 || clientes==null) {
            System.out.println("NO EXISTEN TITULARES PRESENTES");
            return;
        }
        System.out.println("--- LISTA TITULARES DE CUENTA "+codigoCuenta+" ---");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }


    // - MOSTRAR LAS CUENTAS DE UN CLIENTE -
    public void mostrarCuentasCliente(String idCliente) {
        ArrayList<Cuenta> cuentas = cuentasCliente(idCliente);
        
        if (cuentas==null) {
            System.out.println("Cliente no existente, no se encontraron cuentas");
            return;
        }
        if (cuentas.size()==0) {
            System.out.println("NO HAY CUENTAS REGISTRADAS");
            return;
        }
        System.out.println("--- LISTA DE CUENTAS CLIENTE: "+idCliente+" ---");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }


    // - MOSTRAR LOS MOVIMIENTOS DE UN CLIENTE -
    public void mostrarMovimientosCliente(String idCliente) {
        ArrayList<Transaccion> movimientos = movimientosCliente(idCliente);
        
        if (movimientos==null) {
            System.out.println("Cliente no existente, no se encontraron movimientos");
            return;
        }
        if (movimientos.size()==0) {
            System.out.println("NO HAY TRANSACCIONES REGISTRADAS");
            return;
        }
        System.out.println("--- LISTA DE TRANSACCIONES CLIENTE: "+idCliente+" ---");
        for (Transaccion transaccion : movimientos) {
            if (transaccion instanceof Deposito) {
                System.out.println(transaccion);
            }
        }
        for (Transaccion transaccion : movimientos) {
            if (transaccion instanceof Retiro) {
                System.out.println(transaccion);
            }
        }
    }

    //Metodo que valida si un String no sea null ni este vacio ("")
    private boolean stringValido(String entrada) {return !(entrada==null || entrada.trim().isEmpty());}
    
    //Metodo que valida el formato correcto del DNI
    private boolean DNIValido(int dni) {return !(dni<10000000 || dni>99999999);}
    
    //Polimorfismo estatico en metodo donde recibe un int o double para confirmar si es positivo
    public boolean numeroPositivo(double numero) {return numero>0;}
    public boolean numeroPositivo(int numero) {return numero>0;}
    
    //Metodo que busca un cliente por su id, devuelve el cliente si lo encuentra
    private Cliente buscarCliente(String idCliente) {
        for (Cliente cliente : listaClientes) {
            if (idCliente.equals(cliente.getIdCliente())) {
                return cliente;
            }
        }
        return null;
    }
    
    private Cliente buscarCliente(int dni) {
        for (Cliente cliente : listaClientes) {
            if (dni==cliente.getDni()) {
                return cliente;
            }
        }
        return null;
    }
    
    //Metodo que busca un Empleado por su id, devuelve el empleado si lo encuentra
    private Empleado buscarEmpleado(String idEmpleado) {
        for (Empleado empleado : listaEmpleados) {
            if (idEmpleado.equals(empleado.getIdEmpleado())) {
                return empleado;
            }
        }
        return null;
    }
    
    private Empleado buscarEmpleado(int dni) {
        for (Empleado empleado : listaEmpleados) {
            if (dni==empleado.getDni()) {
                return empleado;
            }
        }
        return null;
    }
    
    //Metodo que busca una Cuenta por su numero de Cuenta, devuelve la cuenta si lo encuentra
    private Cuenta buscarCuenta(int numeroCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (numeroCuenta==cuenta.getNumeroCuenta()) {
                return cuenta;
            }
        }
        return null;
    }
    
    //Devuelve un ArrayList de todos los titulares relacionados a una cuenta
    private ArrayList<Cliente> titularesCuenta(int numeroCuenta) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);

        if (cuenta == null) {return null;}

        ArrayList<Cliente> titulares = new ArrayList<>();

        for (Titularidad titular : listaTitularidades) {
            if (titular.getCuenta()==cuenta) {
                titulares.add(titular.getCliente());
            }
        }
        return titulares;
    }

    //Devuelve un ArrayList de todos los movimientos de un cliente en todas sus cuentas
    private ArrayList<Transaccion> movimientosCliente(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente==null) {
            return null;
        }

        ArrayList<Transaccion> movimientos = new ArrayList<>();
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getCliente()==cliente) {
                movimientos.add(transaccion);
            }
        }
        return movimientos;
    }

    //Devuelve ArrayList de las cuentas de un cliente
    public ArrayList<Cuenta> cuentasCliente(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente==null) {
            return null;
        }

        ArrayList<Cuenta> cuentasCliente = new ArrayList<>();

        for (Titularidad titular : listaTitularidades) {
            if (titular.getCliente()==buscarCliente(idCliente)) {
                cuentasCliente.add(titular.getCuenta());
            }
        }

        return cuentasCliente;
    }
}


