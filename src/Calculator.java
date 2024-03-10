public class Calculator {
    private ComplexAction operation;

    public Calculator(ComplexAction operation) {
        this.operation = operation;
    }

    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        return operation.action(a, b);
    }
}
