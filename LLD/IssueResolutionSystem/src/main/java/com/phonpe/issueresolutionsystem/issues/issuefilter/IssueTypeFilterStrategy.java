package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueState;

import java.util.ArrayList;
import java.util.List;

public class IssueTypeFilterStrategy implements  IssueFilterStrategy{
    @Override
    public List<Issue> filter(List<Issue> issues, String searchParameter) {
        List<Issue> filteredIssues = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.getIssueType().equals(searchParameter) && issue.getState()== IssueState.PENDING) {
                filteredIssues.add(issue);
            }
        }
        return filteredIssues;
    }
}
