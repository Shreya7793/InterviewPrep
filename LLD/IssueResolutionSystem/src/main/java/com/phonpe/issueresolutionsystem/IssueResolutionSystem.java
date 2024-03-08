package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents.Agent;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents.AgentStatus;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueType;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.EmailFilterStrategy;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.IssueFilter;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.IssueFilterStrategy;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.IssueTypeFilterStrategy;
import LLD.WhatAppMessenger.User;

import java.util.*;

//Only one instance using singleton Patten which ensure System is accessed consistently throughout the application
public class IssueResolutionSystem {
    private static IssueResolutionSystem issueResolutionSystem;
    List<Map<String,String>> agentIssueMapList;
    Map<IssueType,Agent> agentsExpertiseMap;
    private List<Issue> issues;//Map of IssueType to Issues
    IssueFilterStrategy issueFilterStrategy;


    private IssueResolutionSystem() {
        this.issues = new ArrayList<>();
        this.agentsExpertiseMap=new HashMap<>();
        this.agentIssueMapList=new ArrayList<>();
    }

    // Lazy initialization with double-checked locking for thread safety
    public static IssueResolutionSystem getInstance() {
        if (issueResolutionSystem == null) {
            synchronized (IssueResolutionSystem.class) {
                if (issueResolutionSystem == null)
                    issueResolutionSystem = new IssueResolutionSystem();
            }
        }
        return issueResolutionSystem;
    }

    // Method to create an issue
    public synchronized Issue createIssue(String transactionId, String issueTypeStr, String subject, String description, String email) {
        // Validate issue type
        IssueType issueType = IssueType.valueOf(issueTypeStr.toUpperCase());
        if (issueType == null) {
            throw new IllegalArgumentException("Invalid issue type: " + issueTypeStr);
        }

        String issueId = generateUniqueId();// Generate unique issue ID
        // Create new issue
        Issue issue = new Issue(issueId, issueType, subject, description, email);
        issues.add(issue);

        System.out.println("Issue " + issueId + " created against transaction " + transactionId + "");
        return issue;
    }

    private String generateUniqueId() {
        return "I" + UUID.randomUUID().toString();
    }


    public void addAgent(IssueType issuetype, Agent agent) {
        agentsExpertiseMap.put(issuetype,agent);
    }
    //Method to assign issues based on Agent expertise and availibility
    public void assignIssue(Issue issue) {
        Agent agent = agentsExpertiseMap.get(issue.getIssueType());
        if (agent != null && agent.getAgentStatus() == AgentStatus.AVAILABLE) {
            agent.setAssignedIssues(List.of(issue));
            agent.setAgentStatus(AgentStatus.BUSY);
            System.out.println("Issue " + issue.getIssueId() + " assigned to agent " + agent.getAgentId());
        } else {
            System.out.println("No available agent for issue " + issue.getIssueId() + ". Adding to waiting list.");
        }
    }

    // Method to get issues based on filter
    public void getIssueByFilter(String filter,String searchString) {
        List<Issue> filteredIssues = null;
        if (searchString == null) {
            throw new IllegalArgumentException("Invalid issue Search ");
        }
        // Validate issue type
        IssueFilter issueFilter = IssueFilter.valueOf(filter.toUpperCase());
        if (issueFilter == null) {
            throw new IllegalArgumentException("Invalid issue type: " + issueFilter); //Usually filter would be dropdown from UI
        }
        switch (issueFilter){
            case EMAIL -> {
                issueFilterStrategy=new EmailFilterStrategy();
                filteredIssues=issueFilterStrategy.filter(this.issues,searchString);
                break;
            }
            case TYPE -> {
                issueFilterStrategy=new IssueTypeFilterStrategy();
                filteredIssues=issueFilterStrategy.filter(this.issues,searchString);
                break;
            }
            default ->
                System.out.println("Try Again!");
        }
        for (Issue issue : filteredIssues) {
            System.out.println(issue);
        }
    }
}
