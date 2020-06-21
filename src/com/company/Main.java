package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RepositorioAnimales repository = new RepositorioAnimales();

        Usuario usuario = new Usuario("Lucas");
        int numero0 = 1;

        while(numero0 == 1 || numero0 == 2 || numero0 == 3 || numero0 == 4) {
            System.out.println("");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Mostrar Datos de los Animales en Posesion");
            System.out.println("2. Agregar accesorios a algun animal... ptss modifica sus valores");
            System.out.println("3. Realizar alguna accion con algunos de los animales");
            System.out.println("4. Agregar animales");
            System.out.println("5. Salir");

            Scanner num1 = new Scanner(System.in);
            numero0 = num1.nextInt();

            switch (numero0) {
                case 1:
                    usuario.mostrarAnimalesEnPosesion();
                    break;
                case 2:
                    usuario.agregarAccesorio();
                    break;
                case 3:
                    usuario.realizarAccionAnimal();
                    break;
                case 4:
                    repository.mostrarAnimales();

                    Scanner num2 = new Scanner(System.in);
                    int numero2 = num2.nextInt();

                    usuario.agregarAnimal(repository.getAnimales().get(numero2));
                    System.out.println("Agregado con exito");

                    break;
            }
        }
    }
}
