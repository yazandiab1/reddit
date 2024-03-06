package com.yazan.reddit.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Link extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @Nonnull
    private String title;

    @Nonnull
    private String url;

    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
