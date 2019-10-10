package spock.withJava.example

import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

class NumberOperationWithMockTest extends Specification {

    def logger = Mock(Logger);
    def numberOperations = new NumberOperations()

    def setup(){
        numberOperations.setLogger(logger);
    }


    @Ignore
    def "test logger work"(){
        when:
        numberOperations.operateByNumber(1,2,"+");
        then:
        1 * logger.log(_)
    }

    def "test get result with brackets"(){
        setup:
        def x = 40;
        def y = 20;
        def operator = "-";
        def result;
        def mathFormater = Mock(MathFormater);
        1 * mathFormater.addBrackets("40 - 20 = 20") >> "( 40 - 20 = 20 )";
        numberOperations.setMathFormater(mathFormater);
        when:
        result = numberOperations.operateByBrackets(x,y,operator);
        then:
        2 * logger.log(_)
    }
}