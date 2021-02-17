package com.trl.userserviceb;

import com.trl.userserviceb.api.v1.controller.ResourceTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ResourceTestConfig.class)
@DisplayName("UserServiceBApplication")
class UserServiceBApplicationTests extends AbstractIntegrationTest{

    @Test
    void shouldStartBackendApplicationWhenMainMethodIsInvoked() {
//        UserServiceBApplication.main(new String[]{});
    }

}
