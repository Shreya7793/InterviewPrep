package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.Issue;
import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueType;

import java.util.List;

public class PaymentAgent extends Agent{
    public PaymentAgent(String agentId, String agentName, String email, IssueType expertise) {
        super(agentId, agentName, email, expertise);
    }
}
