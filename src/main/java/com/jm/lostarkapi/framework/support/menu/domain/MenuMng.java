package com.jm.lostarkapi.framework.support.menu.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ll_menu_mng")
public class MenuMng {

    @Id
    @Comment("메뉴ID")
    @Column(name = "menu_id", length = 10)
    private String menuId;

//    @Comment("상위메뉴ID")
//    @Column(name = "p_menu_id", length = 10, insertable=false, updatable=false)
//    private String pMenuId;

    @ManyToOne
    @JoinColumn(name = "p_menu_id")
    private MenuMng parent;

    @Comment("메뉴명")
    @Column(name = "menu_nm", length = 50, nullable = false)
    private String menuNm;

    @Comment("메뉴 설명")
    @Column(name = "menu_dc")
    private String menuDc;

    @Comment("프로그램 코드")
    @ManyToOne
    @JoinColumn(name = "prgm_cd")
    private ProgramMng programMng;

    @Comment("리스트 정렬 순서")
    @Column(name = "list_order")
    private Integer listOrder;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private final List<MenuMng> child = new ArrayList<>();
}
