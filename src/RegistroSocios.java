import java.util.Scanner;

public class RegistroSocios {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * ° Debe poder guardar datos de socio
         * ° Limpiar esos datos y modificarlos (usar .trin() - .toUpperCase() - .charAt(0) - .lenght())
         * ° Verificar si los datos son iguales (debe tener 12 años o más y tener certificado médico al día)
         * ° Determinar la categoria (si es admitido elegir con switch el tipo de pase VIP (*1.5) - ESTÁNDAR (cuota base)- INFANTIL (*0.7) - otro tipo[tipo de pase inválido])
         * _ Calcular la cuota (aplicar descuento) (descuento de $15 a socio con más de 12 meses de antiguedad o tiene pase VIP [utilizar -= para descontar los $15})
         * _ Contar cuantos socios son menores de edad (si el socio es menor de edad aumenta el contador de sociosJuveniles)
         * _ mostrar el resumen final por pantalla (utilizar String.format)
         * */

        // Datos del socio (constantes)
        final double CUOTA_BASE = 100.0;

        // Datos del socio (variables)
        String nombreCompleto = " Martina Rodriguez ";
        String nombreUsuario = "";
        String apellidoUsuario = "";
        char inicial = 'a';
        int cantidadDeCaracteres = 0;
        int edadUsuario = 37;
        String tipoDePaseUsuario = "VIP";
        int antiguedad = 14;
        boolean certificado = true;

        // datos del club (variables)
        int eleccionMenu = 0;
        int eleccionMenuPase = 0;
        boolean salirDelMenu = false;
        boolean verResultado = false;
        int sociosJuveniles = 0;
        int sociosVIP = 0;
        int sociosEstandar = 0;
        float precioFinal = 0f;

        // Elegir acción por consola
        while (salirDelMenu == false) {
            System.out.println("\n==================== Menú ====================" +
                    "\n1)_ Ver datos guardados actualmente." +
                    "\n2)_ Ingresar datos de usuario." +
                    "\n3)_ Ver cantidad de socios juveniles actualmente." +
                    "\n4)_ Ver cantidad de socios según el tipo de pase" +
                    "\n0)_ Salir del menu." +
                    "\n_ Elegir un opción del menu: ");
            eleccionMenu = sc.nextInt();

            sc.nextLine();
            switch (eleccionMenu) {
                case 1:
                    // Preparar datos para impresión
                    nombreCompleto = nombreCompleto.trim();
                    nombreCompleto = nombreCompleto.toUpperCase();
                    inicial = nombreCompleto.charAt(0);
                    cantidadDeCaracteres = nombreCompleto.length();

                    precioFinal = (float) (CUOTA_BASE * 1.5);


                    System.out.println(String.format(
                            "========== Datos guardados actualmente ==========" +
                                    "\nNombre completo: %s." +
                                    "\nInicial: %s." +
                                    "\nCantidad de caracteres: %d" +
                                    "\nEdad: %d" +
                                    "\nTipo de usuario: %s" +
                                    "\nAntigüedad: %d" +
                                    "\nCertificado médico al día: %b" +
                                    "\n ==================== Precio final ====================" +
                                    "\nCuota base: %.2f" +
                                    "\nPrecio final: %.2f",
                            nombreCompleto, inicial, cantidadDeCaracteres, edadUsuario, tipoDePaseUsuario, antiguedad, certificado, CUOTA_BASE, precioFinal));
                    break;
                case 2:
                    System.out.println("==================== Ingrese los nuevos datos ====================");
                    System.out.println("Ingrese el nombre del socio:");
                    nombreUsuario = sc.nextLine();
                    nombreUsuario = nombreUsuario.trim();
                    nombreUsuario = nombreUsuario.toUpperCase();
                    inicial = nombreUsuario.charAt(0);

                    System.out.println("Ingrese el apellido del socio: ");
                    apellidoUsuario = sc.nextLine();
                    apellidoUsuario = apellidoUsuario.trim();
                    apellidoUsuario = apellidoUsuario.toUpperCase();

                    System.out.println("Ingrese la edad actual del socio: ");
                    edadUsuario = sc.nextInt();

                    System.out.println("Ingrese la antiguedad del socio: ");
                    antiguedad = sc.nextInt();

                    System.out.println("Ingrese (true/false) si el socio tiene certificado medico al dia: ");
                    certificado = sc.nextBoolean();

                    nombreCompleto = nombreUsuario + " " + apellidoUsuario;
                    cantidadDeCaracteres = nombreCompleto.length();

                    System.out.println("\n==================== Condiciones de registro ====================");
                    if (edadUsuario >= 12 && edadUsuario <= 15 && certificado == true) {
                        System.out.println(String.format("\nEl socio '%s' cumple con los requisitos de registro", nombreCompleto));

                        System.out.println("\nPor favor ingrese el tipo de pase (numero entre el 0-2 correspondiente a la elección deseada):" +
                                "\n1)_ Pase VIP." +
                                "\n2)_ Pase INFANTIL." +
                                "\n0)_ Volver al menu.");
                        eleccionMenuPase = sc.nextInt();

                        switch (eleccionMenuPase) {
                            case 1:
                                tipoDePaseUsuario = "VIP";
                                sociosVIP++;
                                precioFinal = (float) (CUOTA_BASE * 1.5);
                                break;
                            case 2:
                                tipoDePaseUsuario = "INFANTIL";
                                sociosJuveniles++;
                                precioFinal = (float) (CUOTA_BASE * 0.7);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Tipo de pase invalido.");
                                break;
                        }

                        if (tipoDePaseUsuario.equals("VIP") || antiguedad >= 12) {
                            precioFinal -= 15;
                            System.out.println("\nTiene un descuento de: $15");
                        }

                        System.out.print("Desea ver el resultado final? (true/false): ");
                        verResultado = sc.nextBoolean();

                        if (verResultado) {
                            System.out.println(String.format(
                                    "========== Datos guardados actualmente ==========" +
                                            "\nNombre completo: %s." +
                                            "\nInicial: %s." +
                                            "\nCantidad de caracteres: %d" +
                                            "\nEdad: %d" +
                                            "\nTipo de usuario: %s" +
                                            "\nAntigüedad: %d" +
                                            "\nCertificado médico al día: %b" +
                                            "\n ==================== Precio final ====================" +
                                            "\nCuota base: %.2f" +
                                            "\nPrecio final: %.2f",
                                    nombreCompleto, inicial, cantidadDeCaracteres, edadUsuario, tipoDePaseUsuario, antiguedad, certificado, CUOTA_BASE, precioFinal));
                        } else {
                            System.out.println("Saliendo del menu...");
                        }


                    } else if (edadUsuario > 15 && certificado == true) {
                        System.out.println(String.format("\nEl socio '%s' cumple con los requisitos de registro", nombreCompleto));

                        System.out.println("\nPor favor ingrese el tipo de pase (numero entre el 0-2 correspondiente a la elección deseada):" +
                                "\n1)_ Pase VIP." +
                                "\n2)_ Pase ESTÁNDAR." +
                                "\n0)_ Volver al menu.");
                        eleccionMenuPase = sc.nextInt();

                        switch (eleccionMenuPase) {
                            case 1:
                                tipoDePaseUsuario = "VIP";
                                sociosVIP++;
                                precioFinal = (float) (CUOTA_BASE * 1.5);
                                break;
                            case 2:
                                tipoDePaseUsuario = "ESTANDAR";
                                sociosEstandar++;
                                precioFinal = (float) (CUOTA_BASE);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Tipo de pase invalido.");
                                break;
                        }

                        if (tipoDePaseUsuario.equals("VIP") || antiguedad >= 12) {
                            precioFinal -= 15;
                            System.out.println("\nTiene un descuento de: $15");
                        }

                        System.out.print("Desea ver el resultado final? (true/false): ");
                        verResultado = sc.nextBoolean();

                        if (verResultado) {
                            System.out.println(String.format(
                                    "========== Datos guardados actualmente ==========" +
                                            "\nNombre completo: %s." +
                                            "\nInicial: %s." +
                                            "\nCantidad de caracteres: %d" +
                                            "\nEdad: %d" +
                                            "\nTipo de usuario: %s" +
                                            "\nAntigüedad: %d" +
                                            "\nCertificado médico al día: %b" +
                                            "\n ==================== Precio final ====================" +
                                            "\nCuota base: %.2f" +
                                            "\nPrecio final: %.2f",
                                    nombreCompleto, inicial, cantidadDeCaracteres, edadUsuario, tipoDePaseUsuario, antiguedad, certificado, CUOTA_BASE, precioFinal));
                        } else {
                            System.out.println("Saliendo del menu...");
                        }
                    }
                    else {
                        System.out.println(String.format("\nEl socio '%s' NO cumple con los requisitos de registro", nombreCompleto));
                    }
                    break;
                case 3:
                    System.out.println(String.format("\n==================== Socios Juveniles ====================" +
                            "\nLa cantidad actual de socios juveniles es de: %d", sociosJuveniles));
                    break;
                case 4:
                    System.out.println(String.format("\n==================== Cantidad de socios según tipo de pase ====================" +
                            "\nSocios VIP:      %d." +
                            "\nSocios ESTÁNDAR: %d." +
                            "\nSocios INFANTIL: %d.", sociosVIP, sociosEstandar, sociosJuveniles));
                    break;
                case 0:
                    System.out.println("\n==================== Saliendo del sistema ====================");
                    salirDelMenu = true;
                    break;
            }
        }

        sc.close(); // Cerrar el scanner
    }
}