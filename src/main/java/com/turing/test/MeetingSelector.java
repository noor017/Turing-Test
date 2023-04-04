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
 * @since : Wednesday, 05 April 2023 00:07
 */
public class MeetingSelector {
    public static class Meeting {
        private final List<Integer> attendees;

        public Meeting(List<Integer> attendees) {
            this.attendees = attendees;
        }

        public List<Integer> getAttendees() {
            return attendees;
        }
    }

    public static class MeetingSelection {
        private final List<Meeting> meetings;
        private final int attendeeCount;

        public MeetingSelection(List<Meeting> meetings, int attendeeCount) {
            this.meetings = meetings;
            this.attendeeCount = attendeeCount;
        }

        public List<Meeting> getMeetings() {
            return meetings;
        }

        public int getAttendeeCount() {
            return attendeeCount;
        }
    }

    public static MeetingSelection selectMeetings(List<Meeting> meetings) {
        Set<Integer> attendees = new HashSet<>();
        List<Meeting> selectedMeetings = new ArrayList<>();

        for (Meeting meeting : meetings) {
            if (meetingAttendeesOverlap(meeting, attendees)) {
                continue;
            }

            selectedMeetings.add(meeting);
            attendees.addAll(meeting.getAttendees());
        }

        return new MeetingSelection(selectedMeetings, attendees.size());
    }

    private static boolean meetingAttendeesOverlap(Meeting meeting, Set<Integer> attendees) {
        for (Integer attendee : meeting.getAttendees()) {
            if (attendees.contains(attendee)) {
                return true;
            }
        }

        return false;
    }
}