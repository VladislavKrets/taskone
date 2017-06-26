package omnia.task.one.objects;

import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class Offer {
    private int id;
    private String offer_id;
    private String title;
    private String preview_url;
    private String description;
    private List<String> sources;

    public Offer(int id, String offer_id, String title, String preview_url, String description, List<String> sources) {
        this.id = id;
        this.offer_id = offer_id;
        this.title = title;
        this.preview_url = preview_url;
        this.description = description;
        this.sources = sources;
    }

    public List<String> getSources() {
        return sources;
    }

    public int getId() {
        return id;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public String getTitle() {
        return title;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", offer_id='" + offer_id + '\'' +
                ", title='" + title + '\'' +
                ", preview_url='" + preview_url + '\'' +
                ", description='" + description + '\'' +
                ", sources=" + sources +
                '}';
    }
}
