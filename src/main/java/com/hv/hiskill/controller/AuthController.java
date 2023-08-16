package com.hv.hiskill.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.hv.hiskill.model.Employee;
import com.hv.hiskill.model.Role;
import com.hv.hiskill.payload.request.LoginRequest;
import com.hv.hiskill.payload.request.SignupRequest;
import com.hv.hiskill.payload.response.JwtResponse;
import com.hv.hiskill.payload.response.MessageResponse;
import com.hv.hiskill.repository.EmployeeRepository;
import com.hv.hiskill.security.jwt.JwtUtils;
import com.hv.hiskill.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hv.hiskill.model.ERole;

import com.hv.hiskill.repository.RoleRepository;




//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  EmployeeRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  public AuthController(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {

  }


  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    System.out.println(loginRequest.getEmpName() + "--" + loginRequest.getPassword());

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmpName(), loginRequest.getPassword()));

    System.out.println(authentication.isAuthenticated() + "--" + loginRequest.getPassword());

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
  }
}


/*
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest.getEmpName())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    Employee user = new Employee(signUpRequest.getEmpName(),
            signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

//    if (strRoles == null) {
//      Role rmgRole = roleRepository.findByName(ERole.ROLE_RMG)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(rmgRole);
//    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          case "cop_lead":
            Role copRole = roleRepository.findByName(ERole.ROLE_COPLEAD)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(copRole);

            break;
          case "rmg":
            Role rmgRole = roleRepository.findByName(ERole.ROLE_RMG)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(rmgRole);

            break;
          case "manager":
            Role managerRole = roleRepository.findByName(ERole.ROLE_MANAGER)
                    .orElseThrow(() -> new RuntimeException("Error : Role is not Found"));
            roles.add(managerRole);

            break;
          default:
            Role empRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Error : Role is not found"));
            roles.add(empRole);
        }
      });


    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
*/






//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import com.bezkoder.springjwt.exception.TokenRefreshException;
//import com.bezkoder.springjwt.models.RefreshToken;
//import com.bezkoder.springjwt.payload.request.TokenRefreshRequest;
//import com.bezkoder.springjwt.payload.response.TokenRefreshResponse;
//import com.bezkoder.springjwt.security.services.RefreshTokenService;
//import jakarta.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bezkoder.springjwt.models.ERole;
//import com.bezkoder.springjwt.models.Role;
//import com.bezkoder.springjwt.models.User;
//import com.bezkoder.springjwt.payload.request.LoginRequest;
//import com.bezkoder.springjwt.payload.request.SignupRequest;
//import com.bezkoder.springjwt.payload.response.JwtResponse;
//import com.bezkoder.springjwt.payload.response.MessageResponse;
//import com.bezkoder.springjwt.repository.RoleRepository;
//import com.bezkoder.springjwt.repository.UserRepository;
//import com.bezkoder.springjwt.security.jwt.JwtUtils;
//import com.bezkoder.springjwt.security.services.UserDetailsImpl;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//  @Autowired
//  AuthenticationManager authenticationManager;
//  @Autowired
//  RefreshTokenService refreshTokenService;
//
//  @Autowired
//  UserRepository userRepository;
//
//  @Autowired
//  JwtUtils jwtUtils;
//  @Autowired
//  RoleRepository roleRepository;
//
//  @Autowired
//  PasswordEncoder encoder;
//
//
//
////  @PostMapping("/signin")
////  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
////
////    Authentication authentication = authenticationManager.authenticate(
////        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
////
////    SecurityContextHolder.getContext().setAuthentication(authentication);
////    String jwt = jwtUtils.generateJwtToken(authentication);
////
////    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
////    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
////            .collect(Collectors.toList());
////
////    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
////
////    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
////            userDetails.getUsername(), userDetails.getEmail(), roles));
////  }
////
//
//  @PostMapping("/signin")
//  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//    Authentication authentication = authenticationManager
//            .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//    String jwt = jwtUtils.generateJwtToken((Authentication) userDetails);
//
//    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//            .collect(Collectors.toList());
//
//    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
//
//      return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
//              userDetails.getUsername(), userDetails.getEmail(), roles));
//
//  }
//
//  @PostMapping("/signup")
//  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//      return ResponseEntity
//          .badRequest()
//          .body(new MessageResponse("Error: Username is already taken!"));
//    }
//
//    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//      return ResponseEntity
//          .badRequest()
//          .body(new MessageResponse("Error: Email is already in use!"));
//    }
//
//    // Create new user's account
//    User user = new User(signUpRequest.getUsername(),
//               signUpRequest.getEmail(),
//               encoder.encode(signUpRequest.getPassword()));
//
//    Set<String> strRoles = signUpRequest.getRole();
//    Set<Role> roles = new HashSet<>();
//
//    if (strRoles == null) {
//      Role userRole = roleRepository.findByName(ERole.ROLE_RMG)
//          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(userRole);
//    } else {
//      strRoles.forEach(role -> {
//        switch (role) {
//        case "admin":
//          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(adminRole);
//
//          break;
//        case "mod":
//          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(modRole);
//
//          break;
//        default:
//          Role userRole = roleRepository.findByName(ERole.ROLE_RMG)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(userRole);
//        }
//      });
//    }
//
//    user.setRoles(roles);
//    userRepository.save(user);
//
//    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//  }
//  @PostMapping("/refreshtoken")
//  public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
//    String requestRefreshToken = request.getRefreshToken();
//
//    return refreshTokenService.findByToken(requestRefreshToken)
//            .map(refreshTokenService::verifyExpiration)
//            .map(RefreshToken::getUser)
//            .map(user -> {
//              String token = jwtUtils.generateTokenFromUsername(user.getUsername());
//              return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
//            })
//            .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
//                    "Refresh token is not in database!"));
//  }
//}