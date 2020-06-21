package com.company;

public class Anteojos extends Accesorio{

    public Anteojos(IAnimal animal) {
        super(animal);
    }

    public void agregarAccesorio() {
        super.agregarAccesorio(1, 4, 2, 2, 0, 1);
    }
}
