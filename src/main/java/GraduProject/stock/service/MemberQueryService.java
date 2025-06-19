package GraduProject.stock.service;


import GraduProject.stock.dto.LoginResultDto;
import GraduProject.stock.dto.MemberRequestDTO;
import GraduProject.stock.entity.Member;
import GraduProject.stock.repository.MemberRepository;
import GraduProject.stock.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResultDto login(MemberRequestDTO.LoginDto dto) {
        Member member = memberRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일 없음"));

        if (!passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("비밀번호 불일치");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(new SimpleGrantedAuthority(member.getRole().name()))
        );

        String token = jwtTokenProvider.generateToken(authentication);
        return new LoginResultDto(token);
    }
}

