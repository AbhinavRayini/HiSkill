package com.hv.hiskill.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RoleTest {

    @Test
    public void testGetId() {
        Role role = new Role(ERole.ROLE_RMG);
        role.setId(1);
        assertEquals(Integer.valueOf(1), role.getId());
    }

    @Test
    public void testGetName() {
        Role role = new Role(ERole.ROLE_COPLEAD);
        assertEquals(ERole.ROLE_COPLEAD, role.getName());
    }

    @Test
    public void testSetName() {
        Role role = new Role( ERole.ROLE_ADMIN);
        role.setName(ERole.ROLE_EMPLOYEE);
        assertEquals(ERole.ROLE_EMPLOYEE, role.getName());
    }

    @Test
    public void testConstructor() {
        Role role = new Role(ERole.ROLE_ADMIN);
        assertEquals(ERole.ROLE_ADMIN, role.getName());
    }

    @Test
    public void testGeneratedIdIsNull() {
        Role role = new Role(ERole.ROLE_MANAGER);
        assertEquals(null, role.getId());
    }
}
