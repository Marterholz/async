import java.time.Year;

public abstract class ContentItem {
    private int id;
    private static int idGen = 1000;
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }

    public int getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null/blank");
        }
        this.title = title;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1990 || year > currentYear) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be > 0");
        }
        this.durationMinutes = durationMinutes;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ID: " + id + " | " + title + " (" + year + ") | " + durationMinutes + " min";
    }
}