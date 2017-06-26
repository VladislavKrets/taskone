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
    @Override
    public Offer deserialize(JsonElement jsonElement, Type type,
                             JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject offerObject = jsonElement.getAsJsonObject();
        List<String> sources = new ArrayList<String>();
        JsonArray sourceArray = offerObject.getAsJsonObject().getAsJsonArray("sources");


        for (JsonElement sourceElement : sourceArray) {

            sources.add(sourceElement.getAsString());
        }
        Offer offer = new Offer(
                offerObject.getAsJsonObject().get("id").getAsInt(),
                offerObject.getAsJsonObject().get("offer_id").getAsString(),
                offerObject.getAsJsonObject().get("title").getAsString(),
                offerObject.getAsJsonObject().get("preview_url").getAsString(),
                offerObject.getAsJsonObject().get("description").getAsString(),
                sources
        );
        return offer;
    }
}
