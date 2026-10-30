package com.juniverse.karatsuba;

import java.math.BigInteger;

/**
 * Multiplicación de Karatsuba para enteros y decimales de precisión arbitraria.
 * Reduce 4 multiplicaciones de media longitud a 3, con complejidad O(n^1.585).
 *
 * @author ajuar
 */
public final class Karatsuba {

    private static final int THRESHOLD = 2000;

    /** Clase de utilidades: no se instancia. */
    private Karatsuba() {
        
    }
    /**
     * Multiplica dos enteros con el algoritmo de Karatsuba. Para números de hasta
     * {@code THRESHOLD} bits usa la multiplicación estándar.
     * @param x primer factor
     * @param y segundo factor
     * @return {@code x * y}
     */
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());

        if (N <= THRESHOLD) {
            return x.multiply(y);
        }

        int halfN = (N / 2) + (N % 2);

        BigInteger highX = x.shiftRight(halfN);
        BigInteger lowX = x.subtract(highX.shiftLeft(halfN));

        BigInteger highY = y.shiftRight(halfN);
        BigInteger lowY = y.subtract(highY.shiftLeft(halfN));

        BigInteger z0 = karatsuba(lowX, lowY);
        BigInteger z2 = karatsuba(highX, highY);

        BigInteger sumX = highX.add(lowX);
        BigInteger sumY = highY.add(lowY);

        BigInteger z1 = karatsuba(sumX, sumY).subtract(z2).subtract(z0);

        return z2.shiftLeft(2 * halfN).add(z1.shiftLeft(halfN)).add(z0);
    }

    /**
     * Multiplica dos números dados como texto (enteros o con punto decimal, con signo opcional).
     * @param num1 primer factor, por ejemplo "123.45"
     * @param num2 segundo factor
     * @return producto sin ceros sobrantes
     * @throws NumberFormatException si algún factor no es un número válido
     */
    public static String multiply(String num1, String num2) {
        // Contar decimales
        int decimals1 = num1.contains(".") ? num1.length() - num1.indexOf('.') - 1 : 0;
        int decimals2 = num2.contains(".") ? num2.length() - num2.indexOf('.') - 1 : 0;

        // Eliminar punto decimal
        String intStr1 = num1.replace(".", "");
        String intStr2 = num2.replace(".", "");

        // Convertir a BigInteger
        BigInteger int1 = new BigInteger(intStr1);
        BigInteger int2 = new BigInteger(intStr2);

        // Multiplicar con Karatsuba
        BigInteger product = karatsuba(int1, int2);

        // Total de decimales en el resultado
        int totalDecimals = decimals1 + decimals2;

        // El signo se separa para poder rellenar con ceros y colocar el punto decimal sin romper el texto
        String sign = product.signum() < 0 ? "-" : "";
        String productStr = product.abs().toString();

        // Si no hay decimales, devolver como entero
        if (totalDecimals == 0) {
            return sign + productStr;
        }

        // Asegurar que hay suficientes dígitos para insertar el punto
        while (productStr.length() <= totalDecimals) {
            productStr = "0" + productStr;
        }

        // Insertar punto decimal
        int pointPosition = productStr.length() - totalDecimals;
        String result = productStr.substring(0, pointPosition) + "." + productStr.substring(pointPosition);

        // Limpiar ceros no significativos
        result = result.replaceFirst("^0+(?!\\.)", ""); // ceros iniciales
        result = result.replaceFirst("\\.?0+$", "");    // ceros finales después del punto

        return sign + result;
    }

}
