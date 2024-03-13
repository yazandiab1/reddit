package com.yazan.reddit.controller;

import com.yazan.reddit.repository.LinkRepository;
import com.yazan.reddit.repository.VoteRepository;
import com.yazan.reddit.service.LinkServiceImpl;
import com.yazan.reddit.service.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    private VoteServiceImpl voteService;

    public VoteController(VoteServiceImpl voteService) {
        this.voteService = voteService;
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkID}/direction/{direction}/voteCount/{voteCount}")
    public int vote(@PathVariable Long linkID, @PathVariable short direction , @PathVariable int voteCount) {
        return voteService.vote(linkID,direction,voteCount);
    }

}
