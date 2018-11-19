/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partidos;

import Logica.LogicaAplicacion;
import Modelo.Partido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mehdi
 */
public class Partidos {

    private static void menu() {
        System.out.println("             MENU");
        System.out.println("1- Dar de alta un nuevo partido.");
        System.out.println("2- Mostar listado.");
        System.out.println("3- Borrado de un partido.");
        System.out.println("4- Mostrar los partidos ordenados.");
        System.out.println("5- Mostrar partidos de una división.");
        System.out.println("6- Salir y guardar.");
        System.out.println("");
    }

    public static void mostrarListadoPartidos(List<Partido> lista) {
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + "\t");
                System.out.println(lista.get(i));
            }
        } else {
            System.out.println("Lista vacia.");
        }
    }

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Scanner teclado = new Scanner(System.in);
        Logica.LogicaAplicacion l = new LogicaAplicacion();
        boolean salir = false;
        int opcion;

        String local, visit, result;
        Date fecha = null;
        int division;
        Partido.Divisiones d = null;
        do {
            menu();
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del equipo local: ");
                    local = teclado.nextLine();
                    System.out.println("Introduce el nombre del equipo visitante: ");
                    visit = teclado.nextLine();
                    System.out.println("Introduce el resultado: ");
                    result = teclado.nextLine();
                    System.out.println("Divisiones a elegir: \n1- PRIMERA \n2- SEGUNDA \n3- TERCERA");
                    System.out.println("Introduce el número de la Division: ");
                    division = Integer.parseInt(teclado.nextLine());

                    switch (division) {
                        case 1:
                            d = Partido.Divisiones.PRIMERA;
                            break;
                        case 2:
                            d = Partido.Divisiones.SEGUNDA;
                            break;
                        case 3:
                            d = Partido.Divisiones.TERCERA;
                            break;
                    }

                    System.out.println("Introduce una fecha en formato dd/MM/yy");
                    String f = teclado.nextLine();
                     {
                        try {
                            fecha = sdf.parse(f);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                    }

                    Partido p = new Partido(local, visit, result, d, fecha);
                    System.out.println(p.toString());
                    l.altaNuevoPartido(p);
                    break;
                case 2:
                    mostrarListadoPartidos(l.getPartidos());
                    break;
                case 3:
                    System.out.println("Introduce el numero de partido: ");
                    int num = Integer.parseInt(teclado.nextLine());
                    try {
                        l.borradoPartido(num);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Orden ascendente o descendente?");
                    String orden = teclado.nextLine();
                    mostrarListadoPartidos(l.listaPartidosOrdenados(orden));
                    break;

                case 5:
                    System.out.println("Introduce numero de la Division (1, 2 o 3): ");
                    division = Integer.parseInt(teclado.nextLine());

                    switch (division) {
                        case 1:
                            d = Partido.Divisiones.PRIMERA;
                            break;
                        case 2:
                            d = Partido.Divisiones.SEGUNDA;
                            break;
                        case 3:
                            d = Partido.Divisiones.TERCERA;
                            break;
                    }
                    mostrarListadoPartidos(l.listaPartidosDivision(d));
                    break;
                case 6:
                    salir = true;
                    l.guardarEnFichero();
                    break;
            }
        } while (!salir);

    }
}
