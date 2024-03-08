package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues;

//Used for Issue Notification
public interface IssueNotification {
    void register();
    void unregister();
    void notifyIssue();
}
