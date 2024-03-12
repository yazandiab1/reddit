package com.yazan.reddit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private short direction;

    private int vote;

    @NonNull
    @ManyToOne
    private Link link;

}
