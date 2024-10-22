package com.adrian.ej3.services;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class VoteServiceImpl implements VoteService {
    private Set<String> registeredEmails = new HashSet<>();
    private Integer[] votes = new Integer[] {0, 0, 0};

    public Integer[] getVotes() {
        return votes;
    }

    @Override
    public Boolean registerVote(String voterEmail, Integer movieID) {
        if (!registeredEmails.add(voterEmail)) {
            return false;
        }
        votes[movieID]++;
        return true;
    }    
}
