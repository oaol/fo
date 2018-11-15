package com.fo.up;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fo.up.entity.UpPermission;
import com.fo.up.service.UpPermissionService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UpPermissionServiceTest extends BaseTest {

    @Autowired
    private UpPermissionService upPermissionService;

    @Test
    public void findAllPermissionByUserIdTest() {
        List<UpPermission> findPermissionByUserId = this.upPermissionService.findPermissionByUserId(1L);
        System.out.println(findPermissionByUserId);
    }
}
