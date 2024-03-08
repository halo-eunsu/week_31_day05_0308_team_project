package com.nhnacademy.accountapi.security.details;

import com.nhnacademy.accountapi.domain.User;
import com.nhnacademy.accountapi.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO#4 - 회원 검증을 위해서 username(회원 아이디) 데이터베이스에 조회 합니다.
        if (userRepository.findById(username).isPresent()) {
            //여러분의 쇼핑몰 구조에 맞게 데이터 베이스에서 조회하는 로직을 추가하세요.
            //또는 RestTemplate를 이용해서 shoppingmall-api 서버로 회원정보를 호출해서 PrincipalDetails 객체를 생성할 수도 있습니다.

            Optional<User> existUser = userRepository.findById(username);
            String useId = existUser.get().getUserId();
            String userName = existUser.get().getUserName();
            String pwd = existUser.get().getUserPassword();
            User user = User.createUser(useId, userName, pwd);
//            User user = User.createUser(existUse.getUserId(), "엔에이치엔아카데미", "nhnacademy12345*");
            return new PrincipalDetails(user);
        } else {
            throw new UsernameNotFoundException("없는 ID" + username);
        }
    }

}
