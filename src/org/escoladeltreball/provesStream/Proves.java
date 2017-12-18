/**
 * 
 */
package org.escoladeltreball.provesStream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author iaw26068632
 *
 */
public class Proves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		System.out.println("REALIZAREMOS PRUEBAS DE STREAMS");
		
		// 1:
//		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
//		System.out.println(stream.limit(2).map(x -> x + "2"));
		
		// 2:
		// QUEDA EN INFINITO
		
//		Predicate<? super String> predicate = s -> s.startsWith("g");
//		Stream<String> stream1 = Stream.generate(() -> "growl! ");
//		Stream<String> stream2 = Stream.generate(() -> "growl! ");
//		boolean b1 = stream1.anyMatch(predicate);
////		boolean b2 = stream2.allMatch(predicate); // se soluciona con stream2.limit(2). ...
//		boolean b2 = false;
//		System.out.println(b1 + " " + b2);
		
		System.out.println("HA FINALIZADO");

		
		// 3:
		

//		Predicate<? super String> predicate = s -> s.length() > 3;
//		Stream<String> stream = Stream.iterate("-", (s) -> s + s);
//		boolean b1 = stream.noneMatch(predicate);
//		boolean b2 = stream.anyMatch(predicate);
//		System.out.println(b1 + " " + b2);
		
		
		// 8:
		
		IntStream is = IntStream.empty();
		
//		System.out.println(is.average());
//		System.out.println(is.sum());
//		System.out.println(is.findAny());
		
		// 9:
		
		LongStream ls = LongStream.of(1, 2, 3);
		OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5) .findFirst();
		if (opt.isPresent()) System.out.println(opt.getAsLong());
		opt.ifPresent(System.out::println);
		
		
		//10:
		
//		Stream.generate(() -> "1").limit(10).forEach(System.out::println);
//		Stream.generate(() -> "1").limit(10).peek(System.out::println);

		
		// REALIZAR EL PARALLEL CON EL FIN DE OBTENER LAS ESTACIONES ABIERTAS
		
		
		// 11:
		
		System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining()));
		
		Supplier<String> x = String::new; // no entra nada 
		BiConsumer<String, String> bicons = (a, b) -> System.out.println(); // entran dos parametros y void
		UnaryOperator<String> z = a -> a + a; // realiza una operación
		
		
		// 12:
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(4, 5, 6);
		List<Integer> l3 = Arrays.asList();
		Stream.of(l1, l2, l3)
		.flatMap(s -> s.stream()).map(s -> s + 1).forEach(System.out::print);


//
//		Stream<Integer> s = Stream.of(1);
//		IntStream iss = s.mapToInt(j -> j);
//		DoubleStream ds = s.mapToDouble(j -> j);
//		Stream<Integer> s2 = ds.mapToInt(j -> j);
//		s2.forEach(System.out::print);
	}

}
