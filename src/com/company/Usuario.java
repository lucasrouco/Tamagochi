package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private ArrayList<IAnimal> animalesEnPosesion;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.animalesEnPosesion = new ArrayList<IAnimal>();
    }

    public ArrayList<IAnimal> getAnimalesEnPosesion() {
        return animalesEnPosesion;
    }

    public void agregarAnimal(IAnimal animal) {
        this.getAnimalesEnPosesion().add(animal);
    }

    public void mostrarAnimalesEnPosesion(){
        for (int i = 0; i < this.getAnimalesEnPosesion().size() ; i++) {
            this.getAnimalesEnPosesion().get(i).mostrarDatosAnimal();
        }
    }

    public void realizarAccionAnimal(){

        if(this.getAnimalesEnPosesion().size() > 0){
            System.out.println("Seleccione un animal");
            for (int i = 0; i < this.getAnimalesEnPosesion().size() ; i++) {
                System.out.println(i + ". " + this.getAnimalesEnPosesion().get(i).getEspecie());
            }

            Scanner numeroParaAnimal = new Scanner(System.in);
            int indiceAnimal = numeroParaAnimal.nextInt();

            this.getAnimalesEnPosesion().get(indiceAnimal).realizarAccionSegunTipoDeAnimal();
        } else {
            System.out.println("No tiene ningun animal en posesion");
        }

    }

    public void agregarAccesorio(){
        System.out.println("Seleccione un animal");
        for (int i = 0; i < this.getAnimalesEnPosesion().size() ; i++) {
            System.out.println(i + ". " + this.getAnimalesEnPosesion().get(i).getEspecie());
        }

        Scanner num1 = new Scanner(System.in);
        int numero1 = num1.nextInt();

        System.out.println("Seleccione un accesorio");
        System.out.println("1. Anteojos");
        System.out.println("2. Sombrero");
        System.out.println("3. Collar");
        System.out.println("Cualquier otro numero no hara nada");

        Scanner num2 = new Scanner(System.in);
        int numero2 = num2.nextInt();
        switch (numero2){
            case 1:
                Anteojos anteojos = new Anteojos(this.getAnimalesEnPosesion().get(numero1));
                anteojos.agregarAccesorio();
                break;
            case 2:
                Sombrero sombrero = new Sombrero(this.getAnimalesEnPosesion().get(numero1));
                sombrero.agregarAccesorio();
                break;
            case 3:
                Collar collar = new Collar(this.getAnimalesEnPosesion().get(numero1));
                collar.agregarAccesorio();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
                break;

        }
    }
}
