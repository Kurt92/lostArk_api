package com.jm.lostarkapi.framework.support.menu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "regist_dt", nullable = true)
    @Comment("등록일시")
    private LocalDateTime registDt;

    @UpdateTimestamp
    @Column(name = "last_updt_dt", nullable = true)
    @Comment("최종수정일시")
    protected LocalDateTime lastUpdtDt;
}
