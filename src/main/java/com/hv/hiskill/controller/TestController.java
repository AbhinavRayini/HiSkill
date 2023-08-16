package com.hv.hiskill.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class  TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/rmg")
  @PreAuthorize("hasRole('RMG')")
  public String rmgAccess() {
    return "RMG Content.";
  }

  @GetMapping("/manager")
  @PreAuthorize("hasRole('MANAGER')")
  public String managerAccess() {
    return "MANAGER Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }

  @GetMapping("/emp")
  @PreAuthorize("hasRole('EMPLOYEE')")
  public String empAccess() {
    return "EMPLOYEE Board.";
  }

  @GetMapping("/cop_lead")
  @PreAuthorize("hasRole('COP_LEAD')")
  public String copAccess() {
    return "COPLEAD Board.";
  }

}
