package com.meeting;

public class Main {
    public static void main(String[] args) {
        User user = new User(getId(), "Abhay", "Athenahealth");

        //Create meeting rooms
        MeetingRoomManager meetingRoomManager = new MeetingRoomManager();

        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 5, new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 10,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 6,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 3,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 7,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 8,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 9,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 4,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 5, new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 5, new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 8,
                new MeetingRoomCalender()));
        meetingRoomManager.createMeetingRoom(new MeetingRoom(getId(), 6,
                new MeetingRoomCalender()));

        meetingRoomManager.book(10, new Slot(1, 2));
        meetingRoomManager.book(10, new Slot(1, 2));
    }

    private static int getId() {
        return IdGeneration.getInstance().getUniqueId();
    }
}