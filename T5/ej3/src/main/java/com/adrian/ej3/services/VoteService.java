package com.adrian.ej3.services;

public interface VoteService {
    Integer[] getVotes();
    Boolean registerVote(String voterEmail, Integer movieID);
}
