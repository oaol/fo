package com.fo.up;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class UpUserDocTest extends BaseDocTest{

    @Test
    public void getUserById() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "1");
        this.mockMvc.perform(get("/user").params(params).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(
                document("user",
                        requestParameters(
                                parameterWithName("id").description("用户 id")
                                )
                        ,
                        responseFields(
                                subsectionWithPath("userId").description("userId"),
                                subsectionWithPath("avatar").description("avatar"),
                                subsectionWithPath("ctime").description("ctime"),
                                subsectionWithPath("email").description("email"),
                                subsectionWithPath("locked").description("locked"),
                                subsectionWithPath("password").description("password"),
                                subsectionWithPath("phone").description("phone"),
                                subsectionWithPath("realname").description("realname"),
                                subsectionWithPath("salt").description("salt"),
                                subsectionWithPath("sex").description("sex"),
                                subsectionWithPath("username").description("username")
                        )
                 )
           );
    }

}

