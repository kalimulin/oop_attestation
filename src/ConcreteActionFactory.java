public class ConcreteActionFactory implements ActionFactory {
    @Override
    public ComplexAction createSumAction() {
        return new SumAction();
    }

    @Override
    public ComplexAction createMultiplyAction() {
        return new MultiplyAction();
    }

    @Override
    public ComplexAction createDivideAction() {
        return new DivideAction();
    }
}
