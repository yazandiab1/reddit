package com.yazan.reddit.service;

import com.yazan.reddit.domain.Link;
import com.yazan.reddit.domain.Vote;
import com.yazan.reddit.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {
    private LinkServiceImpl linkService;
    private VoteRepository voteRepository;

    public VoteServiceImpl(LinkServiceImpl linkService, VoteRepository voteRepository) {
        this.linkService = linkService;
        this.voteRepository = voteRepository;
    }

    public int vote( Long linkID,  short direction ,  int voteCount) {
        Optional<Link> optionalLink = linkService.getLink(linkID);

        if ( optionalLink.isPresent() ) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction, link);
            voteRepository.save(vote);

            int updateVoteCount = voteCount + direction;
            link.setVoteCount(updateVoteCount);
            linkService.addLink(link);

            return updateVoteCount;
        }

        return voteCount;
    }

}
