/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Partido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mehdi
 */
public class LogicaAplicacion {

    private final String NOMBRE_FICHERO = "partido.dat";
    private List<Partido> partidos = new LinkedList<>();

    public LogicaAplicacion() {
        cargarFichero();
    }

    public boolean altaNuevoPartido(Partido p) {
        return partidos.add(p);
    }

    public Partido borradoPartido(int i) throws Exception {
        Partido partido = null;
        if (i < partidos.size() && i >= 0) {
            partido = partidos.remove(i);
        } else {
            System.out.println("Posición no encontrada");
        }
        return partido;
    }

    public List<Partido> listaPartidosOrdenados(String ascDesc) {
        LinkedList<Partido> copia = new LinkedList<>(partidos);
        if (ascDesc.equals("ascendente")) {
            Collections.sort(copia);
        } else {
            Collections.sort(copia, new Comparator<Partido>() {
                @Override
                public int compare(Partido p1, Partido p2) {
                    return p2.getFecha().compareTo(p1.getFecha());
                }
            });
        }
        return copia;
    }

    public List<Partido> listaPartidosDivision(Partido.Divisiones d) {
        List<Partido> partidosDivision = new ArrayList<>();
        for (Partido partido : partidos) {
            if (partido.getDivision().equals(d)) {
                partidosDivision.add(partido);
            }
        }
        return partidosDivision;
    }

    private void cargarFichero() {
        File f = new File(NOMBRE_FICHERO);
        if (f.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            LinkedList<Partido> listaPartidos = null;
            try {
                fis = new FileInputStream(NOMBRE_FICHERO);
                ois = new ObjectInputStream(fis);
                listaPartidos = (LinkedList<Partido>) ois.readObject();
                partidos = listaPartidos;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void guardarEnFichero() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO, true));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}
