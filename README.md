# Multiplicación de Karatsuba

Implementación del algoritmo de Karatsuba para multiplicar números enormes, enteros o decimales, trabajando con `BigInteger`.

## Características

- Karatsuba recursivo: 3 multiplicaciones en lugar de 4, O(n^1.585).
- Umbral configurable: por debajo usa la multiplicación estándar.
- Soporta decimales y números negativos pasando los factores como texto.
- Salida con separador de miles y todos los decimales.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Estructura

```text
src/main/java/com/juniverse/karatsuba/
├── Main.java
├── Karatsuba.java
└── NumberFormatUtil.java
```

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-karatsuba-1.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
