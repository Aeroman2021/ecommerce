package com.project.ecommerce.service.contract;

import com.project.ecommerce.model.entity.Region;
import org.springframework.stereotype.Service;

@Service
public interface RegionService {

    Region getById(Integer id);
}
