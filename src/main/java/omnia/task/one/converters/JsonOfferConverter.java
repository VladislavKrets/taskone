package omnia.task.one.converters;

import com.google.gson.*;
import omnia.task.one.objects.Offer;
import omnia.task.one.objects.PartnerPayment;
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
        List<PartnerPayment> partnerPayments = new ArrayList<>();


        JsonArray sourceArray = offerObject.getAsJsonObject().getAsJsonArray("sources");
        JsonArray partnerPaymentsArray = offerObject.getAsJsonObject().getAsJsonArray("partner_payments");

        if (partnerPaymentsArray != null) {
            List<String> countries = new ArrayList<>();
            List<String> devices = new ArrayList<>();
            JsonArray countriesArray;
            JsonArray devicesArray;
            for (JsonElement partnerElement : partnerPaymentsArray) {
                countriesArray = partnerElement.getAsJsonObject().getAsJsonArray("countries");
                if (countriesArray != null) {
                    for (JsonElement countriesElement : countriesArray) {
                        countries.add(countriesElement.getAsString());
                    }
                }
                devicesArray = partnerElement.getAsJsonObject().getAsJsonArray("devices");
                if (devicesArray != null) {
                    for (JsonElement deviceElement : devicesArray) {
                        devices.add(deviceElement.getAsString());
                    }
                }
                partnerPayments.add(new PartnerPayment(countries, devices));
            }
        }
        for (JsonElement sourceElement : sourceArray) {
            sources.add(sourceElement.getAsString());
        }
        Offer offer = new Offer(
                offerObject.getAsJsonObject().get("id").getAsInt(),
                offerObject.getAsJsonObject().get("offer_id").getAsString(),
                offerObject.getAsJsonObject().get("title").getAsString(),
                offerObject.getAsJsonObject().get("preview_url").getAsString(),
                offerObject.getAsJsonObject().get("description").getAsString(),
                sources,
                partnerPayments
        );
        return offer;
    }
}
