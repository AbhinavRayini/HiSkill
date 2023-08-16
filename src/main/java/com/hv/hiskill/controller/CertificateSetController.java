package com.hv.hiskill.controller;

import com.hv.hiskill.model.CertificateSet;
import com.hv.hiskill.service.CertificateSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/CertificationSet")
@Api(tags = "Certificates")
public class CertificateSetController {

    @Autowired
    private final CertificateSetService certificatesetService;

    public CertificateSetController(CertificateSetService certificatesetService) {
        this.certificatesetService = certificatesetService;
    }

    @ApiOperation("Get All Certificates")
    @GetMapping
    public List<CertificateSet> getAllCertificates() {
        return certificatesetService.getAllCertificates();
    }

    @ApiOperation("Get a certificate by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    @GetMapping("/{id}")
    public Optional<CertificateSet> getCertificateById(@PathVariable Integer id) {
        return certificatesetService.getCertificateById(id);
    }

    @ApiOperation("Create a certificate")
    @PostMapping
    public CertificateSet createCertificate(@RequestBody CertificateSet certificate) {
        return certificatesetService.createCertificate(certificate);
    }

    @ApiOperation("Update a certificate by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    @PutMapping("/{id}")
    public CertificateSet updateCertificate(@PathVariable Integer id, @RequestBody CertificateSet updatedCertificate) {
        return certificatesetService.updateCertificate(id, updatedCertificate);
    }

    @ApiOperation("Delete a certificate by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Integer id) {
        certificatesetService.deleteCertificate(id);
    }
}