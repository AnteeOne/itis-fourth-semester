package tech.anteeone.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tech.anteeone.beans.AdditonOperator;
import tech.anteeone.beans.DividingOperator;
import tech.anteeone.beans.MultiplicationOperator;
import tech.anteeone.beans.SubstractionOperator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        double a;
        double b;
        ApplicationContext context = new FileSystemXmlApplicationContext(Calculator.class.getResource("/calculatorConfig.xml").toString());
        String operation;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        a = sc.nextDouble();
        System.out.println("Enter second number");
        b = sc.nextDouble();
        System.out.println("Enter the operation : (+,-,*,:)");
        operation = sc.next();
        switch (operation) {
            case "+":{
                System.out.println(((AdditonOperator)context.getBean("add")).run(a,b));
                break;
            }
            case "-":{
                System.out.println(((SubstractionOperator)context.getBean("sub")).run(a,b));
                break;
            }
            case "*":{
                System.out.println(((MultiplicationOperator)context.getBean("mul")).run(a,b));
                break;
            }
            case ":":{
                System.out.println(((DividingOperator)context.getBean("div")).run(a,b));
                break;
            }
            default:{
                throw new IllegalStateException("no such operation");
            }
        }

    }

}
