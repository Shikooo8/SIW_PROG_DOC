package it.uniroma3.siw_festival.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    // @ModelAttribute("userDetails")
    // public UserDetails getUser() {
    //     UserDetails user = null;
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     if (!(authentication instanceof AnonymousAuthenticationToken)) {
    //         user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     }
    //     return user;
    // }

    @ModelAttribute("userDetails")
    public UserDetails getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) { // login con username e password
            return (UserDetails) principal;
        }
        if (principal instanceof OidcUser) { // login con Google
            OidcUser oidcUser = (OidcUser) principal;
            return User.withUsername(oidcUser.getEmail())
                    .password("")
                    .authorities(oidcUser.getAuthorities())
                    .build();
        }
        return null;
    }
}