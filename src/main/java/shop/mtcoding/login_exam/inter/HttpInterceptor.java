package shop.mtcoding.login_exam.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import shop.mtcoding.login_exam.handler.ex.CustomException;
import shop.mtcoding.login_exam.model.User;

@Component
public class HttpInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        logger.info("[preHandle]");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("principal");

        if (user == null) {
            throw new CustomException("로그인이 필요합니다.", "/loginForm");
            // response.sendRedirect("/loginForm");
            // return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.info("[postHandle]");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
            throws Exception {
        logger.info("[afterCompletion]");

    }
}
