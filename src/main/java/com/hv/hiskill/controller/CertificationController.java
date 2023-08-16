
package com.hv.hiskill.controller;

import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;
import com.hv.hiskill.service.CertificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/certification")
@Api(tags = "Certification API")
public class CertificationController {

    private final CertificationService certificationService;

    @Autowired
    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping
    @ApiOperation(value = "Get all details")

    public ResponseEntity<List<Certifications>> getAllCertifications() {
        List<Certifications> certificationsList = certificationService.getAllCertifications();
        return ResponseEntity.ok(certificationsList);
    }

    @PostMapping
    @ApiOperation(value = "Create new details")

    public ResponseEntity<Certifications> addCertification(@RequestBody Certifications certification) {
        Certifications savedCertification = certificationService.addCertification(certification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCertification);
    }

    @GetMapping("/{empId}")
    @ApiOperation(value = "Get details  with a specific empId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public List<CertificationsDto> getCertificationdetails(@PathVariable Long empId) {
        return certificationService.getCertificationDetails(empId);
    }
}
