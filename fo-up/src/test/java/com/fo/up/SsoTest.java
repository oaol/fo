package com.fo.up;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONObject;

public class SsoTest extends BaseDocTest{
    
    @Test
    public void loginTest() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("username", "admin");
    params.add("password", "123456");
    this.mockMvc.perform(
            post("/sso/login").contentType(MediaType.APPLICATION_JSON)
            .content(JSONObject.toJSONString(params))
            )
    .andExpect(status().isOk())
    .andDo(
            document("login",
                    requestParameters(
                            parameterWithName("username").description("用户姓名"),
                            parameterWithName("password").description("登录密码"))
             )
       );
    }
}
