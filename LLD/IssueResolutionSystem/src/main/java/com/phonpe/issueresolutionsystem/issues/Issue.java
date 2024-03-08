package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues;

import java.time.LocalDateTime;

public class Issue {
    String issueId;
    IssueType issueType;
    String subject;
    String description;
    String customerEmail;
    IssueState state;
    LocalDateTime createTimestamp;
    LocalDateTime updateTimestamp;

    public Issue(String issueId,IssueType issueType, String subject, String description, String customerEmail) {
        this.issueId = issueId;
        this.issueType = issueType;
        this.description = description;
        this.subject = subject;
        this.customerEmail = customerEmail;
        this.state = IssueState.PENDING;
        this.createTimestamp = LocalDateTime.now();
        this.updateTimestamp = LocalDateTime.now();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public IssueState getState() {
        return state;
    }

    public void setState(IssueState state) {
        this.state = state;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public String toString() {
        return issueId + " {" + issueType + ", " + subject + ", " + description + ", " + customerEmail + ", " + state + "}";
    }
}
