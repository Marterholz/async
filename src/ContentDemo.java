import java.util.ArrayList;
import java.time.Year;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();
        int currentYear = Year.now().getValue();

        try {
            items.add(new VideoLecture("Java Core", 2024, 60, "1080p"));
            items.add(new VideoLecture("Legacy Java", 2015, 90, "1440p"));
            items.add(new PodcastEpisode("Tech Weekly", 2025, 45, "Dev Team"));
            items.add(new PodcastEpisode("Interview #1", 2023, 30, "Alice"));

            for (ContentItem item : items) {
                System.out.println(item.toString() + " | License Cost: " + item.getLicenseCost(currentYear));
                
                if (item instanceof Downloadable) {
                    Downloadable d = (Downloadable) item;
                    d.download();
                    System.out.println("Max downloads: " + d.getMaxDownloadsPerDay());
                }
                System.out.println("-------------------------------------------------");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}