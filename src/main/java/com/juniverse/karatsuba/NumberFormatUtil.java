package com.juniverse.karatsuba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Da formato de miles (configuración regional es-MX) a números dados como texto.
 *
 * @author ajuar
 */
public final class NumberFormatUtil {

    /** Clase de utilidades: no se instancia. */
    private NumberFormatUtil() {
    }

    /**
     * Formatea un número con separador de miles conservando todos sus decimales.
     * @param num número como texto, p. ej. "1234567.891"
     * @return número formateado, p. ej. "1,234,567.891"
     */
    public static String getFormat(String num) {
        // Usa coma como separador de miles
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.of("es", "MX"));
        if (num.contains(".")) {
            BigDecimal value = new BigDecimal(num);
            // Por defecto NumberFormat redondea a 3 decimales: se amplía para no perder precisión
            numberFormat.setMaximumFractionDigits(Math.max(value.scale(), 0));
            return numberFormat.format(value);
        } else {
            return numberFormat.format(new BigInteger(num));
        }
    }
}
