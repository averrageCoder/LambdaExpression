package com.bridgelabz.mathoperationapp;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
}

public class MathOperationApp {

	public static void main(String[] args) {
		
		IMathFunction add = (int a, int b) -> a+b;
		IMathFunction subtract = (int a, int b) -> a-b;
		IMathFunction multiply = (int a, int b) -> a*b;
		IMathFunction divide = (int a, int b) -> a/b;
		
		System.out.println("Addition is "+add.calculate(6, 3));
		System.out.println("Subtraction is "+subtract.calculate(6, 3));
		System.out.println("Multiplication is "+multiply.calculate(6, 3));
		System.out.println("Division is "+divide.calculate(6, 3));

	}

}
