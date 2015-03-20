package com.mftour.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookieUtil
 */
public class CookieUtil {

    private static Logger logger = Logger.getLogger(CookieUtil.class);

    private static Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(86400 * 10000);//10000 DAYS
        return cookie;

    }

    /**
     * 设置COOKIE
     *
     * @param resp
     * @param cookieName
     * @param cookieValue
     */
    public static void setCookie(HttpServletResponse resp, String cookieName, String cookieValue) {

        resp.addCookie(createCookie(cookieName, cookieValue));
    }

    /**
     * 获取COOKIE
     *
     * @param request
     * @param cookieName
     * @return String
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        if (request == null) return null;
        if (cookieName == null) return null;
        if (cookieName.length() == 0) return null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            logger.error("cookie is null!");
        else {
//            logger.debug("cookie size:" + cookies.length);
            for (Cookie c : cookies) {
//                logger.debug("cookie : " + c.getName() + " / " + c.getValue());
                if (c.getName().equalsIgnoreCase(cookieName)) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
}
