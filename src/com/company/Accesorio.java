package com.company;

public abstract class Accesorio implements IAnimal {

    private IAnimal animal;

    public Accesorio(IAnimal animal){
        this.animal = animal;
    }

    @Override
    public void agregarAccesorio(int resistencia, int hambre, int salud, int limiteResistencia, int limiteHambre, int limiteSalud) {
        sumarResistencia(resistencia);
        sumarHambre(hambre);
        sumarSalud(salud);
        sumarLimiteResistencia(limiteResistencia);
        sumarLimiteHambre(limiteHambre);
        sumarLimiteSalud(limiteSalud);
    }

    @Override
    public void realizarAccionSegunTipoDeAnimal(){
        animal.realizarAccionSegunTipoDeAnimal();
    }

    @Override
    public void sumarLimiteHambre(int limiteHambreSumado){
        animal.sumarLimiteHambre(limiteHambreSumado);
    }

    @Override
    public void sumarLimiteResistencia(int limiteResistenciaSumada){
        animal.sumarLimiteResistencia(limiteResistenciaSumada);
    }

    @Override
    public void sumarLimiteSalud(int limiteSaludSumada){
        animal.sumarLimiteSalud(limiteSaludSumada);
    }

    @Override
    public void restarHambre(int hambreGastada){
        animal.restarHambre(hambreGastada);
    }

    @Override
    public void restarSalud(int saludGastada){
        animal.restarSalud(saludGastada);
    }

    @Override
    public void restarResistencia(int resistenciaGastada){
        animal.restarResistencia(resistenciaGastada);
    }

    @Override
    public void sumarHambre(int hambreSumada){
        animal.sumarHambre(hambreSumada);
    }

    @Override
    public void sumarResistencia(int resistenciaSumada){
        animal.sumarResistencia(resistenciaSumada);
    }

    @Override
    public void sumarSalud(int saludSumada){
        animal.sumarSalud(saludSumada);
    }

    @Override
    public void mostrarDatosAnimal(){ animal.mostrarDatosAnimal(); }

    @Override
    public String getEspecie(){
        return animal.getEspecie();
    }

    @Override
    public int getSalud(){ return animal.getSalud(); }

    @Override
    public int getLimiteSalud() { return animal.getLimiteSalud(); }

}
