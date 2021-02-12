package tech.anteeone.beans;

public class MultiplicationOperator implements IOperator {
    @Override
    public double run(double a , double b) {
        return a * b;
    }
}
