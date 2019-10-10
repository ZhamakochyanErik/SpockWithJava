package spock.withJava.example

import spock.lang.Specification

class NumberOperationsTest extends Specification {

    def "test '+' operator"() {
        setup:
        def numOperators = new NumberOperations();
        def operator = "+";
        def x = 1;
        def y = 10;
        when:
        def result = numOperators.operateByNumber(x,y,operator);
        then:
        result == 11;
        cleanup:
        numOperators.clean();
    }

    def "test '*' operator"() {
        given:
        def numOperators = new NumberOperations();
        def operator = "*";
        def x = 2;
        def y = 10;
        expect:
        numOperators.operateByNumber(x,y,operator) == 20
        cleanup:
        numOperators.clean();
    }

    def "test many cases '/' operator"() {
        given:
        def numOperators = new NumberOperations();
        def operator = "/";
        expect:
        //we can not define x,y and result variables when we use (where) operator in the end of the test
        numOperators.operateByNumber(x,y,operator) == result
        cleanup:
        numOperators.clean();
        //by where operator we can test many cases simultaneously how it was written below
        where:
        //there are two versions of writing code satisfied where block
        //this two code do the same function
//        x   | y  || result
//        10  | 10 || 1
//        100 | 2  || 50
//        10  | 1  || 10
        x << [10, 100, 10]
        y << [10, 2, 1]
        result << [1, 50, 10]
    }

    def "test dividing to zero case by "() {

        given:
        def numOperators = new NumberOperations();
        def operator = "/";

        when:
        numOperators.operateByNumber(x,y,operator);

        then:
        thrown(exception)

        cleanup:
        numOperators.clean();

        where:
        x  | y | exception
        20 | 0 | ArithmeticException
    }

    def "test unknown operator"() {
        given:
        def numOperators = new NumberOperations();
        def operator = "unknown";
        def x = 1;
        def y = 10;
        when:
        def result = numOperators.operateByNumber(x,y,operator);
        then:
        thrown(IllegalArgumentException)
        cleanup:
        numOperators.clean();
    }
}