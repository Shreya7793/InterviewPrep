package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents.Agent;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents.AgentFactory;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueType;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.IssueFilter;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.issuefilter.IssueFilterStrategy;

public class Client {
    public static void main(String[] args) {

        //Create instance of IssueResolutionSystem
        IssueResolutionSystem issueResolutionSystem = IssueResolutionSystem.getInstance();

        //create issues
        Issue issue1=issueResolutionSystem.createIssue("T1", "Payment", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com");
        Issue issue2=issueResolutionSystem.createIssue("T2", "Mutual_Fund", "Purchase Failed", "Unable to purchase Mutual Fund", "testUser2@test.com");
        Issue issue3=issueResolutionSystem.createIssue("T3", "Payment", "Payment Failed", "My payment failed but money is debited", "testUser2@test.com");


        // Create Agents as per expertise
        Agent agent1 = AgentFactory.createAgent(IssueType.PAYMENT,"AG001","agent1","agent1@phonpe.com");
        Agent agent2 = AgentFactory.createAgent(IssueType.PAYMENT,"AG002","agent2","agent2@phonpe.com");
        Agent agent3 = AgentFactory.createAgent(IssueType.MUTUAL_FUND,"AG003","agent2","agent2@phonpe.com");

        //Add agent
        issueResolutionSystem.addAgent(IssueType.PAYMENT,agent1);
        issueResolutionSystem.addAgent(IssueType.PAYMENT,agent2);
        issueResolutionSystem.addAgent(IssueType.MUTUAL_FUND,agent3);
        //Assign Issue
        issueResolutionSystem.assignIssue(issue1);
        issueResolutionSystem.assignIssue(issue2);
        issueResolutionSystem.assignIssue(issue3);

        //Get Issue By Type
        issueResolutionSystem.getIssueByFilter(String.valueOf(IssueFilter.EMAIL),"testUser2@test.com");
        issueResolutionSystem.getIssueByFilter(String.valueOf(IssueFilter.TYPE),"PAYMENT");

    }
}
