package com.algo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.algo.sliding.window.LongestSubstringKDistinct;

@SpringBootApplication
public class AlgorithmsApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override public void run(String... args) throws Exception {

		LongestSubstringKDistinct obj = new LongestSubstringKDistinct();
		System.out.println(obj.getLongestSubString2("araaci", 2));
		System.out.println(obj.getLongestSubString2("araaci", 1));
		System.out.println(obj.getLongestSubString2("cbbebi", 3));

	}

}
