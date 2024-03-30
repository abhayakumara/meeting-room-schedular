package com.meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomCalender {
    private final List<Slot> bookedSlots;

    public MeetingRoomCalender() {
        this.bookedSlots = new ArrayList<>();
    }

    public List<Slot> getBookedSlots() {
        return bookedSlots;
    }
}
