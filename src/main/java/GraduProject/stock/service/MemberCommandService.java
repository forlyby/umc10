package GraduProject.stock.service;


import GraduProject.stock.dto.MemberRequestDTO;
import GraduProject.stock.entity.Member;
import GraduProject.stock.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void joinMember(MemberRequestDTO.JoinDto dto) {
        Member member = Member.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
        memberRepository.save(member);
    }
}
