package Service;

import java.util.HashSet;
import java.util.Scanner;

import Class.Libro;
import Utilidades.ComparatorLibro;
import java.util.Collections;

/*También se creará en el main un HashSet de tipo Libro que guardará todos los libros
creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus
datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le
pregunta al usuario si quiere crear otro Libro o no.
La clase Librería contendrá además los siguientes métodos:
Constructor por defecto.
Constructor con parámetros.
Métodos Setters/getters
Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo busca
en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método. El
método se incrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro que ingresó el usuario. Esto sucederá cada vez que se realice un
préstamo del libro. No se podrán prestar libros de los que no queden ejemplares
disponibles para prestar. Devuelve true si se ha podido realizar la operación y false en
caso contrario.
Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El
método decrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro seleccionado por el usuario. Esto sucederá cada vez que se
produzca la devolución de un libro. No se podrán devolver libros donde que no tengan
ejemplares prestados. Devuelve true si se ha podido realizar la operación y false en
caso contrario.
Método toString para mostrar los datos de los libros. */

public class ServiceLibro {
	
	public HashSet<Libro> listaLibro = new HashSet<Libro>();
	Scanner sc = new Scanner(System.in).useDelimiter("\n");
	
	public HashSet<Libro> agregarLibro(){
		char o;
		do {
			Libro l = new Libro();
			System.out.println("ingrese el titulo del libro");
			l.setTitulo(sc.next());
			System.out.println("ingrese el autor del libro");
			l.setAutor(sc.next());
			System.out.println("ingrese el cantidad de ejemplares del libro");
			l.setEjemplares(sc.nextInt());
			System.out.println("ingrese el cantidad de ejemplares prestados del libro");
			l.setPrestados(sc.nextInt());
			
			this.listaLibro.add(l);
			System.out.println("Quiere cargar otro libro, ingrese S para si, o N no");
			o = sc.next().toLowerCase().charAt(0);
			
		}while(o == 's');
		
		return this.listaLibro;
		
	}
	
	
	public HashSet<Libro> prestamo(){
		System.out.println("Ingrese el libro que quiere prestar");
		String nombre = sc.next();
		
		for(Libro l : this.listaLibro) {
			if(l.getTitulo().equalsIgnoreCase(nombre)) {
				if(l.getPrestados()<l.getEjemplares()) {
				l.setPrestados(l.getPrestados()+1);
				System.out.println("El libro ha sido prestado correctamente");
				System.out.println("La cantidad disponible actual es de : " + l.getDisponibles());
				} else {
					System.out.println("No hay ejemplares disponibles para prestar");
				}
			}
			return this.listaLibro;	
			}
		System.out.println("El libro ingresado, no fue encontrado BRO");
		return null;
		}
	
	public HashSet<Libro> devolver(){
		System.out.println("Ingrese el libro que quiere devolver");
		String nombre = sc.next();
		
		for(Libro l : this.listaLibro) {
			if(l.getTitulo().equalsIgnoreCase(nombre)) {
				if(l.getPrestados()>0) {
				l.setPrestados(l.getPrestados()-1);
				System.out.println("El libro ha sido devuelto correctamente");
				System.out.println("La cantidad disponible actual es de : " + l.getDisponibles());
				} else {
					System.out.println("imposible devolver un libro que no se presto");
				}
			}
			return this.listaLibro;	
			}
		System.out.println("El libro ingresado, no fue encontrado BRO");
		return null;
		}
	
	
	public void mostrarListado() {
        for (Libro libro : this.listaLibro) {
            System.out.println(libro.toString());
        }
	}
	
	
	
}
