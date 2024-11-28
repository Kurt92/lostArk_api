package com.jm.lostarkapi.biz.ctgy.news.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.lostarkapi.biz.ctgy.news.dto.NewsDto;
import com.jm.lostarkapi.biz.domain.news.Event;
import com.jm.lostarkapi.biz.domain.news.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;


    public NewsDto.Response findEvents() {

        List<Event> eventsEntityList = eventRepository.findAllByEndAtFalse();


        List<NewsDto.NewsFields> newsFieldsList = eventsEntityList.stream()
                .map(event -> NewsDto.NewsFields.builder()
                        .title(event.getTitle())
                        .bannerImgUrl(event.getBannerImgUrl())
                        .linkUrl(event.getLinkUrl())
                        .build())
                .collect(Collectors.toList());

        return NewsDto.Response.builder()
                .events(newsFieldsList)
                .build();
    }

    public void saveEvent(List<NewsDto.Save> events) {

//        List<NewsDto.Save> convertedEvents = new ArrayList<>();
//        convertedEvents = objectMapper.convertValue(events, new TypeReference<List<NewsDto.Save>>() {});
//
//        for(NewsDto.Save event : convertedEvents) {
//
//            if(!eventRepository.existsByTitle(event.getTitle())) {
//                Event item = Event.builder()
//                        .title(event.getTitle())
//                        .bannerImgUrl(event.getBannerImgUrl())
//                        .linkUrl(event.getLinkUrl())
//                        .build();
//                eventRepository.save(item);
//            }
//        }

        // stream
        List<String> findEvents = eventRepository.findAllTitles();
        List<Event> streamEvents = events.stream()
                .filter(event -> !findEvents.contains(event.getTitle()))
                .map(event -> Event.builder()
                        .title(event.getTitle())
                        .bannerImgUrl(event.getBannerImgUrl())
                        .linkUrl(event.getLinkUrl())
                        .build())
                .collect(Collectors.toList());

        if(!streamEvents.isEmpty()) {
            eventRepository.saveAll(streamEvents);
        }

    }



}
