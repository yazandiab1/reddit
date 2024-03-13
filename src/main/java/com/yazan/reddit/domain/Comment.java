package com.yazan.reddit.domain;

import com.yazan.reddit.service.BeanUtil;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}
