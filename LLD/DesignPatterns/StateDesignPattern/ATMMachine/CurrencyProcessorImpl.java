package LLD.DesignPatterns.StateDesignPattern.ATMMachine;

import java.util.*;

public class CurrencyProcessorImpl implements CurrencyProcessor{
    private Map<Integer,Integer> availableNotes;

    public CurrencyProcessorImpl(Map<Integer, Integer> availableNotes) {
        this.availableNotes = availableNotes;
    }

    @Override
    public boolean validateAmount(int amount) {
        // Check if ATM has sufficient cash and can dispense requested amount
        int totalAvailable=0;
        for(Map.Entry<Integer,Integer> entry:availableNotes.entrySet())
        {
            totalAvailable += entry.getKey()*entry.getValue();
        }
        return (totalAvailable>=amount);
    }

    @Override
    public void dispenseCash(int amount) {
        //Logic to dispense cash

        // Dispense cash using available notes
        Map<Integer, Integer> notesToDispense = new HashMap<>();
        int remainingAmount = amount;

        // Iterate over available notes in descending order
        List<Integer> denominations = new ArrayList<>(availableNotes.keySet());
        Collections.sort(denominations, Collections.reverseOrder());

        for (int denomination : denominations) {
            int noteCount = availableNotes.getOrDefault(denomination, 0);
            int notesToDispenseCount = Math.min(noteCount, remainingAmount / denomination);
            if (notesToDispenseCount > 0) {
                notesToDispense.put(denomination, notesToDispenseCount);
                remainingAmount -= denomination * notesToDispenseCount;
            }
            if (remainingAmount == 0) {
                break; // Amount fully dispensed
            }
        }

        // Update available notes after dispensing
        for (Map.Entry<Integer, Integer> entry : notesToDispense.entrySet()) {
            int denomination = entry.getKey();
            int dispensedCount = entry.getValue();
            int remainingCount = availableNotes.getOrDefault(denomination, 0) - dispensedCount;
            availableNotes.put(denomination, remainingCount);
        }

        // Output dispensed notes
        if (remainingAmount == 0) {
            System.out.println("Dispensing cash:");
            for (Map.Entry<Integer, Integer> entry : notesToDispense.entrySet()) {
                System.out.println(entry.getKey() + " x " + entry.getValue());
            }
        } else {
            System.out.println("Unable to dispense requested amount. Please try again.");
        }
    }
}
