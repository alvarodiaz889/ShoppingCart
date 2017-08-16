package edu.mum.utilities;

import edu.mum.entity.User;
import edu.mum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utility {


    public static User getUserFromSession(HttpServletRequest request, UserService service)
    {
        User user = null;
        try
        {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") == null)
            {
                String strUser = SecurityContextHolder.getContext().getAuthentication().getName();
                user = service.findByUsername(strUser);
                session.setAttribute("user",user);
                System.out.println(user);
            }
            else
            {
                user = (User)session.getAttribute("user");
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
