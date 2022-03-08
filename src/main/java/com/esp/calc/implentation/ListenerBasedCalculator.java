package com.esp.calc.implentation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.esp.calc.antlr.CalculatorLexer;
import com.esp.calc.antlr.CalculatorParser;

/**
 * Main Class og Listener Based calculator
 * @author Eugene Palamarchuk
 *
 */
public class ListenerBasedCalculator {
    private Scanner scanner;
    private Writer output;
    
    public ListenerBasedCalculator(Reader input, Writer output) {
        this.scanner = new Scanner(input);
        this.output = output;
    }
    
    public void start() throws IOException{
    	while (true) {
            write("Calculate: ");
            String input = this.scanner.nextLine();

            if (input.matches("exit|quit") || input.isEmpty()) {
                writeLine("Goodbye");
                break;
            }
            Double result = calculate(input);
            writeLine("\t" + result);
    	}
    }
    private Double calculate(String input) {
        CharStream chars = CharStreams.fromString(input);

        Lexer lexer = new CalculatorLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();

        CalculatorListenerImpl calculator = new CalculatorListenerImpl();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(calculator, tree);
        

        return calculator.getResult();
    }

	private void write(String message) throws IOException {
        output.write(message);
        output.flush();
    }

    private void writeLine(String line) throws IOException {
        write(line + "\n");
    }

    public static void main(String [] args) throws Exception{
		new ListenerBasedCalculator(new InputStreamReader(System.in), new PrintWriter(System.out)).start();
	}

}
