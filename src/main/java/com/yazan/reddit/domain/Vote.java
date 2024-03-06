package com.yazan.reddit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue
    private Long id;

    private int vote;
}
