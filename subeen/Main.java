package subeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] formula = name.split(" ");

        Calculator calculator = new Calculator();
        //String name = "2 / 3 + 4 / 2";
        System.out.println(calculator.calculate(formula));
    }

}
