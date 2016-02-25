import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortNumbers {

	public static void main(String[] args) {
		
		ArrayList<Number> digits = new ArrayList<Number>();
		
		digits.add(23.47);
		digits.add(13.32);
		digits.add(4285.44398);
		digits.add(4);
		digits.add(99.99);
		digits.add(25.3);
		
		sort(digits);
		
		for (Number n : digits)
		    System.out.println(n);

	}
	
	public static void sort(ArrayList<Number> list) {
		Collections.sort(list, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				Double o1double = Double.valueOf(o1.toString());
				Double o2double = Double.valueOf(o2.toString());
				return o2double.compareTo(o1double);
			}
		});
	}

}
