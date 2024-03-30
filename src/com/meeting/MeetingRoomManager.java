package com.meeting;

import java.util.*;
import java.util.stream.Collectors;

public class MeetingRoomManager {
    List<MeetingRoom> meetingRooms = new ArrayList<>();

    Map<MeetingRoom, MeetingRoomCalender> meetingRoomCalenderMap =
            new HashMap<>();

    //CRUD for meeting rooms

    public void createMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
        meetingRooms.forEach(room -> meetingRoomCalenderMap.put(room, room.meetingRoomCalender()));
    }

    public void deleteMeetingRoom(int id) throws MeetingRoomException {
        MeetingRoom room = meetingRooms.stream()
                .filter(meetingRoom -> meetingRoom.id() == id)
                .findFirst().orElseThrow(() -> new MeetingRoomException("Meeting " +
                        "room with id " + id + "not found"));
        meetingRooms.remove(room);
    }


    public Map<MeetingRoom, MeetingRoomCalender> getMeetingRoomCalenderMap() {
        return meetingRoomCalenderMap;
    }

    public List<MeetingRoom> getAvailableMeetingRooms(int capacity) {
        return meetingRooms.stream().filter(meetingRoom -> meetingRoom.capacity() >= capacity).collect(Collectors.toList());
    }

    public Optional<MeetingRoom> getSingleAvailableMeetingRoom(List<MeetingRoom> avilableMeetingRooms, Slot inputSlot) {
        return avilableMeetingRooms.stream().filter(meetingRoom -> !meetingRoomCalenderMap.get(meetingRoom).getBookedSlots().contains(inputSlot)).findFirst();
    }

    public void bookMeetingRoom(MeetingRoom meetingRoom, Slot inputSlot) {
        meetingRoomCalenderMap.get(meetingRoom).getBookedSlots().add(inputSlot);
    }

    public void book(int capacity, Slot inputSlot) {
        Optional<MeetingRoom> meetingRoomOptional =
                this.getSingleAvailableMeetingRoom(this.getAvailableMeetingRooms(capacity), inputSlot);
        if(meetingRoomOptional.isPresent()) {
            System.out.println("Meeting room with id " + meetingRoomOptional.get().id() +
                    " booked for slot: " + inputSlot);
            this.bookMeetingRoom(meetingRoomOptional.get(), inputSlot);
        } else {
            System.out.println("No meeting room is avilable for the given " +
                    "capaciy " + capacity + "and slot "+ inputSlot);
        }
    }
}
