package omnia.task.one.objects;

import java.util.List;

/**
 * Created by lollipop on 27.06.2017.
 */
public class PartnerPayment {
    private List<String> countries;
    private List<String> devices;

    public PartnerPayment(List<String> countries, List<String> devices) {
        this.countries = countries;
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "PartnerPayment{" +
                "countries=" + countries +
                ", devices=" + devices +
                '}';
    }
}
