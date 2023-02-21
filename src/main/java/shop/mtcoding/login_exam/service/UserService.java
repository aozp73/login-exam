package shop.mtcoding.login_exam.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.login_exam.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.login_exam.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.login_exam.handler.ex.CustomException;
import shop.mtcoding.login_exam.model.User;
import shop.mtcoding.login_exam.model.UserRepository;
import shop.mtcoding.login_exam.util.PasswordSha256;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinReqDto joinReqDto) {
        // System.out.println("암호화 전 : " + joinReqDto.getPassword());
        // 비밀번호 암호화

        String salt = PasswordSha256.getSalt();

        String encryPassword = PasswordSha256.encrypt(joinReqDto.getPassword(), salt);

        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }

        try {
            userRepository.insert(joinReqDto.getUsername(), encryPassword, joinReqDto.getEmail(), salt);
        } catch (Exception e) {
            throw new CustomException("내부적인 서버문제가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(readOnly = true)
    public User 로그인(LoginReqDto loginReqDto) {
        // username 일치 확인
        User user = userRepository.findByUsername(loginReqDto.getUsername());
        if (user == null) {
            throw new CustomException("아이디를 확인해주세요");
        }

        String encryPassword = PasswordSha256.encrypt(loginReqDto.getPassword(), user.getSalt());

        // password 일치 확인
        if (!user.getPassword().equals(encryPassword)) {
            throw new CustomException("패스워드를 확인해주세요");
        }

        return user;
    }
}
