package omnia.task.one.objects;

/**
 * Created by lollipop on 26.06.2017.
 */
public class Source {
    private String id;
    private String title;
    private int allowed;

    public Source(String id, String title, int allowed) {
        this.id = id;
        this.title = title;
        this.allowed = allowed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAllowed() {
        return allowed;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", allowed=" + allowed +
                '}';
    }
}
