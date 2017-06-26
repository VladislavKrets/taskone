package omnia.task.one.converters;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by lollipop on 26.06.2017.
 */
public class JsonStringOfferConverter implements JsonDeserializer<String>{
    @Override
    public String deserialize(JsonElement jsonElement, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return jsonElement.getAsJsonObject().get("offer").toString();
    }
}
