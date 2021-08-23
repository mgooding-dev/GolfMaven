package golferModel;

public class Golfer {

    private int golferId;
    private String golferFirstName;
    private String golferLastName;
    private String handedness;
    private int teeBoxChoice;
    private String gender;
    private boolean hasHandicap;


    //  Constructor
    public Golfer() {}

    public Golfer(int golferId, String golferFirstName, String golferLastName,
                  String handedness, String gender, boolean hasHandicap) {
        this.golferId = golferId;
        this.golferFirstName = golferFirstName;
        this.golferLastName = golferLastName;
        this.handedness = handedness;
        this.gender = gender;
        this.hasHandicap = hasHandicap;
    }

    // Getters and Setters


    public String getGolferFirstName() {
        return golferFirstName;
    }

    public void setGolferId(int golferId) { this.golferId = golferId; }

    public int getGolferId() { return golferId; }

    public void setGolferFirstName(String golferFirstName) {
        this.golferFirstName = golferFirstName;
    }

    public String getGolferLastName() {
        return golferLastName;
    }

    public void setGolferLastName(String golferLastName) {
        this.golferLastName = golferLastName;
    }

    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public void setHasHandicap(boolean hasHandicap) {
        this.hasHandicap = hasHandicap;
    }

    public boolean isHasHandicap() {
        return hasHandicap;
    }

    @Override
    public String toString() {
        return "Golfer{" +
                "golferId=" + golferId +
                ", golferFirstName='" + golferFirstName + '\'' +
                ", golferLastName='" + golferLastName + '\'' +
                ", handedness='" + handedness + '\'' +
                ", teeBoxChoice=" + teeBoxChoice +
                ", gender='" + gender + '\'' +
                ", hasHandicap=" + hasHandicap +
                '}';
    }
}
