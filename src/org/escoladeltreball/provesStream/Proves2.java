/**
 * 
 */
package org.escoladeltreball.provesStream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author iaw26068632
 *
 */
public class Proves2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l1 = Arrays.asList("armario", "bueno", "coco", "casa", "cantar");

		Stream<String> s = l1.stream();
		Stream<String> s2 = l1.stream();
		Map<Boolean, List<String>> p = s.collect(
		Collectors.partitioningBy(b -> b.startsWith("c")));
		Map<Boolean, List<String>> g = s2.collect(
		Collectors.groupingBy(b -> b.startsWith("c")));
		System.out.println(p + " " + g);
		
		
		UnaryOperator<Integer> u = x -> x * x;
		u.apply(3);
		System.out.println(u.toString());


	}

}
