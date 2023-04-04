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
 * @since : Wednesday, 05 April 2023 00:27
 */
public class EventPacking {

    /**
     * Given a list of meetings, each of which has a list of attendees, select a subset
     * of those meetings which:
     * 1. Must not double book any attendee
     * 2. Maximizes the total number of attendees across the subset
     *
     * @param meetings List of meetings, where each meeting is represented as an array of attendees.
     * @return A list of meetings that does not double book any attendee and has the maximum number of attendees.
     */
    public static List<List<Integer>> packEvents(List<List<Integer>> meetings) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> attendees = new HashSet<>();
        packEventsHelper(meetings, 0, attendees, result);
        return result;
    }

    /**
     * A recursive helper function that tries all possible combinations of meetings to maximize the total number of attendees.
     *
     * @param meetings  List of meetings, where each meeting is represented as an array of attendees.
     * @param index     Current index of the meeting being considered.
     * @param attendees Set of attendees who have already been assigned to a meeting in the result.
     * @param result    A list of meetings that does not double book any attendee and has the maximum number of attendees.
     */
    private static void packEventsHelper(List<List<Integer>> meetings, int index, Set<Integer> attendees, List<List<Integer>> result) {
        // Base case: all meetings have been considered.
        if (index >= meetings.size()) {
            // Check if this combination of meetings has more attendees than the current best result.
            if (attendees.size() > getAttendees(result).size()) {
                result.clear();
                for (List<Integer> meeting : meetings) {
                    if (hasNoDoubleBookings(meeting, result)) {
                        result.add(meeting);
                    }
                }
            }
            return;
        }

        // Recursive case 1: exclude the current meeting from the result.
        packEventsHelper(meetings, index + 1, attendees, result);

        // Recursive case 2: include the current meeting in the result.
        List<Integer> currentMeeting = meetings.get(index);
        if (hasNoDoubleBookings(currentMeeting, result)) {
            attendees.addAll(currentMeeting);
            result.add(currentMeeting);
            packEventsHelper(meetings, index + 1, attendees, result);
            result.remove(result.size() - 1);
            attendees.removeAll(currentMeeting);
        }
    }

    /**
     * Checks if a meeting can be added to the result without double booking any attendee.
     *
     * @param meeting Meeting to be checked.
     * @param result  Current result of meetings.
     * @return True if the meeting can be added to the result without double booking any attendee, false otherwise.
     */
    private static boolean hasNoDoubleBookings(List<Integer> meeting, List<List<Integer>> result) {
        for (List<Integer> otherMeeting : result) {
            Set<Integer> intersection = new HashSet<>(meeting);
            intersection.retainAll(otherMeeting);
            if (!intersection.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Computes the set of all attendees in the list of meetings.
     *
     * @param meetings List of meetings.
     * @return Set of all attendees in the meetings.
     */
    public static Set<Integer> getAttendees(List<List<Integer>> meetings) {
        Set<Integer> attendees = new HashSet<>();
        for (List<Integer> meeting : meetings) {
            attendees.addAll(meeting);
        }
        return attendees;
    }
}