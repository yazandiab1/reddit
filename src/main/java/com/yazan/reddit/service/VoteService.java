package com.yazan.reddit.service;

public interface VoteService {
    public int vote(Long linkID, short direction , int voteCount);
}
