package com.juniverse.karatsuba;

/**
 * Ejemplo: multiplica dos enteros y dos decimales grandes con Karatsuba.
 *
 * @author ajuar
 */
public class Main {

    /**
     * Punto de entrada.
     * @param args no se usan
     */
    public static void main(String[] args) {

        // Caso entero
        String num1 = "123456789123456789";
        String num2 = "987654321987654321";

        String resultInt = Karatsuba.multiply(num1, num2);
        System.out.println("Multiplicacion de enteros:");
        System.out.println(NumberFormatUtil.getFormat(num1) + " * " + 
                NumberFormatUtil.getFormat(num2) + " = " + 
                NumberFormatUtil.getFormat(resultInt));

        // Caso decimal
        String num3 = "123456789.987654321";
        String num4 = "987654321.123456789";

        String resultDecimal = Karatsuba.multiply(num3, num4);
        System.out.println("\nMultiplicacion de decimales:");
        System.out.println(NumberFormatUtil.getFormat(num3) + " * " + 
                NumberFormatUtil.getFormat(num4) + " = " + 
                NumberFormatUtil.getFormat(resultDecimal));
    }
}
