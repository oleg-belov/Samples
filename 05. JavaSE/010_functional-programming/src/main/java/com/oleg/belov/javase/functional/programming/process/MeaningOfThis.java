package com.oleg.belov.javase.functional.programming.process;

public class MeaningOfThis {
	public final int value = 4;
	
	@SuppressWarnings("unused")
	public static void run() {
		System.out.println(">>>>>>>>>>>>>>>>MeaningOfThis<<<<<<<<<<<<<<<<<<<<<<<");
		
		int value = 6;
		
		Runnable r = new Runnable() {
			public final int value = 5;
			public void run(){
				int value = 10;
				System.out.println(this.value);
			}
		};
		
		r.run(); 
		
		System.out.println("--------------------------------------------------------");
	}
}
