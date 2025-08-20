package com.devsu.account_service.karate;

import com.intuit.karate.junit5.Karate;

public class ApiTestRunner {

    @Karate.Test
    Karate testAll() {
        return Karate.run("feature/account.feature", "feature/transaction.feature").relativeTo(getClass());
    }
    
}
