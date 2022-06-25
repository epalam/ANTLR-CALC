package com.esp.calc.implentation;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.esp.calc.antlr.CalculatorLexer;
import com.esp.calc.antlr.CalculatorParser;

public class Test {
	
	public static void main(String[] args) throws Exception{
//		String input = "((2 + 3) * 2 - 1)/2.5";
//		Reader reader = new StringReader(input);
//		Writer writer = new StringWriter();
//		VisitorBasedCalculator calculator = new VisitorBasedCalculator(reader, writer);
//		System.out.println(calculator.calculate(input));

		
        CharStream chars = CharStreams.fromString("(1+2) + (2+3)");

        Lexer lexer = new CalculatorLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();
        
        System.out.println(tree.toStringTree());

        CalculatorListenerImpl calculator = new CalculatorListenerImpl();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(calculator, tree);
        
        
	}

}
