package net.crisssky.craftchallenge.player;

import net.crisssky.craftchallenge.challenge.Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChallengePlayer {

    private UUID uniqueId;
    private boolean acceptChallenges;
    private List<Challenge> receivedChallenges = new ArrayList<Challenge>();
    private List<Challenge> currentChalleges = new ArrayList<Challenge>();
    private List<Challenge> completedChallenges = new ArrayList<Challenge>();

    public ChallengePlayer(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public List<Challenge> getCompletedChallenges() {
        return completedChallenges;
    }

    public List<Challenge> getCurrentChalleges() {
        return currentChalleges;
    }

    public List<Challenge> getReceivedChallenges() {
        return receivedChallenges;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public boolean acceptChallengesRequests() {
        return acceptChallenges;
    }

    public void setAcceptChallenges(boolean acceptChallenges) {
        this.acceptChallenges = acceptChallenges;
    }

}
