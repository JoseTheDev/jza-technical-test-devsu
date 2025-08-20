package com.devsu.client_service.karate;

import com.intuit.karate.junit5.Karate;

public class ApiTestRunner {

    @Karate.Test
    Karate testAll() {
        return Karate.run("feature/client.feature").relativeTo(getClass());
    }

}
