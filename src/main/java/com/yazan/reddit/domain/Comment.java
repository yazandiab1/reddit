package com.yazan.reddit.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @Nonnull
    private String body;

    @ManyToOne
    @Nonnull
    private Link link;
}
