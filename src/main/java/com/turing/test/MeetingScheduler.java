package com.turing.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>Description of the file</h1>
 * <p></p>
 *
 * @author : Asaduzzaman Noor
 * @version : 2.0
 * @since : Tuesday, 04 April 2023 23:23
 */

public class MeetingScheduler {

    private List<List<Integer>> meetings;

    public MeetingScheduler(List<List<Integer>> meetings) {
        this.meetings = meetings;
    }

    public MeetingSubset getMaxAttendeesSubset() {
        int maxAttendees = 0;
        Set<Integer> allAttendees = new HashSet<>();
        for (List<Integer> meeting : meetings) {
            allAttendees.addAll(meeting);
            maxAttendees = Math.max(maxAttendees, meeting.size());
        }

        MeetingSubset maxSubset = new MeetingSubset(new HashSet<>() {{
            add(meetings.get(0));
        }}, maxAttendees);

        for (int i = 0; i < meetings.size(); i++) {
            List<Integer> currentMeeting = meetings.get(i);
            HashSet<List<Integer>> remainingSubsets = new HashSet<>(maxSubset.getMeetings());
            remainingSubsets.add(currentMeeting);
            int currentAttendees = allAttendees.size();
            for (int j = i + 1; j < meetings.size(); j++) {
                List<Integer> nextMeeting = meetings.get(j);
                if (!Collections.disjoint(currentMeeting, nextMeeting)) {
                    remainingSubsets.add(nextMeeting);
                    currentAttendees += nextMeeting.size() - currentMeeting.size();
                }
            }
            MeetingSubset currentSubset = new MeetingSubset(remainingSubsets, currentAttendees);
            if (currentSubset.getAttendees() > maxSubset.getAttendees()) {
                maxSubset = currentSubset;
            }
        }
        return maxSubset;
    }
}