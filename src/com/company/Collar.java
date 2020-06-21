package com.company;

public class Collar extends Accesorio {

    public Collar(IAnimal animal) {
        super(animal);
    }

    public void agregarAccesorio() {
        super.agregarAccesorio(5, 2, 4, 1, 1, 1);
    }
}
