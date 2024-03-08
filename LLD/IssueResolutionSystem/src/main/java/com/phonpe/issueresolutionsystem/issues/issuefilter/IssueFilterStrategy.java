package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;

import java.util.List;

public interface IssueFilterStrategy {
    List<Issue> filter(List<Issue> issues, String searchParameter);
}
