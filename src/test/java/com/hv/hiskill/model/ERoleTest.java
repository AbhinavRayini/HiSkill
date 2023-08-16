package com.hv.hiskill.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ERoleTest {

    @Test
    public void testRoleRMG() {
        ERole role = ERole.ROLE_RMG;
        assertEquals("ROLE_RMG", role.name());
    }

    @Test
    public void testRoleCOPLead() {
        ERole role = ERole.ROLE_COPLEAD;
        assertEquals("ROLE_COPLEAD", role.name());
    }

    @Test
    public void testRoleAdmin() {
        ERole role = ERole.ROLE_ADMIN;
        assertEquals("ROLE_ADMIN", role.name());
    }

    @Test
    public void testRoleEmployee() {
        ERole role = ERole.ROLE_EMPLOYEE;
        assertEquals("ROLE_EMPLOYEE", role.name());
    }

    @Test
    public void testRoleManager() {
        ERole role = ERole.ROLE_MANAGER;
        assertEquals("ROLE_MANAGER", role.name());
    }
}
