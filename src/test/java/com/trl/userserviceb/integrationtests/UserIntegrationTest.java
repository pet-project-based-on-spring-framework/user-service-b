package com.trl.userserviceb.integrationtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trl.userserviceb.AbstractIntegrationTest;
import com.trl.userserviceb.argumentprovider.UserArgumentsProvider;
import com.trl.userserviceb.core.domain.User;
import com.trl.userserviceb.core.model.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.trl.userserviceb.api.v1.controller.UserController.BASE_URL;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class UserIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Sql(value = {"/sqlscripts/User_Before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sqlscripts/User_After.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void shouldReturnUserDto(List<User> testDataUserList,
                             List<UserDto> testDataUserDtoList) throws Exception {

        final UserDto expectedResponse = testDataUserDtoList.get(0);

        final Long userId = expectedResponse.getId();

        final String expectedJsonResult = mapper.writeValueAsString(expectedResponse);

        mockMvc.perform(get(BASE_URL + "/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().string(containsString(expectedJsonResult)))
                .andDo(print());
    }

    @Sql(value = {"/sqlscripts/User_Before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sqlscripts/User_After.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    void shouldReturnPageOfUserDto_defaultSizeOfPageIsTen() throws Exception {

        final int defaultSizeOfPage = 10;

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.pageable.pageSize", is(defaultSizeOfPage)))
                .andExpect(jsonPath("$.numberOfElements", is(defaultSizeOfPage)))
                .andDo(print());
    }

    @Sql(value = {"/sqlscripts/User_Before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sqlscripts/User_After.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    void shouldReturnPageOfUserDto() throws Exception {

        final int sizeOfPage = 8;

        mockMvc.perform(get(BASE_URL + "?size=" + sizeOfPage))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.pageable.pageSize", is(sizeOfPage)))
                .andExpect(jsonPath("$.numberOfElements", is(sizeOfPage)))
                .andDo(print());
    }

}
