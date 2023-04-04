package com.turing.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Tuesday, 04 April 2023 23:27
 */

@SpringBootTest
public class EventPackingTest {
    @Test
    void testGetAttendees() {
        List<List<Integer>> meetings = new ArrayList<>();
        meetings.add(Arrays.asList(1, 2, 3));
        meetings.add(Arrays.asList(2, 3, 4));
        meetings.add(Arrays.asList(3, 4, 5));
        Set<Integer> expectedAttendees = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expectedAttendees, EventPacking.getAttendees(meetings));
    }

    @Test
    void testGetAttendeesEmptyList() {
        List<List<Integer>> meetings = new ArrayList<>();
        Set<Integer> expectedAttendees = new HashSet<>();
        assertEquals(expectedAttendees, EventPacking.getAttendees(meetings));
    }

    @Test
    void testGetAttendeesSingleMeeting() {
        List<List<Integer>> meetings = new ArrayList<>();
        meetings.add(Arrays.asList(1, 2, 3));
        Set<Integer> expectedAttendees = new HashSet<>(Arrays.asList(1, 2, 3));
        assertEquals(expectedAttendees, EventPacking.getAttendees(meetings));
    }
}
