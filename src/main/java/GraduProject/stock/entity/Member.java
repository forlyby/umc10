package GraduProject.stock.entity;

import jakarta.persistence.*;
import lombok.*;
import GraduProject.stock.domain.enums.Role;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}

