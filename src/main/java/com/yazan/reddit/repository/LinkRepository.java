package com.yazan.reddit.repository;

import com.yazan.reddit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findAllByTitle(String title);
}
