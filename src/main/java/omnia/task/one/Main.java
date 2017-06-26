package omnia.task.one;

import omnia.task.one.objects.Offer;

import java.io.IOException;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Connection connection = new Connection();
        List<Offer> offerList = connection.getOffers();
        for (Offer offer : offerList) {
            System.out.println(offer.getTitle());
        }
    }
}
