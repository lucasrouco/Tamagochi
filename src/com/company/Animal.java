package com.company;

public class Animal implements IAnimal {

    private String especie;
    private String tipoDeAnimal;
    private int hambre;
    private int salud;
    private int resistencia;
    private int limiteHambre = 100;
    private int limiteSalud = 100;
    private int limiteResistencia = 100;

    public Animal(String especie, String tipoDeAnimal, int hambre, int salud, int resistencia) {
        this.especie = especie;
        this.tipoDeAnimal = tipoDeAnimal;
        this.hambre = hambre;
        this.salud = salud;
        this.resistencia = resistencia;
    }

    @Override
    public void restarHambre(int hambreGastada) {
        this.hambre = this.hambre - hambreGastada;
        if(getHambre() < 0){
            this.setHambre(0);
        }
    }

    @Override
    public void restarSalud(int saludGastada) {
        this.salud = this.salud - saludGastada;
        if(getSalud() < 0){
            this.setSalud(0);
        }
    }

    @Override
    public void restarResistencia(int resistenciaGastada) {
        this.resistencia = this.resistencia - resistenciaGastada;
        if(getResistencia() < 0){
            this.setResistencia(0);
        }
    }

    @Override
    public void sumarHambre(int hambreSumada) {
        this.hambre = this.hambre + hambreSumada;
        if(getHambre() > 100){
            this.setHambre(100);
        }
    }

    @Override
    public void sumarResistencia(int resistenciaSumada) {
        this.resistencia = this.resistencia + resistenciaSumada;
        if(getResistencia() > 100){
            this.setResistencia(100);
        }
    }

    @Override
    public void sumarSalud(int saludSumada) {
        this.salud = this.salud + saludSumada;
        if(getSalud() > 100){
            this.setSalud(100);
        }
    }

    @Override
    public void sumarLimiteHambre(int limiteHambreSumado) { this.limiteHambre = this.limiteHambre + limiteHambreSumado; }

    @Override
    public void sumarLimiteResistencia(int limiteResistenciaSumada) { this.limiteResistencia = this.limiteResistencia + limiteResistenciaSumada; }

    @Override
    public void sumarLimiteSalud(int limiteSaludSumada) { this.limiteSalud = this.limiteSalud + limiteSaludSumada; }

    @Override
    public void agregarAccesorio(int resistencia, int hambre, int salud, int limiteResistencia, int limiteHambre, int limiteSalud){}

    /*
    GETTERS Y SETTERS
     */

    @Override
    public String getEspecie() {
        return especie;
    }

    public String getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public int getHambre() {
        return hambre;
    }

    public int getSalud() {
        return salud;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setEspecie(String especie) { this.especie = especie; }

    public void setTipoDeAnimal(String tipoDeAnimal) { this.tipoDeAnimal = tipoDeAnimal; }

    public int getLimiteHambre() { return limiteHambre; }

    public void setLimiteHambre(int limiteHambre) { this.limiteHambre = limiteHambre; }

    public int getLimiteSalud() { return limiteSalud; }

    public void setLimiteSalud(int limiteSalud) { this.limiteSalud = limiteSalud; }

    public int getLimiteResistencia() { return limiteResistencia; }

    public void setLimiteResistencia(int limiteResistencia) { this.limiteResistencia = limiteResistencia; }

    @Override
    public void realizarAccionSegunTipoDeAnimal() {
        switch (this.getTipoDeAnimal()) {
            case "Terrestre":
                if(this.getHambre() > 5 && this.getResistencia() >= 5 && this.getSalud() >= 5) {
                    System.out.println("Estoy sacando a pasear a el/la: " + this.getEspecie());
                    this.restarSalud(5);
                    this.restarHambre(5);
                    this.restarResistencia(5);
                } else {
                    this.noSePuedeRealizarLaAccion();
                }
                break;
            case "Volador":
                if(this.getHambre() >= 2 && this.getResistencia() >= 5 && this.getSalud() >= 3){
                    System.out.println("El/La : " + this.getEspecie() + " esta volando");
                    this.restarSalud(10);
                    this.restarHambre(2);
                    this.restarResistencia(5);
                } else {
                    this.noSePuedeRealizarLaAccion();
                }
                break;
            case "Acuatico":
                if(this.getHambre() >= 5 && this.getResistencia() >= 7 && this.getSalud() >= 1){
                    System.out.println("El/La: " + this.getEspecie() + " esta nadando en el lago");
                    this.restarSalud(1);
                    this.restarHambre(5);
                    this.restarResistencia(7);
                } else {
                    this.noSePuedeRealizarLaAccion();
                }
                break;
        }
    }

    public void noSePuedeRealizarLaAccion(){
        System.out.println("Lo siento, no puedes sacar a pasear a: " + this.getEspecie() + " su resistencia, salud o hambre son muy bajos");
    }

    public void mostrarDatosAnimal() {
        System.out.println("Especie: " + this.getEspecie());
        System.out.println("Tipo de Animal: " + this.getTipoDeAnimal());
        System.out.println("Hambre: " + this.getHambre());
        System.out.println("Resistencia: " + this.getResistencia());
        System.out.println("Salud: " + this.getSalud());
        System.out.println("Limite Hambre: " + this.getLimiteHambre());
        System.out.println("Limite Resistencia: " + this.getLimiteResistencia());
        System.out.println("Limite Salud: " + this.getLimiteSalud());
        System.out.println("");
    }
}
