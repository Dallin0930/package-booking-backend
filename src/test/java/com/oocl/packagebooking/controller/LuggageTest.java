package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.modle.Luggage;
import com.oocl.packagebooking.modle.LuggageStroe;
import com.oocl.packagebooking.service.LuggageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class LuggageTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    LuggageService luggageService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void should_return_luggageOrder_when_add_luggage_to_store() throws  Exception{
        Luggage luggage1= new Luggage("yae",1524521251);

        Luggage luggage2= new Luggage("dallin",187125486);
        luggage2.getOrderId((long)1);

        LuggageStroe luggageStroe= new LuggageStroe("Stroe1");
        luggageStroe.getStoreId((long)2);
        luggage2.setLuggageStroe(luggageStroe);

        given(luggageService.addOrder((long)2,luggage1)).willReturn(luggage2);
        try {
            mockMvc.perform(post("/order/LuggageStore/2")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(luggage1)))
                    .andExpect(content().string(objectMapper.writeValueAsString(luggage2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_return_changed_luggage_when_luggage_status_is_changed() throws Exception{
        Luggage luggage= new Luggage("cat",1845865596,"no pick");
        luggage.setOrderId((long) 1);

        LuggageStroe luggageStroe= new LuggageStroe("storeA");
        luggageStroe.setStoreId((long) 2);

        given(luggageService.updateStatus((long) 1))
                .willReturn(luggage);

        mockMvc.perform(post("/orders/1")
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(content().string(objectMapper.writeValueAsString(luggage)));

    }
}
