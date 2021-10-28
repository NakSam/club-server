package com.naksam.clubserver.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Optional;
import java.util.stream.Stream;

public class HttpSupport {
//    public static  String getToken(HttpServletRequest req, String name) {
//        req.getHeader()
//    }

    public static Optional<Cookie> getCookie(HttpServletRequest req, String name) {
        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            System.out.println(element + " : " + req.getHeader(element));
        }

        for (Cookie cookie : req.getCookies()) {
            System.out.println(cookie);
        }


        return Stream.of(req.getCookies())
                .filter(cookie -> name.equals(cookie.getName()) && !cookie.getValue()
                        .isEmpty())
                .findFirst();
    }
}
