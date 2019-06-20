package com.gojek;

import org.testng.annotations.DataProvider;

public class AmazonDataProvider {

    @DataProvider(name = "serachProduct")
    public static Object[][] product(){
        return new Object[][] {
                {"macbook air", "macbook"},
                {"ipad","ipad"},
                {"washing machine","washing"}
        };
    }
}
