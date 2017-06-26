package omnia.task.one;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import omnia.task.one.converters.JsonOfferConverter;
import omnia.task.one.converters.JsonStringArrayConverter;
import omnia.task.one.objects.Offer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class Connection {

    public List<Offer> getOffers() throws IOException {
        String answer = HttpMethods.methodGet("offers");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(List.class, new JsonStringArrayConverter());
        builder.registerTypeAdapter(Offer.class, new JsonOfferConverter());
        Gson gson = builder.create();
        List<String> jsonLines = gson.fromJson(answer, List.class);
        List<Offer> offerList = new ArrayList<Offer>();
        for (String jsonLine : jsonLines) {
            offerList.add(gson.fromJson(jsonLine, Offer.class));
        }
        return offerList;
    }
}
