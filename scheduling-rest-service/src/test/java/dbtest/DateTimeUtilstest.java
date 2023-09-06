/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import db.DateTimeUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author DELL
 */
public class DateTimeUtilstest {
    private DateTimeUtils dateTimeUtils;

    public DateTimeUtilstest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Set up any resources or configurations before all tests
    }

    @AfterAll
    public static void tearDownClass() {
        // Clean up resources after all tests are done
    }

    @BeforeEach
    public void setUp() {
        // Set up any necessary objects or states before each test
        dateTimeUtils = new DateTimeUtils();
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources after each test
    }

    @Test
    public void testSaveDateTime() {
        System.out.println("testSaveDateTime");

        String selectedDateTime = "2023-04-01T12:25";
        int userId = 3;

        boolean result = dateTimeUtils.saveDateTime(selectedDateTime, userId);

        assertTrue(result);
    }

    @Test
    public void testSaveOrUpdateDateTime() {
        System.out.println("testSaveOrUpdateDateTime");

        String selectedDateTime = "2023-12-19T15:30";
        int userId = 2;

        boolean result = dateTimeUtils.saveOrUpdateDateTime(selectedDateTime, userId);

        assertTrue(result);
    }
}
