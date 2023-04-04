package com.turing.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Tuesday, 04 April 2023 23:34
 */
public class MeetingSubset {

    private HashSet<List<Integer>> meetings;
    private int attendees;

    public MeetingSubset(HashSet<List<Integer>> meetings, int attendees) {
        this.meetings = meetings;
        this.attendees = attendees;
    }

    public Set<List<Integer>> getMeetings() {
        return meetings;
    }

    public int getAttendees() {
        return attendees;
    }
}
