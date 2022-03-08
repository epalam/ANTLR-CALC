// Generated from Calculator.g4 by ANTLR 4.9.3

package com.esp.calc.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculatorParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculatorParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalculatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalculatorParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionOrSubtraction}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionOrSubtraction(CalculatorParser.AdditionOrSubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionOrSubtraction}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionOrSubtraction(CalculatorParser.AdditionOrSubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationOrDivision(CalculatorParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationOrDivision}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationOrDivision(CalculatorParser.MultiplicationOrDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CalculatorParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CalculatorParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPower(CalculatorParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPower(CalculatorParser.PowerContext ctx);
}