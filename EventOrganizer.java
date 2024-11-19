import java.util.ArrayList;

public class EventOrganizer {
    private ArrayList<Event> events = new ArrayList<>();

    public Event[] getEvents() {
        Event[] events = {};
        return this.events.toArray(events);
    }

    public void createEvent(Event event) {
        this.events.add(event);
    }

    public Participant[] getParticipantsByEventIndex(int index) {
        Participant[] participants = {};
        return this.events.get(index).participants.toArray(participants);
    }

    public void createParticipantByEventIndex(int index, Participant participant) {
        this.events.get(index).participants.add(participant);
    }
}
