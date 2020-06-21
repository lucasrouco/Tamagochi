package com.company;

public interface IAnimal {

    public void realizarAccionSegunTipoDeAnimal();

    public void agregarAccesorio(int resistencia, int hambre, int salud, int limiteResistencia, int limiteHambre, int limiteSalud);

    public void sumarLimiteHambre(int limiteHambreSumado);

    public void sumarLimiteResistencia(int limiteResistenciaSumada);

    public void sumarLimiteSalud(int limiteSaludSumada);

    public void restarHambre(int hambreGastada);

    public void restarSalud(int saludGastada);

    public void restarResistencia(int resistenciaGastada);

    public void sumarHambre(int hambreSumada);

    public void sumarResistencia(int resistenciaSumada);

    public void sumarSalud(int saludSumada);

    public void mostrarDatosAnimal();

    public String getEspecie();

    public int getSalud();

    public int getLimiteSalud();
}
