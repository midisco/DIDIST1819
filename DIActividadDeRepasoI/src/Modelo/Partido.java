/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mehdi
 */
public class Partido implements Serializable, Comparable<Partido> {

    private String local, visitante, resultado;
    private Divisiones division;
    private Date fecha;

    public enum Divisiones {
        PRIMERA, SEGUNDA, TERCERA
    }

    public Partido(String local, String visit, String resul, Divisiones div, Date fecha) {
        this.local = local;
        this.visitante = visit;
        this.resultado = resul;
        this.division = div;
        this.fecha = fecha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Divisiones getDivision() {
        return division;
    }

    public void setDivision(Divisiones division) {
        this.division = division;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" + "local=" + local + ", visitante=" + visitante + ", resultado=" + resultado + ", division=" + division + ", fecha=" + fecha + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public int compareTo(Partido o) {
        return this.fecha.compareTo(o.fecha);
    }
}
