import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorBanco gestor = new GestorBanco();
        int opcion;

        do {
            System.out.println("\n====== MENU BANCO ======");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Abrir Cuenta");
            System.out.println("4. Añadir Titular Secundario");
            System.out.println("5. Realizar Depósito");
            System.out.println("6. Realizar Retiro");
            System.out.println("7. Mostrar Cuentas de un Cliente");
            System.out.println("8. Mostrar Titulares de una Cuenta");
            System.out.println("9. Mostrar Movimientos de un Cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- REGISTRO CLIENTE ---");
                    System.out.print("Nombres: "); String nombres = sc.nextLine();
                    System.out.print("Apellidos: "); String apellidos = sc.nextLine();
                    System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("DNI (8 dígitos): "); int dni = sc.nextInt(); sc.nextLine();
                    System.out.print("ID Cliente: "); String idCliente = sc.nextLine();
                    System.out.print("Correo: "); String correo = sc.nextLine();
                    System.out.print("Residencia: "); String residencia = sc.nextLine();

                    gestor.registrarCliente(nombres, apellidos, edad, dni, idCliente, correo, residencia);
                }

                case 2 -> {
                    System.out.println("\n--- REGISTRO EMPLEADO ---");
                    System.out.print("Nombres: "); String nombres = sc.nextLine();
                    System.out.print("Apellidos: "); String apellidos = sc.nextLine();
                    System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("DNI (8 dígitos): "); int dni = sc.nextInt(); sc.nextLine();
                    System.out.print("ID Empleado: "); String idEmpleado = sc.nextLine();
                    System.out.print("Correo: "); String correo = sc.nextLine();
                    System.out.print("Residencia: "); String residencia = sc.nextLine();
                    System.out.print("Cargo: "); String cargo = sc.nextLine();

                    gestor.registrarEmpleado(nombres, apellidos, edad, dni, idEmpleado, correo, residencia, cargo);
                }

                case 3 -> {
                    System.out.println("\n--- APERTURA DE CUENTA ---");
                    System.out.print("ID Cliente: "); String idCliente = sc.nextLine();
                    System.out.print("Número de Cuenta: "); int numCuenta = sc.nextInt(); sc.nextLine();
                    System.out.print("Tipo de Cuenta: "); String tipoCuenta = sc.nextLine();
                    System.out.print("Saldo Inicial: "); double saldo = sc.nextDouble();
                    System.out.print("Clave (4 dígitos): "); int clave = sc.nextInt();
                    sc.nextLine();

                    gestor.abrirCuenta(idCliente, numCuenta, tipoCuenta, saldo, clave);
                }

                case 4 -> {
                    System.out.println("\n--- AÑADIR TITULAR SECUNDARIO ---");
                    System.out.print("ID Cliente: "); String idCliente = sc.nextLine();
                    System.out.print("Número de Cuenta: "); int numCuenta = sc.nextInt();
                    System.out.print("Clave de Cuenta: "); int clave = sc.nextInt();
                    sc.nextLine();

                    gestor.añadirTitular(idCliente, numCuenta, clave);
                }

                case 5 -> {
                    System.out.println("\n--- REALIZAR DEPÓSITO ---");
                    System.out.print("ID Cliente: "); String idCliente = sc.nextLine();
                    System.out.print("ID Empleado: "); String idEmpleado = sc.nextLine();
                    System.out.print("Número de Cuenta: "); int numCuenta = sc.nextInt();
                    System.out.print("Monto a Depositar: "); double monto = sc.nextDouble(); sc.nextLine();
                    System.out.print("ID Transacción: "); String idTransaccion = sc.nextLine();

                    gestor.realizarDeposito(idCliente, idEmpleado, numCuenta, monto, idTransaccion);
                }

                case 6 -> {
                    System.out.println("\n--- REALIZAR RETIRO ---");
                    System.out.print("ID Cliente: "); String idCliente = sc.nextLine();
                    System.out.print("ID Empleado: "); String idEmpleado = sc.nextLine();
                    System.out.print("Número de Cuenta: "); int numCuenta = sc.nextInt();
                    System.out.print("Monto a Retirar: "); double monto = sc.nextDouble();
                    System.out.print("ID Transacción: "); String idTransaccion = sc.next();
                    System.out.print("Clave: "); int clave = sc.nextInt(); sc.nextLine();

                    gestor.realizarRetiro(idCliente, idEmpleado, numCuenta, monto, idTransaccion, clave);
                }

                case 7 -> {
                    String idCliente = sc.nextLine();
                    gestor.mostrarCuentasCliente(idCliente);
                }

                case 8 -> {
                    int numCuenta = sc.nextInt(); sc.nextLine();
                    gestor.mostrarTitulares(numCuenta);
                }

                case 9 -> {
                    String idCliente = sc.nextLine();
                    gestor.mostrarMovimientosCliente(idCliente);
                }

                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
