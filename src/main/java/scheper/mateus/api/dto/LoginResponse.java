package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class LoginResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "JWT access token to authenticate user requests.", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String accessToken;

    @Schema(description = "JWT refresh token to obtain new access tokens.", example = "dGhpc2lzYXJlZnJlc2h0b2tlbg==")
    private String refreshToken;

    @Schema(description = "The type of the token.", example = "Bearer")
    private String tokenType = "Bearer"; // default
}
