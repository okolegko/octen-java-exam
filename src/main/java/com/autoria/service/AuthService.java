package com.autoria.service;

import com.autoria.dto.AuthRequest;
import com.autoria.dto.AuthResponse;
import com.autoria.model.Role;
import com.autoria.model.User;
import com.autoria.repository.RoleRepository;
import com.autoria.repository.UserRepository;
import com.autoria.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.*;
import org.springframework.security
