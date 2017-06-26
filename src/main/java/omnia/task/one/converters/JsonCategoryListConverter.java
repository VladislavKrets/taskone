package omnia.task.one.converters;

import com.google.gson.*;
import omnia.task.one.objects.Category;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class JsonCategoryListConverter implements JsonDeserializer<List<Category>>{
    @Override
    public List<Category> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray categoryArray = jsonElement.getAsJsonObject().getAsJsonArray("categories");
        List<Category> categories = new ArrayList<>();
        for (JsonElement categoryElement : categoryArray) {
            categories.add(new Category(
                    categoryElement.getAsJsonObject().get("id").getAsString().trim(),
                    categoryElement.getAsJsonObject().get("title").getAsString().trim()
            ));
        }
        return categories;
    }
}
