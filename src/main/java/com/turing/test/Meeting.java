package com.turing.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Wednesday, 05 April 2023 00:16
 */
public class Meeting {
    public static List<List<Integer>> scheduleMeetings(List<List<Integer>> meetings) {
        // Sort meetings by size in descending order
        meetings.sort((a, b) -> b.size() - a.size());

        List<List<Integer>> selectedMeetings = new ArrayList<>();
        Set<Integer> bookedAttendees = new HashSet<>();

        for (List<Integer> meeting : meetings) {
            boolean canBookMeeting = true;
            for (int attendee : meeting) {
                if (bookedAttendees.contains(attendee)) {
                    canBookMeeting = false;
                    break;
                }
            }

            if (canBookMeeting) {
                selectedMeetings.add(meeting);
                bookedAttendees.addAll(meeting);
            }
        }

        return selectedMeetings;
    }
}