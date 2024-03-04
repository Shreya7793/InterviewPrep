package LLD.Splitwise;

public class UnEqualExpenseStrategy implements ExpenseStrategy{
    @Override
    public void splitExpense() {
        new UnEqualExpense().split();
    }
}
