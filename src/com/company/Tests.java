package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
 * No se puede comparar ArrayLists porque a pesar de que
 * contengan la misma informacion el nombre con el que se
 * encuentran en memoria, que es por ejemplo
 * "LJava.lang.String;@1bb5a082" no coincide con los
 * ArrayList creados para cada test
 */

public class Tests {

    @Test
    void TestBringDataFromDataBase(){

        IAdapter testAdapter = new AdapterConcreto();

        ArrayList<String[]> dataForTest = new ArrayList<String[]>();

        String[] arreglo1 = {"Tigre", "Terrestre", "10"};
        String[] arreglo2 = {"Pez", "Acuatico", "2"};
        String[] arreglo3 = {"Aguila", "Volador", "15"};
        String[] arreglo4 = {"Leon", "Terrestre", "25"};
        String[] arreglo5 = {"Tiburon", "Acuatico", "94"};

        dataForTest.add(arreglo1);
        dataForTest.add(arreglo2);
        dataForTest.add(arreglo3);
        dataForTest.add(arreglo4);
        dataForTest.add(arreglo5);

        ArrayList<String[]> dataFromDB = testAdapter.getDataFromDB();

        assertEquals(dataFromDB.get(0)[0], dataForTest.get(0)[0]);

    }

    @Test
    void TestGetRelevantDataOnly(){

        IAdapter testAdapter = new AdapterConcreto();

        ArrayList<String[]> relevantDataForTest = new ArrayList<String[]>();

        String[] arreglo1 = {"Tigre", "Terrestre"};
        String[] arreglo2 = {"Pez", "Acuatico"};
        String[] arreglo3 = {"Aguila", "Volador"};
        String[] arreglo4 = {"Leon", "Terrestre"};
        String[] arreglo5 = {"Tiburon", "Acuatico"};

        relevantDataForTest.add(arreglo1);
        relevantDataForTest.add(arreglo2);
        relevantDataForTest.add(arreglo3);
        relevantDataForTest.add(arreglo4);
        relevantDataForTest.add(arreglo5);

        ArrayList<String[]> dataFromDB = testAdapter.getDataToCreate();

        assertEquals(dataFromDB.get(0)[0], relevantDataForTest.get(0)[0]);
    }

    @Test
    void TestArrayListAnimal(){

        RepositorioAnimales repository = new RepositorioAnimales();

        /*
         * Apenas se creo el repository, el constructor contiene metodos para
         * llamar a los metodos necesarios para llenar el ArrayList de
         * la clase con los valores correspondientes
         */

        ArrayList<IAnimal> animalesTest = new ArrayList<IAnimal>();

        IAnimal animal1 = new Animal("Tigre", "Terrestre", 100, 100, 100);
        IAnimal animal2 = new Animal("Pez", "Acuatico", 100, 100, 100);
        IAnimal animal3 = new Animal("Aguila", "Volador", 100, 100, 100);
        IAnimal animal4 = new Animal("Leon", "Terrestre", 100, 100, 100);
        IAnimal animal5 = new Animal("Tiburon", "Acuatico", 100, 100, 100);

        animalesTest.add(animal1);
        animalesTest.add(animal2);
        animalesTest.add(animal3);
        animalesTest.add(animal4);
        animalesTest.add(animal5);

        IAnimal animal = repository.getAnimales().get(0);

        assertEquals(animal.getEspecie(), animalesTest.get(0).getEspecie());
    }

    @Test
    void TestAgregarAnimal(){

        Usuario usuario = new Usuario("Lucas");

        ArrayList<IAnimal> animalForTest = new ArrayList<IAnimal>();

        animalForTest.add(new Animal("Tigre", "Terrestre", 100, 100, 100));

        usuario.agregarAnimal(new Animal("Tigre", "Terrestre", 100, 100, 100));

        ArrayList<IAnimal> animalFromUser = usuario.getAnimalesEnPosesion();

        assertEquals(animalForTest.get(0).getEspecie(), animalFromUser.get(0).getEspecie());
    }

    @Test
    void TestRealizarAccionAnimal(){
        Usuario usuario = new Usuario("Lucas");

        usuario.agregarAnimal(new Animal("Tigre", "Terrestre", 100, 100, 100));

        usuario.getAnimalesEnPosesion().get(0).realizarAccionSegunTipoDeAnimal();

        int saludAnimal = usuario.getAnimalesEnPosesion().get(0).getSalud();

        assertEquals(95, saludAnimal);
    }

    @Test
    void TestAgregarAccesorio(){
        Usuario usuario = new Usuario("Lucas");

        usuario.agregarAnimal(new Animal("Tigre", "Terrestre", 100, 100, 100));

        Anteojos anteojos = new Anteojos(usuario.getAnimalesEnPosesion().get(0));
        anteojos.agregarAccesorio();

        int limiteSaludAnimal = usuario.getAnimalesEnPosesion().get(0).getLimiteSalud();

        assertEquals(101, limiteSaludAnimal);
    }

}
