package com.example.demoSpringSecurity.auth;

import com.example.demoSpringSecurity.config.JwtService;
import com.example.demoSpringSecurity.user.Role;
import com.example.demoSpringSecurity.user.User;
import com.example.demoSpringSecurity.user.UserRepository;
import lombok.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Diese Methode erstellt einen neuen Benutzer und gibt das JWT zurück.
    public AuthenticationResponse register(RegisterRequest request) {
        // Ein neuer Benutzer wird mit den angegebenen Daten erstellt.
        var user = User.builder()
                .vorname(request.getVorname())
                .nachname(request.getNachname())
                .email(request.getEmail())
                .passwort(passwordEncoder.encode(request.getPasswort()))
                .role(Role.USER)
                .build();
        userRepository.save(user); // Der neue Benutzer wird in der Datenbank gespeichert.
        var jwtToken = jwtService.generateToken(user); // Ein JWT wird mit den Daten des neuen Benutzers generiert.
        return AuthenticationResponse.builder().jwtToken(jwtToken).build(); // Das generierte JWT wird zurückgegeben.
    }

    // Diese Methode authentifiziert den Benutzer und gibt das JWT zurück.
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPasswort())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(); // Der Benutzer wird anhand der E-Mail-Adresse in der Datenbank gesucht und zurückgegeben.
        var jwtToken = jwtService.generateToken(user); // Ein JWT wird mit den Daten des authentifizierten Benutzers generiert.
        return AuthenticationResponse.builder().jwtToken(jwtToken).build();
    }
}
