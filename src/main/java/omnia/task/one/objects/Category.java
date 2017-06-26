package omnia.task.one.objects;

/**
 * Created by lollipop on 26.06.2017.
 */
public class Category {
    private String id;
    private String title;

    public Category(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
