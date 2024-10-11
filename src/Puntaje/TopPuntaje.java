package Puntaje;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopPuntaje {
    
    private PriorityQueue<PuntajeJugador> listadeJugadores;
    private static final int MAX_ELEMENTOS = 5;
    @SuppressWarnings("ConstantName")
    private static final String archivoDeGuardado = "TOP5.csv";
    
    public TopPuntaje() {
        listadeJugadores = new PriorityQueue<>(5,new ComparadorJugadores());
    }

    public void agregarJugador(String cadena, int numero) {
        cargarLista();
        if(listadeJugadores.size()==MAX_ELEMENTOS) {
            listadeJugadores.remove();
        }
        PuntajeJugador ganador = new PuntajeJugador(cadena, numero);
            listadeJugadores.add(ganador);
        guardarLista();
    }

    public PriorityQueue<PuntajeJugador> obtenerListadeJugadores() {
        cargarLista();
        return listadeJugadores;
    }

    public void guardarLista() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoDeGuardado, false))) {
            for (PuntajeJugador jugador : listadeJugadores) {
                writer.write(jugador.getNombre() + "," + jugador.getScore() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errir al guardar la lista");
        }
    }
    

    public void cargarLista() {
        listadeJugadores.clear(); // Limpiar la lista antes de cargarla nuevamente
        try (Scanner scanner = new Scanner(new File(archivoDeGuardado))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                String nombre_del_Jugador = partes[0].trim();
                int puntuacion = Integer.parseInt(partes[1].trim());
                listadeJugadores.add(new PuntajeJugador(nombre_del_Jugador, puntuacion));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errir al cargar la lista");
        }
    }
    
    
}