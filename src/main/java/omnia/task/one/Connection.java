package omnia.task.one;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import omnia.task.one.converters.JsonCategoryListConverter;
import omnia.task.one.converters.JsonOfferConverter;
import omnia.task.one.converters.JsonStringArrayConverter;
import omnia.task.one.converters.JsonStringOfferConverter;
import omnia.task.one.objects.Category;
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
        List<String> jsonOffersLines = gson.fromJson(answer, List.class);
        List<Offer> offerList = new ArrayList<Offer>();
        for (String jsonLine : jsonOffersLines) {
            offerList.add(gson.fromJson(jsonLine, Offer.class));
        }
        return offerList;
    }

    public Offer getOfferById(String id) throws IOException {
        String answer = HttpMethods.methodGet("offer/" + id);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new JsonStringOfferConverter());
        builder.registerTypeAdapter(Offer.class, new JsonOfferConverter());
        Gson gson = builder.create();
        String jsonOfferLine = gson.fromJson(answer, String.class);
        Offer offer = gson.fromJson(jsonOfferLine, Offer.class);
        return offer;
    }

    public List<Category> getCategories() throws IOException {
        String answer = HttpMethods.methodGet("offer/categories");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(List.class, new JsonCategoryListConverter());
        Gson gson = builder.create();
        List<Category> categories = gson.fromJson(answer, List.class);
        return categories;
    }
}
