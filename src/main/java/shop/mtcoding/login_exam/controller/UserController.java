package shop.mtcoding.login_exam.controller;

import javax.servlet.http.HttpSession;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.login_exam.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.login_exam.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.login_exam.handler.ex.CustomException;
import shop.mtcoding.login_exam.model.User;
import shop.mtcoding.login_exam.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    private final HttpSession session;

    // private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/")
    public String main() {
        // if (session.getAttribute("principal") == null) {
        // throw new CustomException("로그인이 필요합니다.", "/loginForm");
        // } else {
        return "user/main";
        // }
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("아이디를 작성해주세요");
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("비밀번호를 작성해주세요");
        }
        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("이메일을 작성해주세요");
        }

        userService.회원가입(joinReqDto);

        return "redirect:/loginForm"; // 302
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {
        if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
            throw new CustomException("아이디를 작성해주세요");
        }
        if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
            throw new CustomException("비밀번호를 작성해주세요");
        }
        User principal = userService.로그인(loginReqDto);
        session.setAttribute("principal", principal);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/loginForm";
    }

}
