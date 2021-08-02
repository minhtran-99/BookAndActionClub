package com.book.bookclub.payload;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse{
        private String token;
        private String type = "Bearer";
        private int id;
        private String username;
        private String email;
        private List<String> roles;

        public JwtResponse(String accessToken, int id, String username, String email, List<String> roles) {
                this.token = accessToken;
                this.id = id;
                this.username = username;
                this.email = email;
                this.roles = roles;
        }
}
