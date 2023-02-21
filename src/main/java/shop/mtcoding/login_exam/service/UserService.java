package shop.mtcoding.login_exam.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.login_exam.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.login_exam.handler.ex.CustomException;
import shop.mtcoding.login_exam.model.User;
import shop.mtcoding.login_exam.model.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinReqDto joinReqDto) {
        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }

        try {
            userRepository.insert(joinReqDto.getUsername(), joinReqDto.getPassword(), joinReqDto.getEmail());
        } catch (Exception e) {
            throw new CustomException("내부적인 서버문제가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
