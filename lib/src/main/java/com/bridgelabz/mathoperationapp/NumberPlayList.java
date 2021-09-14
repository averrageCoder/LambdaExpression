package com.bridgelabz.mathoperationapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberPlayList {

	public static void main(String[] args) {
		
		List<Integer> myNumberList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			myNumberList.add(i);
		}
		
		//
		Iterator<Integer> itr = myNumberList.iterator();
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println("Method1: Iterator value::"+i);
		}
		
		//
		class MyConsumer implements Consumer<Integer> {
			@Override
			public void accept(Integer t) {
				System.out.println("Method2: Comsumer impl value::"+t);
			}
		}
		
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
		
		//
		myNumberList.forEach(new Consumer<Integer>() {		
			public void accept (Integer t) {
				System.out.println("Method3: forEach Anonymouse class value::"+t);
			}	
		});
		
		//
		Consumer<Integer> myListAction = n-> {
			System.out.println("Method4: forEach Lambda impl value::"+n);
		};
		myNumberList.forEach(myListAction);
		
		//
		myNumberList.forEach(n-> {
			System.out.println("Method5: foreach lambda impl value::"+n);
		});
		
		//
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
		myNumberList.forEach(n -> {
			System.out.println("Method6: forEach lambda double value::"+toDoubleFunction.apply(n));
		});
		
		//
		Predicate<Integer> isEvenFunction = n -> n>0 && n%2 ==0;
		myNumberList.forEach(n-> {
			System.out.println("Method7: forEach value of: "+n+" check for even: "+isEvenFunction.test(n));
		});
		
		//
		myNumberList.stream().forEach(n -> {
			System.out.println("Method8: processing of stream::"+n);
		});
		
		//
		List<Double> myDoubleList = myNumberList.stream()
									.filter(isEvenFunction)
									.map(toDoubleFunction)
									.collect(Collectors.toList());
		System.out.println("Method9: transforming stream and filtering::"+myDoubleList);
		
		//
		Integer firstEvenInteger = myNumberList.stream()
									.filter(isEvenFunction)
									.peek(n-> System.out.println("FirstEven number: "+n))
									.findFirst()
									.orElse(null);
		System.out.println("Method10: peek first even number::"+firstEvenInteger);
		
		//
		Integer minEvenInteger = myNumberList.stream()
									.filter(isEvenFunction)
									.min((n1,n2)-> n1-n2)
									.orElse(null);
		System.out.println("Method11: minimun even number::"+minEvenInteger);
		
		//
		Integer maxEvenInteger = myNumberList.stream()
									.filter(isEvenFunction)
									.max((n1,n2)-> n1-n2)
									.orElse(null);
		System.out.println("Method11: maximum even number::"+maxEvenInteger);
		
		//
		Integer sum = myNumberList.stream().reduce(0, Integer::sum);
		long count = myNumberList.stream().count();
		
		System.out.println("Method12: Average ("+sum+"/"+count+")::"+sum/count);
		
		//
		boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
		boolean anyEven = myNumberList.stream().anyMatch(isEvenFunction);
		boolean noneEven = myNumberList.stream().noneMatch(isEvenFunction);
		
		System.out.println("Method13: ");
		System.out.println("All even: "+allEven);
		System.out.println("Any even: "+anyEven);
		System.out.println("None even: "+noneEven);
		
		//
		myNumberList.add(12);
		myNumberList.add(-2);
		myNumberList.add(54);
		myNumberList.add(10);
		List<Double> mySortedList = myNumberList.stream()
									.sorted()
									.map(toDoubleFunction)
									.collect(Collectors.toList());
		System.out.println("Method14: sorted list::"+mySortedList);
	}

}
