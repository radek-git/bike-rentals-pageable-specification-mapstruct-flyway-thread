package com.radek.bikerentals.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static String getUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal(); //to co się autoryzuje, czyli np. po username, po haśle itp
        if (principal instanceof UserDetails) { //jeżeli jest UserDetails tzn że jest zalogowany użytkownik
            UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();
            String username = userDetails.getUsername();

//            logger.debug("Currently logged in username: {}", username);
            return username;
        }

        // Anonymous or no authentication.
//        logger.debug("Username is null, because user is anonymous or not authenticated");

        return null;
    }
}
