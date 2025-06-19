package GraduProject.stock.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt.token")
@Getter
@Setter
public class JwtProperties {
    private String secretKey = "";
    private Expiration expiration;

    @Getter @Setter
    public static class Expiration {
        private Long access;
    }
}

