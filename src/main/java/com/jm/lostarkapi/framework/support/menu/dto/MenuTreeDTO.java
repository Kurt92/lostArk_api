package com.jm.lostarkapi.framework.support.menu.dto;

import com.jm.lostarkapi.framework.support.menu.domain.MenuMng;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MenuTreeDTO {

    private String id;
    private String name;
    private String url;
    private Integer listOrder;
    private String menuPath;
    private List<MenuTreeDTO> children;

    public MenuTreeDTO(final MenuMng menuMng) {
        this.id = menuMng.getMenuId();
//        this.name = menuMng.getMenuNm();
        this.name = menuMng.getMenuNm();
        this.url = menuMng.getProgramMng().getPrgmUrl();
        this.menuPath = this.createMenuPath(menuMng);
        this.listOrder = menuMng.getListOrder();
        this.children = menuMng.getChild().stream().map(MenuTreeDTO::new).collect(Collectors.toList());
    }

    public MenuTreeDTO(final MenuMng menuMng, final Map<String, Boolean> userMenuMap) {
        this.id = menuMng.getMenuId();
        this.name = menuMng.getMenuNm();
        this.url = menuMng.getProgramMng().getPrgmUrl();
//        this.menuPath = this.createMenuPath(menuMng);
        this.listOrder = menuMng.getListOrder();
        this.children = menuMng.getChild().stream()
                .filter(menu -> userMenuMap.getOrDefault(menu.getMenuId(), false))
                .map(menu -> new MenuTreeDTO(menu, userMenuMap))
                .collect(Collectors.toList());
    }


    /**
     * 메뉴 Path 생성
     *
     * @param menuMng
     * @return
     */
    private String createMenuPath(final MenuMng menuMng) {
        if (menuMng != null)
            return menuMng.getMenuNm();
        else
            return String.format("%s > %s", createMenuPath(menuMng.getParent()), menuMng.getMenuNm());

    }
}