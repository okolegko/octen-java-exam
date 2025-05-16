package com.autoria.controller;

import com.autoria.dto.ProfanityRequest;
import com.autoria.service.ProfanityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profanity")
@RequiredArgsConstructor
public class ProfanityController {

    private final ProfanityService profanityService;

    @PostMapping("/check")
    public ResponseEntity<?> checkProfanity(@RequestBody @Valid ProfanityRequest request) {
        boolean hasProfanity = profanityService.containsProfanity(request.getText());
        return ResponseEntity.ok(new Object() {
            public final boolean profanity = hasProfanity;
        });
    }
}
