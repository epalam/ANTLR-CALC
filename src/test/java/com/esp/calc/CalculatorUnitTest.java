package com.esp.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.esp.calc.implentation.VisitorBasedCalculator;


public class CalculatorUnitTest {
	@BeforeAll
	public static void init() {
		System.out.println("Run befor all tests");
	}
	@Test
	public void testIntegerAdd() {
		String input = "1 + 2";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(3.0, calculator.calculate(input));

	}
	@Test
	public void testIntegerSubtract() {
		String input = "5 - 2";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(3.0, calculator.calculate(input));

	}
	@Test
	public void testFloatAdd() {
		String input = "1.5 + 2.6";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(4.1, calculator.calculate(input));

	}
	@Test
	public void testFloatSubtract() {
		String input = "5.5 - 2.1";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(3.4, calculator.calculate(input));

	}

	@Test
	public void testParentheses () {
		String input = "(5.5 - 2.5) + (22 - 17)";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(8.0, calculator.calculate(input));
	}
	@Test
	public void testMultiTest () {
		String input = "((2 + 3) * 2 - 1)/2.5";
		Reader reader = new StringReader(input);
		Writer writer = new StringWriter();
		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
		assertEquals(3.6, calculator.calculate(input));
	}
	
}
