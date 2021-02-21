package com.trl.userserviceb.argumentprovider;

import com.trl.userserviceb.core.model.UserDto;
import com.trl.userserviceb.core.domain.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {

    private final List<User> testDataUserList = new ArrayList<>();

    private final List<UserDto> testDataUserDtoList = new ArrayList<>();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        initData();

        return Stream.of(
                Arguments.of(testDataUserList, testDataUserDtoList)
        );
    }

    private void initData() {
        testDataUserList.add(createUser(1L, 1, 2, 29));
        testDataUserList.add(createUser(2L, 3, 4, 28));
        testDataUserList.add(createUser(3L, 5, 6, 27));
        testDataUserList.add(createUser(4L, 7, 8, 26));
        testDataUserList.add(createUser(5L, 9, 10, 25));
        testDataUserList.add(createUser(6L, 11, 12, 24));
        testDataUserList.add(createUser(7L, 13, 14, 23));
        testDataUserList.add(createUser(8L, 15, 16, 22));
        testDataUserList.add(createUser(9L, 17, 18, 21));
        testDataUserList.add(createUser(10L, 19, 20, 20));
        testDataUserList.add(createUser(11L, 21, 22, 19));
        testDataUserList.add(createUser(12L, 23, 24, 18));

        testDataUserDtoList.add(createUserDto(1L, 1, 2, 29));
        testDataUserDtoList.add(createUserDto(2L, 3, 4, 28));
        testDataUserDtoList.add(createUserDto(3L, 5, 6, 27));
        testDataUserDtoList.add(createUserDto(4L, 7, 8, 26));
        testDataUserDtoList.add(createUserDto(5L, 9, 10, 25));
        testDataUserDtoList.add(createUserDto(6L, 11, 12, 24));
        testDataUserDtoList.add(createUserDto(7L, 13, 14, 23));
        testDataUserDtoList.add(createUserDto(8L, 15, 16, 22));
        testDataUserDtoList.add(createUserDto(9L, 17, 18, 21));
        testDataUserDtoList.add(createUserDto(10L, 19, 20, 20));
        testDataUserDtoList.add(createUserDto(11L, 21, 22, 19));
        testDataUserDtoList.add(createUserDto(12L, 23, 24, 18));

    }

    private User createUser(Long id, int createdDay, int updatedDay, int dayOfBirthday) {
        return new User.Builder()
                .withCreatedDate(LocalDateTime.of(2021, 1, createdDay, 8, 30))
                .withUpdatedDate(LocalDateTime.of(2021, 1, updatedDay, 8, 30))
                .withId(id)
                .withFirstName("testUserFirstName" + id)
                .withLastName("testUserLastName" + id)
                .withUsername("testUserUsername" + id)
                .withEmail("testUserEmail" + id + "@email.com")
                .withPassword("strong_password" + id)
                .withBirthday(LocalDate.of(2000, 1, dayOfBirthday))
                .build();
    }

    private UserDto createUserDto(Long id, int createdDay, int updatedDay, int dayOfBirthday) {
        return new UserDto.Builder()
                .withCreatedDate(LocalDateTime.of(2021, 1, createdDay, 8, 30))
                .withUpdatedDate(LocalDateTime.of(2021, 1, updatedDay, 8, 30))
                .withId(id)
                .withFirstName("testUserFirstName" + id)
                .withLastName("testUserLastName" + id)
                .withUsername("testUserUsername" + id)
                .withEmail("testUserEmail" + id + "@email.com")
                .withPassword("strong_password" + id)
                .withBirthday(LocalDate.of(2000, 1, dayOfBirthday))
                .build();
    }

}

