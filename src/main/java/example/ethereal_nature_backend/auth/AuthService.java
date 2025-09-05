package example.ethereal_nature_backend.auth;

import example.ethereal_nature_backend.user.Role;
import example.ethereal_nature_backend.user.User;
import example.ethereal_nature_backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow( () -> new RuntimeException("User not found"));
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    public void register(AuthRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already taken");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword((passwordEncoder.encode(request.getPassword())));
        user.setRole(Role.USER);
        userRepository.save(user);
    }


}
