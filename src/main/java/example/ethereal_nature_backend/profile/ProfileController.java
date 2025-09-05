package example.ethereal_nature_backend.profile;

import example.ethereal_nature_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileRepository repo;
    private final UserService userService;

    @GetMapping
    public Profile getProfile() {
        return repo.findByUser(userService.getCurrentUser())
                .orElse(new Profile());
    }

    @PutMapping
    public Profile updateProfile(@RequestBody Profile profileData) {
        Profile profile = repo.findByUser(userService.getCurrentUser())
                .orElse(new Profile());
        profile.setFullName(profileData.getFullName());
        profile.setBio(profileData.getBio());
        profile.setUser(userService.getCurrentUser());
        return repo.save(profile);
    }

}
