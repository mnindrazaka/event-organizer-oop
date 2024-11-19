import java.util.ArrayList;

public class Event {
    public String title;
    public String startDate;
    public ArrayList<Participant> participants = new ArrayList<>();

    public Event(String title, String startDate) {
        this.title = title;
        this.startDate = startDate;
    }
}
