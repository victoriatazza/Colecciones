package Utilidades;

import java.util.Comparator;

import Class.Libro;

public class ComparatorLibro {
	

    public static Comparator <Libro> libroAscendente = new Comparator<Libro>(){
        @Override
        public int compare(Libro t1, Libro t2) {

            return t2.getTitulo().compareTo(t1.getTitulo());
        }

    };
}
