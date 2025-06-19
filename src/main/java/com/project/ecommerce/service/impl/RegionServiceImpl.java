package com.project.ecommerce.service.impl;

import com.project.ecommerce.model.entity.Region;
import com.project.ecommerce.repository.RegionRepository;
import com.project.ecommerce.service.contract.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region getById(Integer id) {
        return regionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Region Type not found"));
    }
}

