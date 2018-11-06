package com.fo.up.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.fo.up.entity.UpUser;
import com.fo.up.repository.UpUserRepository;
import com.fo.up.service.UpUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpUserTest {

    @Autowired
    private UpUserService upUserService;
    
    @Autowired
    private UpUserRepository upUserRepository;
    
    @Test
    public void getUserByIdTest() {
        UpUser userById = this.upUserService.getUserById(1L);
    }
    
    @Test
    public void findUserByPage() {
        Pageable pageable = new PageRequest(0,10); 
        Page<UpUser> findAll = this.upUserRepository.findAll(pageable);
        System.out.println(findAll);
    }
    public static void main(String[] args) throws ParseException {
        String d = "2018-09-09";
        new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = simpleDateFormat.parse(d);
        System.out.println(parse);
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);

        Date date = new Date();
        System.out.println(String.format("%ty%tm", date, date));
        
        System.err.println(String.format("ih fvf jin nian : %s sssssss", 8));
    }
}
