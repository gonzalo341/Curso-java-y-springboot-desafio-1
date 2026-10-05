import java.util.Scanner;

public class RegistroSocios {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos del socio (constantes)
        final double CUOTA_BASE = 100.0;

        // Datos del socio (variables)
        String nombreCompleto = " Martina Rodriguez ";
        String nombreUsuario = "";
        String apellidoUsuario = "";
        int edadUsuario = 37;
        String tipoDePaseUsuario = "VIP";
        int antiguedad = 14;
        boolean certificado = true;

        // datos del club (variables)
        int eleccionMenu = 0;
        boolean salirDelMenu = false;
        int sociosJuveniles = 0;

        // Elegir accion por consola
        while (salirDelMenu == false) {
            System.out.println("Elegir un opcion del menu:" +
                    "\n1)_ Ver datos guardados actualmente." +
                    "\n2)_ Ingresar datos de usuario." +
                    "\n3)_ Determinar el tipo de pase." +
                    "\n4)_ Descuento especial." +
                    "\n5)_ Contador de socios juveniles");
            eleccionMenu = sc.nextInt();

            switch (eleccionMenu){
                case 1:
                    // Preparar datos para impresion
                    nombreCompleto.trim();

                    System.out.println(String.format("Los datos guardados actualmente son:" +
                            "\n_ Nombre completo: %s." +
                            "\n_ Edad: %d." +
                            "\n_ Tipo de usuario: %s" +
                            "\n_ Antiguedad: %d" +
                            "\n_ Certificado: %b", nombreCompleto, edadUsuario, tipoDePaseUsuario, antiguedad, certificado));
                    break;
                case 2:
                    System.out.println("Ingrese los nuevos datos:");

                    break;
                case 0:
                    System.out.println("Saliendo del sistema.");
                    salirDelMenu = true;
                    break;
            }
        }
        // Ingreso de datos por consola:
        System.out.println("ingrese el nombre del usuario: ");
        nombreUsuario = sc.next();

        sc.close(); // Cerrar el scanner
    }
}