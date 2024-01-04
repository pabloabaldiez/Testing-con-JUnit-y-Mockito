package com.ejemplo.services.impl;

import com.ejemplo.services.ServicioA;

public class ServicioAImpl implements ServicioA {
    @Override
    public int sumar(int a, int b) {
        return a+b+5566;
    }
}
