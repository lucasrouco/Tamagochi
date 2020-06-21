package com.company;

import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.client.model.Projections;
import org.bson.Document;
import com.mongodb.MongoClient;


public class BaseDeDatos {

    private MongoClient mongo;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private FindIterable<Document> iterDoc;
    private Iterator it;

    public BaseDeDatos(){
        this.mongo = new MongoClient( "localhost" , 27017 );
        this.database = this.mongo.getDatabase("Desarrollo_de_Sistemas");
        this.collection = database.getCollection("animales");
        this.iterDoc = collection.find();
        this.it = iterDoc.iterator();
    }

    public MongoClient getMongo() {
        return mongo;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public FindIterable<Document> getIterDoc() {
        return iterDoc;
    }

    public Iterator getIt() {
        return it;
    }

    public ArrayList<String[]> getDocuments(){
        int i = 1;
        ArrayList<String []> dataAnimales = new ArrayList<String []>();

        while (getIt().hasNext()) {
            String [] dataAnimalIndividual = new String[3];
            String document = getIt().next().toString();
            int indiceEspecie = document.indexOf("especie");
            int indiceEspecieIgual = document.indexOf("=", indiceEspecie);
            int indiceEspecieComa = document.indexOf(",", indiceEspecie);
            String especie = document.substring(indiceEspecieIgual + 1, indiceEspecieComa);
            int indiceTipoDeAnimal = document.indexOf("tipoDeAnimal");
            int indicetipoDeAnimalIgual = document.indexOf("=", indiceTipoDeAnimal);
            int indicetipoDeAnimalComa = document.indexOf(",", indiceTipoDeAnimal);
            String tipoDeAnimal = document.substring(indicetipoDeAnimalIgual + 1, indicetipoDeAnimalComa);
            int indiceEdad = document.indexOf("edad");
            int indiceEdadIgual = document.indexOf("=", indiceEdad);
            int indiceEdadLlave = document.indexOf("}", indiceEdad);
            String edad = document.substring(indiceEdadIgual + 1, indiceEdadLlave);
            i++;
            dataAnimalIndividual[0] = especie;
            dataAnimalIndividual[1] = tipoDeAnimal;
            dataAnimalIndividual[2] = edad;

            dataAnimales.add(dataAnimalIndividual);
        }

        return dataAnimales;

    }

}
