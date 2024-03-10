import java.util.Scanner;

public class ShowCalculator {

    LoggerService loggerService = new LoggerService();

    ActionFactory actionFactory = new ConcreteActionFactory();

    ComplexAction addOperation = actionFactory.createSumAction();
    ComplexAction multiplyOperation = actionFactory.createMultiplyAction();
    ComplexAction divideOperation = actionFactory.createDivideAction();

   
    public void run() {
        while (true) {
            int real1 = promptInt("Введите действительное число: ");
            int imaginary1 = promptInt("Введите мнимое число: ");
           
            while (true) {
                String cmd = prompt("Введите команду ( *, /, + ) : ");
                if (cmd.equals("*")) {
                    showCalc(real1, imaginary1, multiplyOperation );
                    break;
                } else if (cmd.equals("/")) {
                    showCalc(real1, imaginary1, divideOperation );
                    break;
                } else if (cmd.equals("+")) {
                    showCalc(real1, imaginary1, addOperation );
                    break;
                } else {
                    loggerService.logError("Выбрана не верная команда попробуйте еще раз!");
                }               
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

    private void showCalc(int real1, int imaginary1, ComplexAction operation){
        int real2 = promptInt("Введите действительное 2-е число: ");
        int imaginary2 = promptInt("Введите мнимое 2-е число: ");
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);
       
        Calculator subtractCalculator = new Calculator(operation);
        logOperation(num1, num2, operation);
        ComplexNumber result = subtractCalculator.calculate(num1, num2);
        loggerService.logInfo("Результат вычиcления: " + result);
    } 

    private void logOperation(ComplexNumber a, ComplexNumber b, ComplexAction operation){
        if(operation.equals(addOperation)){
            loggerService.logInfo("Выполнено сложение: " + a + " и " + b);
        }  else if(operation.equals(multiplyOperation)){
            loggerService.logInfo("Выполнено умножение: " + a + " и " + b);
        } else if(operation.equals(divideOperation)){
            loggerService.logInfo("Выполнено деление: " + a + " и " + b);
        }

    }
}
