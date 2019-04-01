package com.fo.up.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.NumberService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NumberServiceImpl implements NumberService{

    @Autowired
    private UpUserRepository upUserRepository;

    @Cacheable(value = "squareCache", key = "#number", condition = "#number>10")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number)
            .multiply(BigDecimal.valueOf(number));
        log.info("service");
        return square;
    }

    @Cacheable(value = "aaa", key = "#id", condition = "#id>0")
    public UpUser xx(Long id) {
        return upUserRepository.findById(id).get();
    }

    @Cacheable(value = "aaa", key = "#id + 1", condition = "#id>0")
    @Override
    public UpUser getUserById(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return upUserRepository.findById(id).get();
    }
}