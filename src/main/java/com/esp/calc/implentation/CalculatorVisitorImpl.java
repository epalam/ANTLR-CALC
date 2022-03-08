package com.esp.calc.implentation;

import com.esp.calc.antlr.CalculatorBaseVisitor;
import com.esp.calc.antlr.CalculatorParser;
/**
 * Implementation of Visitor based Calculator
 * @author Eugene Palamarchuk
 *
 */
public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double>{

	/**
     *
     * @return Double
     */
    public Double visitNumber(CalculatorParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }

    /**
     *
     * @return Double
     */
    public Double visitParentheses(CalculatorParser.ParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }

    /**
     * @return Double
     */
    public Double visitPower(CalculatorParser.PowerContext ctx) {
        return Math.pow(this.visit(ctx.left), this.visit(ctx.right));
    }

    public Double visitMultiplicationOrDivision(CalculatorParser.MultiplicationOrDivisionContext ctx) {
    	if (ctx.operator.getText().equals("*")) {
            return this.visit(ctx.left) * this.visit(ctx.right);
        }
        return this.visit(ctx.left) / this.visit(ctx.right);
    }

    public Double visitAdditionOrSubtraction(CalculatorParser.AdditionOrSubtractionContext ctx) {
        if (ctx.operator.getText().equals("+")) {
            return this.visit(ctx.left) + this.visit(ctx.right);
        }

        return this.visit(ctx.left) - this.visit(ctx.right);
    }
	
}
