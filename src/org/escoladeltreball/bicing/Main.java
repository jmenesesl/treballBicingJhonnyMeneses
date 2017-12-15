/**
 * 
 */
package org.escoladeltreball.bicing;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author iaw26068632
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		class BicingDistanceComparator implements Comparator<StationBicing> {
			public int compare(StationBicing a, StationBicing b) {
				if (a.getDistance() < (b.getDistance()))
					return -1;
				if (a.getDistance() > (b.getDistance()))
					return 1;
				return 0;
			}
		}

		class BicingStreetNumberComparator implements Comparator<StationBicing> {
			public int compare(StationBicing a, StationBicing b) {
				return extractInt(a.getStreetNumber()) - (extractInt(b.getStreetNumber()));
			}

			int extractInt(String s) {
				s.trim();
				int number = 0;
				try {
					number = Integer.parseInt(s);
				} catch (Exception e) {
					number = 0;
				} finally {
					return number;
				}
			}

		}

		ReadFileJson.getJson();
		StationsBicingDAO stationsDAO = new StationsBicingDAO();
		int eleccion = -1;
		List<StationBicing> st = stationsDAO.getStations();

		Scanner s = new Scanner(System.in);

		System.out.print("Escoje una opción de la lista\n");
		System.out.println("*****************************\n");

		// System.out.println("Lista de todas las estaciones");
		// for(StationBicing station: st) {
		// System.out.println(station.toString());
		// }
		List<StationBicing> stationsUpThan;
		ArrayList<StationBicing> stations = (ArrayList<StationBicing>) stationsDAO.getStations();
		while (eleccion != 0) {
			System.out.println("Menú principal:\n");
			System.out.println("1.- Estaciones por encima de 41.38º");
			System.out.println("2.- Estaciones con altitud mayor de 50m");
			System.out.println("3.- Estaciones con más de una bicing, con cantidad");
			System.out.println("4.- Estaciones cerradas, con estado correspondiente");
			System.out.println("5.- Estaciones abiertas, ordenadas por nombre de calle y numero");
			System.out.println("6.- Estaciones mas cercanas a mi domicilio, determinar de que tipo es");
			System.out.println("7.- Estacion electrica mas cercanas a mi domicilio, determinar numero de bicis");
			System.out.println("introduce 0 para salir");

			eleccion = Integer.parseInt(s.nextLine());
			switch (eleccion) {
			case 1:
				stationsUpThan = stationsDAO.stationsUpThanLatitude(41.38);
				// for (StationBicing station : stationsUpThan) {
				// System.out.println(station.toString());
				// }
				System.out.println("\nREALIZADO CON STREAM Y LAMBDA\n");
				stations.stream().filter(p -> p.getLatitude() >= 41.38)
						.forEach(estacion -> System.out.println(estacion.toString()));
				System.out.println("Hay " + stationsUpThan.size() + " estaciones por encima de la altitud 41.38");
				break;
			case 2:
				stationsUpThan = stationsDAO.stationsUpThanAltitude(50.0);
				// for (StationBicing station : stationsUpThan) {
				// System.out.println(station.toString());
				// }
				System.out.println("\nREALIZADO CON STREAM Y LAMBDA\n");
				stations.stream().filter(p -> p.getAltitude() > 50.00)
						.forEach(estacion -> System.out.println(estacion.toString()));
				System.out.println("Hay " + stationsUpThan.size() + " estaciones por encima de la altitud 50m");
				break;

			case 3:

				stations.stream().filter(p -> p.getBikes() > 1).forEach(estacion -> System.out.println(
						"Codigo de estación: " + estacion.getId() + " Numero de Bicis: " + estacion.getBikes()));
				// System.out.println(stations.stream().filter(p -> p.getBikes() > 1).count());
				// // Cantidad de estaciones con mas de una bici
				break;

			case 4:
				// Suponiendo que las que no estén abiertas están cerradas
				stations.stream().filter(p -> !p.getStatus().equals("OPN")).forEach(estacion -> System.out.println(
						estacion.getStreetName() + " " + estacion.getStreetNumber() + " - " + estacion.getStatus()));
				 System.out.println(stations.stream().filter(p ->
				 !p.getStatus().equals("OPN")).count()); // Cantidad de resultados de estaciones cerradas
				break;

			case 5:
				/*
				 * A continuación construiré dos comparadores con el fin de realizar la
				 * comparación de el nombre de la calle y posteriormente realizar la comparación
				 * del numero de la calle teniendo en cuenta que el numero puede incluir letras
				 * ejemplo 21B
				 */

				/*
				 * realizo la ordenación utilizando metodo tradicional, y clase anonima dentro
				 * de la misma clase
				 * 
				 */
				Collections.sort(stations, new BicingStreetNumberComparator());
				Collections.sort(stations, new Comparator<StationBicing>() {
					@Override
					public int compare(StationBicing o1, StationBicing o2) {
						return o1.getStreetName().compareTo(o2.getStreetName());
					}

				});
				Collections.sort(stations, (p1, p2) -> p1.getStreetName().compareTo(p2.getStreetName())); // Otra forma
																											// de sort
																											// usando
																											// lambda

				stations.stream().filter(p -> p.getStatus().equals("OPN")).forEach(estacion -> System.out.println(
						estacion.getStreetName() + " " + estacion.getStreetNumber() + " - " + estacion.getStatus()));

				// System.out.println(stations.stream().filter(p ->
				// p.getStatus().equals("OPN")).count()); // para obtener la cantidad de
				// estaciones abiertas
				break;

			case 6:
				/*
				 * teniendo en cuenta que mi localización es: latitud: 41.4324 longitud:2.1761
				 * Este metodo se realiza de la siguiente forma: se añade una propiedad a cada
				 * estación la cual es la distancia desde mi punto establecido con el fin de
				 * posteriormente ordenar por aquel mismo campo. Finalmente imprime los 3
				 * primeros resultados del orden en pantalla
				 */
				for (StationBicing estacio : stations) {
					estacio.setDistance(
							stationsDAO.distanciaCoord(estacio.getLatitude(), estacio.getLongitude(), 41.4324, 2.1761));
					// System.out.println(estacio.getStreetName() + " " + estacio.getStreetNumber()
					// + " distancia: " + estacio.getDistance());
				}
				Collections.sort(stations, new Comparator<StationBicing>() {
					public int compare(StationBicing a, StationBicing b) {
						if (a.getDistance() < (b.getDistance()))
							return -1;
						if (a.getDistance() > (b.getDistance()))
							return 1;
						return 0;
					}
				});
				for (int i = 0; i <= 2; i++) {
					StationBicing near = stations.get(i);
					System.out.println(near.getId() + " " + near.getStreetName() + ", " + near.getStreetNumber() + " - "
							+ near.getType());
				}
				break;

			case 7:
				for (StationBicing estacio : stations) {
					estacio.setDistance(
							stationsDAO.distanciaCoord(estacio.getLatitude(), estacio.getLongitude(), 41.4324, 2.1761));
				}
				Collections.sort(stations, new BicingDistanceComparator());
				boolean encontrado = false;
				int i = 0;
				while (!encontrado) {
					if (stations.get(i).getType().equals("BIKE-ELECTRIC")) {
						StationBicing sb = stations.get(i);
						System.out.println(sb.getId() + " " + sb.getStreetName() + ", " + sb.getStreetNumber() + " - "
								+ sb.getType() + " Bicis: " + sb.getBikes());
						encontrado = true;
					}
					i++;
				}
				break;

			case 0:
				System.out.println("Bye");
				break;
			default:
				break;
			}
		}

	}

}
