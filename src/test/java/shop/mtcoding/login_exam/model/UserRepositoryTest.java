package shop.mtcoding.login_exam.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

@MybatisTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();

        // when
        int updateById = userRepository.updateById(1, "1244", "ssarUpdate@nate.com");
        User findById = userRepository.findById(1);
        // List<User> findByAll = userRepository.findByAll();
        int deleteById = userRepository.deleteById(2);
        // int insert = userRepository.insert("test", "1234", "test@nate.com");
        List<User> findByAll = userRepository.findByAll();

        // JavaObject -> JSON
        // String findByIdJS = om.writeValueAsString(findById);
        // String findByAllJS = om.writeValueAsString(findByAll);

        // System.out.println("findById 테스트 : " + findByIdJS);
        // System.out.println("findByAll 테스트 : " + findByAllJS);
        // System.out.println("deleteById 테스트 : " + deleteById);
        // System.out.println("insert 테스트 : " + insert);
        // System.out.println("updateById 테스트 : " + updateById);

        // then
        assertThat(findById.getPassword()).isEqualTo("1244"); // updateByID, findById 테스트
        assertThat(findByAll.get(0).getUsername()).isEqualTo("ssar"); // findAll 테스트
        assertThat(findByAll.get(1).getUsername()).isEqualTo("test"); // insert, delteById 테스트

    }
}
