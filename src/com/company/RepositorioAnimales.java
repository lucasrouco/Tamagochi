package com.company;

import java.util.ArrayList;

public class RepositorioAnimales implements IRepository {

    private ArrayList<IAnimal> animales = new ArrayList<IAnimal>();
    private IAdapter adapter;

    public RepositorioAnimales(){
        this.adapter = new AdapterConcreto();
        this.createAnimal();
    }

    @Override
    public ArrayList<String []> getDataFromAdapter(){
        return this.adapter.getDataToCreate();
    }

    public ArrayList<IAnimal> getAnimales() { return animales; }

    @Override
    public void createObject(){
        this.createAnimal();
    }

    public void createAnimal(){
        for(int i = 0 ; i < this.getDataFromAdapter().size() ; i++){
            String especie = this.getDataFromAdapter().get(i)[0];
            String tipoDeAnimal = this.getDataFromAdapter().get(i)[1];
            this.getAnimales().add(new Animal(especie, tipoDeAnimal, 100, 100, 100));
        }
    }

    public void mostrarAnimales(){
        for (int i = 0; i < this.getAnimales().size(); i++) {
            System.out.println(i+ ": " + this.getAnimales().get(i).getEspecie());
        }
    }


}
