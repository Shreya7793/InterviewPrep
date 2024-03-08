Functional Requirements:
- Customer should be able to raise a issue for any transactions
- Customer Service Agents can search customer issue with issue id or customer details (email)
- Agents have the list of issues assigned against them, which they will work on to resolve and mark the ticket Resolve

Non-Functional Requirements:
- Reliability: Issues should be tracked and resolved in timely manner
- Availibility: Issue Resolution system should be available 24/7 allowing customers to raise issues
- Privacy & Compliance: The trasaction details and customer details should comply to local government regulations

Design Patterns Used:
Creational Design Pattern
1. Singleton: To create a single instance of IssueResolutionSystem
2. Factory: To create instances of agents based on their type
Behavioral Design Pattern
1. Strategy: To encapsulate algorithms for assigning issues to agent
