/*package web.handler;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Component
public class MyAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

   protected Log logger = LogFactory.getLog(this.getClass());

   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse , Authentication authentication ) throws IOException, ServletException {
        handle(httpServletRequest,httpServletResponse,authentication);
        clearAuthenticationAttributes(httpServletRequest);

    }

    protected void handle(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse , Authentication authentication) throws IOException{
        String targetUrl= determineTargetUrl(authentication);
        if(httpServletResponse.isCommitted()){
            logger.debug("Response has already been committed. Unable to redirect to" + targetUrl);
            return;
        }
    }


    protected String determineTargetUrl(Authentication authentication){
        boolean isUser=false;
        boolean isAdmin=false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority grantedAuthority:authorities){
            if(grantedAuthority.getAuthority().equals("USER")){
                isUser=true;
                break;
            } else if(grantedAuthority.getAuthority().equals("ADMIN")){
                isAdmin=true;
                break;
            }
        }
        if(isUser){
            return "/user.html";
        }else if(isAdmin){
            return "/add.html";
        }else{
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session==null){
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy){
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy(){
        return redirectStrategy;
    }

}*/