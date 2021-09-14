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
	}

}
