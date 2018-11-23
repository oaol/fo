package com.fo.up;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.fo.up.config.TestProperties;

public class AbTest extends BaseDocTest{

    @Autowired
    private TestProperties testProperties;

    @Test
    public void indexExample() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("page", "0");
    params.add("size", "2");
    this.mockMvc.perform(get("/user/page").params(params).contentType(MediaType.APPLICATION_JSON_UTF8))
    .andExpect(status().isOk())
    .andDo(
            document("ab",
                    requestParameters(
                            parameterWithName("page").description("用户姓名"),
                            parameterWithName("size").description("用户性别，0=女，1=男"))
                    ,
                    responseFields(
                            subsectionWithPath("code").description("接口版本"),
                            subsectionWithPath("message").description("接口版本"),
                            subsectionWithPath("data").description("接口版本")
                    )
             )
       );
    }
    @Test
    public void propertiesTest() throws Exception {
        System.out.println(JSONObject.toJSONString(testProperties));
    }
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Test
    public void test() {
        String ss = this.restTemplate.getForObject("https://spring.io", String.class);
        System.out.println(ss);
    }

}

