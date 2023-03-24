package com.biblioteca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.modelo.Advertisiment;
import com.biblioteca.biblioteca.modelo.AdvertisimentDto;
import com.biblioteca.biblioteca.modelo.PageDecorater;
import com.biblioteca.biblioteca.repositories.AdvertisimentRepository;
import java.util.List;

@Service
public class AdvertisimentServiceImpl {

    @Autowired
    AdvertisimentRepository advertisementRepository;

    public PageDecorater findAll(Pageable pageable) {
        Page<Advertisiment> pageAd = advertisementRepository.findAll(pageable);
        List<Advertisiment> ad = pageAd.getContent();
        List<AdvertisimentDto> adDto = ad.stream().map(x -> adToDto(x)).toList();
        Page<AdvertisimentDto> page = new PageImpl<>(adDto, pageAd.getPageable(), pageAd.getTotalElements());

        return new PageDecorater<>(page);
    }

    private AdvertisimentDto adToDto(Advertisiment ad) {
        AdvertisimentDto aDto = new AdvertisimentDto(ad.getTitule(), ad.getStatus(), ad.getState());
        return aDto;
    }

}
