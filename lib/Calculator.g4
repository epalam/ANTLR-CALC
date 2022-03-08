grammar Calculator;
@parser::header {
package com.esp.calc.antlr;
}
@lexer::header {
package com.esp.calc.antlr;
}

/*
 * Define tokens
 */
POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
//NUMBER: '-'?[0-9]+;
NUMBER: FLOAT | INT;

FLOAT   : '-'?[0-9]+ '.' [0-9]*
        | '-'?'.' [0-9]+
        ;
INT     : '-'?[0-9]+;



WHITESPACE: [ \r\n\t]+ -> skip;

/*
 * Define expression being evaluated
 */
start : expression;

expression
   : NUMBER                                               # Number
   | '(' inner=expression ')'                             # Parentheses
   | left=expression operator=POW right=expression        # Power
   | left=expression operator=(MUL|DIV) right=expression  # MultiplicationOrDivision
   | left=expression operator=(ADD|SUB) right=expression  # AdditionOrSubtraction
   ;

