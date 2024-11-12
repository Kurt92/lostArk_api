package com.jm.lostarkapi.framework.support.menu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ll_program_mng")
public class ProgramMng{
    @Id
    @Comment("프로그램 코드")
    @Column(name = "prgm_cd", length = 15)
    private String prgmCd;

    @Comment("프로그램 한글명")
    @Column(name = "prgm_nm", length = 50, nullable = false)
    private String prgmNm;

    @Comment("프로그램 경로")
    @Column(name = "prgm_url")
    private String prgmUrl;
}
