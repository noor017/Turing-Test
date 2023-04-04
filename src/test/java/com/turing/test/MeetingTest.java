package com.turing.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.turing.test.Meeting.scheduleMeetings;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Tuesday, 04 April 2023 23:27
 */

@SpringBootTest
public class MeetingTest {
    @Test
    public void testMaxAttendeesMeetings() {
        List<List<Integer>> meetings = new ArrayList<>();
        meetings.add(Arrays.asList(0, 1));
        meetings.add(Collections.singletonList(0));
        meetings.add(Collections.singletonList(1));

        System.out.println(scheduleMeetings(meetings));
    }
}
