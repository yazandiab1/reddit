package com.yazan.reddit.service;

import com.yazan.reddit.domain.Comment;
import com.yazan.reddit.domain.Link;
import com.yazan.reddit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

}
