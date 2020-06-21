package com.company;

public class Sombrero extends Accesorio {

    public Sombrero(IAnimal animal) {
        super(animal);
    }

    public void agregarAccesorio() {
        super.agregarAccesorio(3, 1, 2, 0, 3, 0);
    }
}
