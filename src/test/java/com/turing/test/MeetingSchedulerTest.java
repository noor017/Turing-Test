package com.turing.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class MeetingSchedulerTest {
    @Test
    public void testLargerOfTwoMeetings() {
        List<List<Integer>> meetings = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2)
        );
        MeetingScheduler scheduler = new MeetingScheduler(meetings);
        MeetingSubset result = scheduler.getMaxAttendeesSubset();
        assertEquals(Arrays.asList(Arrays.asList(0, 1, 2)), new ArrayList<>(result.getMeetings()));
        assertEquals(3, result.getAttendees());
    }

    @Test
    public void testOneLargeOrTwoSmallMeetings() {
        List<List<Integer>> meetings = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0),
                Arrays.asList(1)
        );
        MeetingScheduler scheduler = new MeetingScheduler(meetings);
        MeetingSubset result = scheduler.getMaxAttendeesSubset();
        List<List<Integer>> expectedMeetings = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0), Arrays.asList(1));
        int expectedAttendees = 2;
        assertEquals(expectedAttendees, result.getAttendees());
    }

    @Test
    public void tesAttendeeLosesOutMeetings() {
        List<List<Integer>> meetings = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(2, 3)
        );
        MeetingScheduler scheduler = new MeetingScheduler(meetings);
        MeetingSubset result = scheduler.getMaxAttendeesSubset();
        List<List<Integer>> expectedMeetings = Arrays.asList(Arrays.asList(0, 1, 2));
        int expectedAttendees = 4;
        assertEquals(expectedAttendees, result.getAttendees());
    }
}
