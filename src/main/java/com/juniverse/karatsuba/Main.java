package com.juniverse.karatsuba;


import java.util.logging.Logger;
/**
 * Ejemplo: multiplica dos enteros y dos decimales grandes con Karatsuba.
 *
 * @author ajuar
 */
public class Main {
    private static final Logger LOGGER = AppLogger.get(Main.class);


    /**
     * Punto de entrada.
     * @param args no se usan
     */
    public static void main(String[] args) {

        // Caso entero
        String num1 = "123456789123456789";
        String num2 = "987654321987654321";

        String resultInt = Karatsuba.multiply(num1, num2);
        LOGGER.info("Multiplicacion de enteros:");
        LOGGER.info(NumberFormatUtil.getFormat(num1) + " * " + 
                NumberFormatUtil.getFormat(num2) + " = " + 
                NumberFormatUtil.getFormat(resultInt));

        // Caso decimal
        String num3 = "123456789.987654321";
        String num4 = "987654321.123456789";

        String resultDecimal = Karatsuba.multiply(num3, num4);
        LOGGER.info("\nMultiplicacion de decimales:");
        LOGGER.info(NumberFormatUtil.getFormat(num3) + " * " + 
                NumberFormatUtil.getFormat(num4) + " = " + 
                NumberFormatUtil.getFormat(resultDecimal));
    }
}
