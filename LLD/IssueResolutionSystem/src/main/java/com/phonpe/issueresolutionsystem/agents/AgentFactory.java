package LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.agents;

import LLD.IssueResolutionSystem.src.main.java.com.phonpe.issueresolutionsystem.issues.IssueType;

import java.util.List;

public class AgentFactory {

    public static Agent createAgent(IssueType expertise,String agentId,String agentName,String agentEmail) {
        switch (expertise) {
            case PAYMENT:
                return new PaymentAgent(agentId,agentName,agentEmail,expertise);
            case MUTUAL_FUND:
                return new MutualFundAgent(agentId,agentName,agentEmail,expertise);
            case GOLD:
                return new GoldAgent(agentId,agentName,agentEmail,expertise);
            case INSURANCE:
                return new InsuranceAgent(agentId,agentName,agentEmail,expertise);
            default:
                throw new IllegalArgumentException("Invalid expertise type: " + expertise);
        }
    }
}
