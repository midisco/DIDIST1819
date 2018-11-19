/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;

/**
 *
 * @author Mehdi
 */
public class Planeta {
    private String nombre;
    private double ejeMayor;
    private double periodoDias;
    private double excentricidad;
    
    public Planeta(String nom, double eje, double periodo, double excen){
        this.nombre=nom;
        this.ejeMayor=eje;
        this.periodoDias=periodo;
        this.excentricidad=excen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEjeMayor() {
        return ejeMayor;
    }

    public void setEjeMayor(double ejeMayor) {
        this.ejeMayor = ejeMayor;
    }

    public double getPeriodoDias() {
        return periodoDias;
    }

    public void setPeriodoDias(double periodoDias) {
        this.periodoDias = periodoDias;
    }

    public double getExcentricidad() {
        return excentricidad;
    }

    public void setExcentricidad(double excentricidad) {
        this.excentricidad = excentricidad;
    }

    @Override
    public String toString() {
        return "Planeta{" + "nombre=" + nombre + ", ejeMayor=" + ejeMayor + ", periodoDias=" + periodoDias + ", excentricidad=" + excentricidad + '}';
    }
    
    public String[] toStringArray(){
        String [] s = new String[4];
        s[0] = nombre;
        s[1] = ejeMayor == -1 ? "" : Double.toString(ejeMayor);
        s[2] = periodoDias == -1 ? "" : Double.toString(periodoDias);
        s[3] = excentricidad == -1 ? "" : Double.toString(excentricidad);
        return s;
    }
}
