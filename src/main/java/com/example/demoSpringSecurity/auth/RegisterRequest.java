package com.example.demoSpringSecurity.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Daten die für die Erstellung eines neuen Benutzers benötigt werden
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
}
