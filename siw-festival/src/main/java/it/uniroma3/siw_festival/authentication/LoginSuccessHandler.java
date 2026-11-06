package it.uniroma3.siw_festival.authentication;

import java.io.IOException;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public LoginSuccessHandler() {
        setDefaultTargetUrl("/");
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        org.springframework.security.core.Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        boolean haRichiestaSalvata = session != null
                && session.getAttribute("SPRING_SECURITY_SAVED_REQUEST") != null;
        String target = session != null ? (String) session.getAttribute("LOGIN_REDIRECT") : null;

        if (!haRichiestaSalvata && target != null) {
            session.removeAttribute("LOGIN_REDIRECT");
            getRedirectStrategy().sendRedirect(request, response, target);
            return;
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}