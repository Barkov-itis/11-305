package ru.itis.dto;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String role;

    public boolean isAdmin() {
        return this.role.equals("ADMIN");
    }
}
