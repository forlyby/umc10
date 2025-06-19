package GraduProject.stock.controller;



import GraduProject.stock.dto.LoginResultDto;
import GraduProject.stock.dto.MemberRequestDTO;
import GraduProject.stock.service.MemberCommandService;
import GraduProject.stock.service.MemberQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")

public class MemberViewController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody @Valid MemberRequestDTO.JoinDto dto) {
        memberCommandService.join(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResultDto> login(@RequestBody @Valid MemberRequestDTO.LoginDto dto) {
        LoginResultDto token = memberQueryService.login(dto);
        return ResponseEntity.ok(token);
    }
}
