package Main;

import Service.ServiceLibro;

public class MainLibro {
	public static void main(String[] args) {
		ServiceLibro sl = new ServiceLibro();
		System.out.println(sl.agregarLibro());
		System.out.println(sl.prestamo());
		System.out.println(sl.devolver());
	}

}
