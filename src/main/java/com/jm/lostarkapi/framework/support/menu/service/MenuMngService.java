package com.jm.lostarkapi.framework.support.menu.service;

import com.jm.lostarkapi.framework.support.menu.domain.MenuMngRepository;
import com.jm.lostarkapi.framework.support.menu.dto.MenuTreeDTO;
import com.jm.lostarkapi.framework.support.menu.repository.MenuQueryDslRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuMngService {

    private final MenuMngRepository menuMngRepository;
    private final MenuQueryDslRepository menuQueryDslRepository;

    //JPARepository
//    @Transactional
//    public List<MenuTreeDTO> findAll() {
//
//        List<MenuMng> menuList = menuMngRepository.findByParentIsNullOrderByListOrderAsc();
//
//        return menuList.stream()
//                .map(MenuTreeDTO::new)
//                .collect(Collectors.toList());
//    }

    //QueryDSL
    @Transactional
    public List<MenuTreeDTO> findAll() {
        return menuQueryDslRepository.findAll();
    }

}
