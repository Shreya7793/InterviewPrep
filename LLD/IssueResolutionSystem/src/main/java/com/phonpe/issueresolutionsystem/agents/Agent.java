package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueType;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    String agentId;
    String agentName;
    String email;

    List<IssueType> expertises;
    List<Issue> assignedIssues;
    AgentStatus agentStatus;

    public Agent(String agentId, String agentName, String email, IssueType expertises) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.email = email;
        this.expertises = new ArrayList<>();
        this.assignedIssues = null;
        this.agentStatus=AgentStatus.AVAILABLE;
    }

    public AgentStatus getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(AgentStatus agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IssueType> getExpertises() {
        return expertises;
    }

    public void setExpertises(List<IssueType> expertises) {
        this.expertises = expertises;
    }

    public List<Issue> getAssignedIssues() {
        return assignedIssues;
    }

    public void setAssignedIssues(List<Issue> assignedIssues) {
        this.assignedIssues = assignedIssues;
    }
}
