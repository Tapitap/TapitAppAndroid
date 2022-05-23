package com.tapitapp.tapitapp.util;

import java.text.DecimalFormat;

public class Util {

    public static double MultRound(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }

    public static String NumberFormat(double numero){
        String patron = "0.00";
        DecimalFormat formato = new DecimalFormat(patron);
        return formato.format(numero);
    }
}
