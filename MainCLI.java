import java.util.Scanner;

public class MainCLI {
    Scanner scan = new Scanner(System.in);
    EventOrganizer eventOrganizer = new EventOrganizer();

    public void printEventList() {
        System.out.println("Daftar Event ");
        Event[] events = eventOrganizer.getEvents();
        for (int i = 0; i < events.length; i++) {
            Event event = events[i];
            System.out.printf("%d. %s | %s \n", i + 1, event.title, event.startDate);
        }
    }

    public void createEvent() {
        System.out.println("Tambah Event");

        System.out.print("Masukkan Nama Event : ");
        String title = scan.nextLine();

        System.out.print("Masukkan Tanggal Event : ");
        String startDate = scan.nextLine();

        Event event = new Event(title, startDate);
        eventOrganizer.createEvent(event);
    }

    public void printParticipants() {
        this.printEventList();

        System.out.print("Pilih Event : ");
        int eventIndex = scan.nextInt() - 1;

        System.out.println("Daftar Peserta ");
        Participant[] participants = eventOrganizer.getParticipantsByEventIndex(eventIndex);
        for (int i = 0; i < participants.length; i++) {
            Participant participant = participants[i];
            System.out.printf("%d. %s | %s \n", i + 1, participant.name, participant.email);
        }
    }

    public void createParticipant() {
        this.printEventList();

        System.out.print("Pilih Event : ");
        int eventIndex = scan.nextInt() - 1;
        scan.nextLine();

        System.out.println("Tambah Peserta ");
        System.out.print("Masukkan Nama Peserta : ");
        String name = scan.nextLine();

        System.out.print("Masukkan Email Peserta : ");
        String email = scan.nextLine();

        Participant participant = new Participant(name, email);
        eventOrganizer.createParticipantByEventIndex(eventIndex, participant);
    }

    public void main() {

        System.out.println("Program Event Organizer : ");

        while (true) {
            System.out.println("Daftar Aksi : \n" +
                    "1. Lihat Daftar Event\n" +
                    "2. Tambah Event\n" +
                    "3. Lihat Daftar Peserta\t\n" +
                    "4. Tambah Peserta\n" +
                    "5. Keluar");

            System.out.print("Pilih Aksi : ");
            int action = scan.nextInt();
            scan.nextLine();

            if (action == 1) {
                this.printEventList();
            } else if (action == 2) {
                this.createEvent();
            } else if (action == 3) {
                this.printParticipants();
            } else if (action == 4) {
                this.createParticipant();
            } else if (action == 5) {
                System.out.println("Terimakasih");
                break;
            } else {
                System.out.println("Input Tidak Valid");
            }

            System.out.println("=========================================");
        }

    }
}
