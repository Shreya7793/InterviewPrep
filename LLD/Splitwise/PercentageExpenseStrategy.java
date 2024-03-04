package LLD.Splitwise;

public class PercentageExpenseStrategy implements ExpenseStrategy{
    @Override
    public void splitExpense() {
        new PercentageExpense().split();
    }
}
