package com.yazan.reddit.service;

import com.yazan.reddit.domain.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    public List<Link> getLinks();
    public Optional<Link> getLink(Long id);
    public void addLink(Link link);
}
