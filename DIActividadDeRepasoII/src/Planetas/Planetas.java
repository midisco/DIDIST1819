/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Mehdi
 */
public class Planetas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
            CSVReader reader = new CSVReader(new FileReader("exoplanetas.csv"), ',');
            String[] nextLine;
            List<Planeta> listaPlanetas=new ArrayList<Planeta>();
            reader.readNext();
            while((nextLine = reader.readNext())!=null){
                double eje=-1;
                if(!"".equals(nextLine[1]))
                    eje=Double.parseDouble(nextLine[1]);
                
                double dias=-1;
                if(!"".equals(nextLine[2]))
                    dias=Double.parseDouble(nextLine[2]);
                
                double excen=-1;
                if(!"".equals(nextLine[3]))
                    excen=Double.parseDouble(nextLine[3]);
                
                listaPlanetas.add(new Planeta(nextLine[0], eje, dias, excen));
            }
            
            double mediaeje=0.0;
            int numExcentricidadNo=0;
            int numOrbitaMas30=0;
            int numPlanetasKepler=0;
            int contador=0;
            
            for(Planeta planeta: listaPlanetas){
                if(planeta.getEjeMayor()>=0){
                    mediaeje=mediaeje+planeta.getEjeMayor();
                    contador++;
                }
                if(planeta.getPeriodoDias()>30)
                    numOrbitaMas30++;
                if(planeta.getExcentricidad()==-1)
                    numExcentricidadNo++;
                if(planeta.getNombre().startsWith("Kepler"))
                    numPlanetasKepler++;
            }
            
            mediaeje=mediaeje/contador;
            System.out.println("La media del eje mayor de todos los planetas es: " + mediaeje);
            System.out.println("Numero de planetas cuya orbita es mayor de 30: " + numOrbitaMas30);
            System.out.println("Numero de planetas de los que no se conoce su excentricidad: " + numExcentricidadNo);
            System.out.println("Numero de planetas descubiertos por Kepler: " + numPlanetasKepler);
            
            listaPlanetas.sort(new Comparator<Planeta>(){
                public int compare(Planeta p1, Planeta p2){
                    return Double.compare(p1.getEjeMayor(), p2.getEjeMayor());
                }
            });
            
            CSVWriter writer=new CSVWriter(new FileWriter("exoplanetasordenados.csv"));
            for(Planeta planeta: listaPlanetas){
                writer.writeNext(planeta.toStringArray());
            }
            
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
    
}
