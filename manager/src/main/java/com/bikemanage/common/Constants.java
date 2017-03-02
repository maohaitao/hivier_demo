package com.bikemanage.common;

/**
 * Created by a700 on 17/2/20.
 */
public class Constants {
    /**
     * prefix of REST API
     */
    public static final String URI_API = "/api";

    public static final String URI_POSTS = "/posts";

    public static final String URI_COMMENTS = "/comments";

    public static final String PRODUCES_JSON = "application/json;charset=UTF-8";

    public final static String SESSION_MENU = "SESSION_MENU";

    private Constants() {
        throw new InstantiationError( "Must not instantiate this class" );
    }

}
