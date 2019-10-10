package spock.withJava.example;

public class MathFormater {

    public String addBrackets(String text){
        System.out.println(text);
        return "( " + text + " )";
    }
}
