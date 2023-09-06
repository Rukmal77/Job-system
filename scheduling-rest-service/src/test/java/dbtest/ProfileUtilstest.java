/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import db.ProfileUtils;
import db.Profile;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author DELL
 */
public class ProfileUtilstest {
    @Test
    public void testAddProfile() {
        ProfileUtils profileUtils = new ProfileUtils();

        String firstname = "home";
        String lastname = "sweet";
        String dob = "2001-12-11";
        String address = "40/E";
        String email = "home@gmail.com";
        String phonenumber = "72541424";
        String job = "Hr";
        String education = "Al";
        int userId = 2;

        boolean result = profileUtils.addProfile(firstname, lastname, dob, address, email, phonenumber, job, education, userId);

        assertTrue(result);
    }

    @Test
    public void testGetAllProfiles() {
        ProfileUtils profileUtils = new ProfileUtils();

        int userId = 2; // Assuming this user has profiles

        List<Profile> profiles = profileUtils.getAllProfiles(userId);

        assertFalse(profiles.isEmpty());

        // You can add more assertions based on your expected results
        for (Profile profile : profiles) {
            assertNotNull(profile.getFirstname());
            assertNotNull(profile.getLastname());
            assertNotNull(profile.getDob());
            assertNotNull(profile.getAddress());
            assertNotNull(profile.getEmail());
            assertNotNull(profile.getPhonenumber());
            assertNotNull(profile.getJob());
            assertNotNull(profile.getEducation());
        }
    }
}
