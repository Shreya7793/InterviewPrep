package LLD.Splitwise;

public class EqualExpenseStrategy implements ExpenseStrategy{
    @Override
    public void splitExpense() {
        new EqualExpense().split();
    }
}
