package spock.withJava.example;

public class NumberOperations {

    private Logger logger;

    private MathFormater mathFormater;


    public void setMathFormater(MathFormater mathFormater) {
        this.mathFormater = mathFormater;
    }

    public MathFormater getMathFormater() {
        return mathFormater;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    public int operateByNumber(int x, int y, String operator){
        int result;
        switch (operator){
            case "+":
                result =  x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:throw new IllegalArgumentException("there isn't such operations '" + operator + "'");
        }
        logger.log(x + " " + operator + " " + y + " = " + result);
        return result;
    }

    public String operateByBrackets(int x, int y, String operator){
        int result = operateByNumber(x, y, operator);
        String exprWithBracket = mathFormater.addBrackets(x + " " + operator + " " + y + " = " + result);
        logger.log(exprWithBracket);
        return exprWithBracket;
    }

    public void clean() {
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
