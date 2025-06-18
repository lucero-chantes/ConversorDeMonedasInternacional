import javax.imageio.plugins.tiff.TIFFDirectory;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConvertirMoneda convertir = new ConvertirMoneda();

        int opcion = 0;

        while (opcion!=7){
            System.out.println("********************************");
            System.out.println("***CONVERSOR DE MONEDAS INTERNACIONAL");
            System.out.println("***Elige la opcion que mas te convenga");
            System.out.println("Opcion 1. Dolar Americano a Peso Mexicano");
            System.out.println("Opcion 2. Euro a Dolar");
            System.out.println("Opcion 3. Dolar Americano a Euro");
            System.out.println("Opcion 4. Peso Mexicano a Dolar");
            System.out.println("Opcion 5. Peso Mexicano a euro");
            System.out.println("Opcion 6. Escoger de forma personalizada");
            System.out.println("Opcion 7. SALIR");

            opcion = lectura. nextInt();
            lectura.nextLine();

            String monedaDeCambio="";
            String tipoDeCambio="";

            switch (opcion){
                case 1:
                    monedaDeCambio="USD";
                    tipoDeCambio="MXN";
                    break;

                case 2:
                    monedaDeCambio="EUR";
                    tipoDeCambio="USD";
                    break;

                case 3:
                    monedaDeCambio="USD";
                    tipoDeCambio="EUR";
                    break;

                case 4:
                    monedaDeCambio="MXN";
                    tipoDeCambio="USD";
                    break;

                case 5:
                    monedaDeCambio="MXN";
                    tipoDeCambio="EUR";
                    break;

                case 6:
                    System.out.println("Escribe la moneda base: ");
                    monedaDeCambio= lectura.nextLine().toUpperCase();
                    System.out.println("Escribe el tipo de cambio");
                    tipoDeCambio= lectura.nextLine().toUpperCase();
                    break;

                case 7:
                    System.out.println("Estas Saliendo del Conversor");
                    break;

                default:
                    System.out.println("Esa opcion no es valida");
                    break;

            }

            if(opcion>=1 && opcion<=6){
                System.out.println("Cual es el monto que deseas convertir");
                double monto = lectura.nextDouble();

                try{
                    Moneda moneda = convertir.conversion(monedaDeCambio,tipoDeCambio);
                    System.out.println("EL TIPO DE CAMBIO AL DIA DE HOY ES= "+ moneda.conversion_rate());
                    double resultado= monto * moneda.conversion_rate();
                    System.out.println(resultado);
                }catch (Exception e){
                    System.out.println("Hubo un error al convertir");
                }
            }




        }


    }
}