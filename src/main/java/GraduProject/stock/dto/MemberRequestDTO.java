package GraduProject.stock.dto;

import GraduProject.stock.domain.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDTO {

    @Getter @Setter
    public static class JoinDto {
        @NotBlank private String email;
        @NotBlank private String password;
        @NotBlank private String name;
        @NotNull private Role role;
    }

    @Getter @Setter
    public static class LoginDto {
        @NotBlank private String email;
        @NotBlank private String password;
    }
}


