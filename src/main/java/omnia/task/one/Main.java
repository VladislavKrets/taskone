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
        List<Offer> offers = connection.getOffers();
        for (Offer offer : offers) {
            System.out.println(offer.getPartnerPayments());
        }
        /*List<Offer> offerList = connection.getOffers();
        for (Offer offer : offerList) {
            System.out.println(offer.getId());
        }*/
        /*Offer offer = connection.getOfferById("220");
        System.out.println(offer.getTitle());*/
    }
}
