package LLD.Splitwise;

import java.util.List;

public class Expense {
    Double totalAmount;
    SplitStrategy splitStrategy;
    List<User> userList;
    Expense(double totalAmount, List<User> userList, SplitStrategy splitStrategy) {
        this.totalAmount = totalAmount;
        this.userList = userList;
        this.splitStrategy = splitStrategy;
    }
}
