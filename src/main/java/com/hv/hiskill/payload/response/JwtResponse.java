package com.hv.hiskill.payload.response;

import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long empId;
  private String empName;
  private String email;
  private List<String> roles;

  public JwtResponse(String accessToken, Long empId, String empName, String email, List<String> roles) {
    this.token = accessToken;
    this.empId = empId;
    this.empName = empName;
    this.email = email;
    this.roles = roles;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getEmpId() {
    return empId;
  }

  public void setEmpId(Long empId) {
    this.empId = empId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public List<String> getRoles() {
    return roles;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}












//
//import java.util.List;
//
//public class JwtResponse {
//  private String token;
//  private String type = "Bearer";
//  private Long id;
//  private String refreshToken;
//
//  public JwtResponse(String token, String type, Long id, String username, String email, List<String> roles) {
//    this.token = token;
//    this.type = type;
//    this.id = id;
//    this.username = username;
//    this.email = email;
//    this.roles = roles;
//  }
//
//  private String username;
//  private String email;
//  private List<String> roles;
//
////  public JwtResponse(String accessToken, String refreshToken, Long id, String username, String email, List<String> roles) {
////    this.token = accessToken;
////    this.refreshToken = refreshToken;
////    this.id = id;
////    this.username = username;
////    this.email = email;
////    this.roles = roles;
////  }
//
////  public JwtResponse(String token, Long id, String refreshToken, String username, String email, List<String> roles) {
////    this.token = token;
////    this.type = type;
////    this.id = id;
//////    this.refreshToken = refreshToken;
////    this.username = username;
////    this.email = email;
////    this.roles = roles;
////  }
//
//
//
//  public String getToken() {
//    return token;
//  }
//
//  public void setToken(String token) {
//    this.token = token;
//  }
//
//  public String getType() {
//    return type;
//  }
//
//  public void setType(String type) {
//    this.type = type;
//  }
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getRefreshToken() {
//    return refreshToken;
//  }
//
//  public void setRefreshToken(String refreshToken) {
//    this.refreshToken = refreshToken;
//  }
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public List<String> getRoles() {
//    return roles;
//  }
//
//  public void setRoles(List<String> roles) {
//    this.roles = roles;
//  }
//}
