package com.UserActivityConsumer.DTO;

import com.UserActivityConsumer.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public static class Converter{
        public static com.UserActivityConsumer.user.User convertDtoToEntity(User dto){
            return com.UserActivityConsumer.user.User.builder()
                    .firstname(dto.getFirstname())
                    .lastname(dto.getLastname())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .role(Role.USER)
                    .build();
        }
    }
}
