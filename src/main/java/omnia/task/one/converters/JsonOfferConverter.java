package omnia.task.one.converters;

import com.google.gson.*;
import omnia.task.one.objects.Offer;
import omnia.task.one.objects.Source;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class JsonOfferConverter implements JsonDeserializer<Offer> {
    public Offer deserialize(JsonElement jsonElement, Type type,
                             JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        List<Source> sources = new ArrayList<Source>();
        JsonArray sourceArray = object.getAsJsonObject().getAsJsonArray("sources");

        Source source;
        for (JsonElement sourceElement : sourceArray) {
            source = new Source(
                    sourceElement.getAsJsonObject().get("id").getAsString(),
                    sourceElement.getAsJsonObject().get("title").getAsString(),
                    sourceElement.getAsJsonObject().get("allowed").getAsInt()
            );
            sources.add(source);
        }
        Offer offer = new Offer(
                object.getAsJsonObject().get("id").getAsInt(),
                object.getAsJsonObject().get("offer_id").getAsString(),
                object.getAsJsonObject().get("title").getAsString(),
                object.getAsJsonObject().get("preview_url").getAsString(),
                object.getAsJsonObject().get("description").getAsString(),
                sources
        );
        return offer;
    }
}
