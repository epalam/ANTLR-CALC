package com.esp.calc.implentation;

import java.util.Stack;

import com.esp.calc.antlr.CalculatorBaseListener;
import com.esp.calc.antlr.CalculatorParser;
/**
 * Implementation of Listener based Calculator 
 * @author Eugene Palamarchuk
 *
 */
public class CalculatorListenerImpl extends CalculatorBaseListener{
    private final Stack<Double> stack = new Stack<Double>();

    @Override
    public void exitNumber(CalculatorParser.NumberContext ctx) {
        Double number = Double.parseDouble(ctx.NUMBER().getText());
        this.stack.push(number);
    }

    @Override
    public void exitPower(CalculatorParser.PowerContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(Math.pow(left, right));
    }

    @Override
    public void exitMultiplicationOrDivision(CalculatorParser.MultiplicationOrDivisionContext ctx) {

    	Double right = this.stack.pop();
        Double left = this.stack.pop();
        if (ctx.operator.getText().equals("*")) {
            this.stack.push(left * right);
        } else {
            this.stack.push(left / right);
        }
    }

    @Override
    public void exitAdditionOrSubtraction(CalculatorParser.AdditionOrSubtractionContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        if (ctx.operator.getText().equals("+")) {
            this.stack.push(left + right);
        } else {
            this.stack.push(left - right);
        }
    }

	public Double getResult() {
		return stack.pop();
	}
}
