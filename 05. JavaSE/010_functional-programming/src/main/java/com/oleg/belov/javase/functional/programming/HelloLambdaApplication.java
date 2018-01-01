package com.oleg.belov.javase.functional.programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oleg.belov.javase.functional.programming.process.CollectExample;
import com.oleg.belov.javase.functional.programming.process.CountMaxMinExamples;
import com.oleg.belov.javase.functional.programming.process.FilteringExamples;
import com.oleg.belov.javase.functional.programming.process.FindingExamples;
import com.oleg.belov.javase.functional.programming.process.MapExample;
import com.oleg.belov.javase.functional.programming.process.MeaningOfThis;
import com.oleg.belov.javase.functional.programming.process.QuickExamples;
import com.oleg.belov.javase.functional.programming.process.ReductionExamples;

@SpringBootApplication
public class HelloLambdaApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(HelloLambdaApplication.class, args);
		
		QuickExamples.run();
		MeaningOfThis.run();
		FilteringExamples.run();
		MapExample.run();
		CollectExample.run();
		CountMaxMinExamples.run();
        ReductionExamples.run();
        FindingExamples.run();
	}
}

