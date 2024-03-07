package com.yazan.reddit.service;

import com.yazan.reddit.domain.Link;
import com.yazan.reddit.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> getLinks() {
        return linkRepository.findAll();
    }

    public Optional<Link> getLink(Long id) {
        return linkRepository.findById(id);
    }

    public void addLink(Link link) {
        linkRepository.save(link);
    }

}
