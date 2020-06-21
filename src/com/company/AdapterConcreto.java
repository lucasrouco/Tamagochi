package com.company;

import java.util.ArrayList;

public class AdapterConcreto implements IAdapter{

    private BaseDeDatos baseDeDatos;
    private ArrayList<String []> dataAnimales = new ArrayList<String []>();

    public AdapterConcreto(){
        this.baseDeDatos = new BaseDeDatos();
        this.dataAnimales = this.baseDeDatos.getDocuments();
    }

    @Override
    public ArrayList<String[]> getDataFromDB() {
        return dataAnimales;
    }

    @Override
    public ArrayList<String []> getDataToCreate() {
        ArrayList<String []> dataRelevante = new ArrayList<String[]>();
        for(int i = 0 ; i < this.getDataFromDB().size() ; i++) {
            String [] dataAnimalIndividual = new String[2];
            dataAnimalIndividual[0] = this.getDataFromDB().get(i)[0];
            dataAnimalIndividual[1] = this.getDataFromDB().get(i)[1];
            dataRelevante.add(dataAnimalIndividual);
        }
        return dataRelevante;
    }
}
