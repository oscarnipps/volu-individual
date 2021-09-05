package com.example.volu.data;

import java.util.regex.Pattern;

public class Constants {
    public static final String DATABASE_NAME = "volu.db" ;

    public static final String API_BASE_URL = "api.volu.com/v1" ;

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
}
