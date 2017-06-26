package omnia.task.one.converters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class JsonStringArrayConverter implements JsonDeserializer<List<String>>{
    public List<String> deserialize(JsonElement jsonElement, Type type,
                                    JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray array = jsonElement.getAsJsonObject().getAsJsonArray("offers");
        List<String> offerList = new ArrayList<String>();
        for (JsonElement element : array) {
            offerList.add(element.toString());
        }
        return offerList;
    }
}
