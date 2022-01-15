package com.kivanc.spring.utility;

import javax.servlet.http.HttpServletRequest;

public class Utility {
    public static String getSiteURl(HttpServletRequest request){
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(),"");
    }
}
