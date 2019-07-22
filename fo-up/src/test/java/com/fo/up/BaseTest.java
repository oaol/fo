package com.fo.up;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fo.common.core.util.FileUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    static {
        // "xxx/fo/fo-up"
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath);
        String configPath = FileUtils.getNParent(file, 1).getPath();
     // 和 vm arguments 保持统一，不在location 上维护 fo-up 目录
        System.setProperty("spring.config.name", "fo-up/application");
        System.setProperty("spring.config.location", configPath + "/fo-config/");
    }
    
    /**
     * 必需，否则报错，  No runnable methods
     */
    @Test
    public void test() {
        
    }

}
