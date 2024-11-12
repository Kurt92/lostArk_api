package com.jm.lostarkapi.framework.support.menu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuMngRepository extends JpaRepository<MenuMng, String> {

    List<MenuMng> findByParentIsNullOrderByListOrderAsc();

}
