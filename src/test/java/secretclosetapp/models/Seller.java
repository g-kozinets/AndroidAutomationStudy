package secretclosetapp.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Seller {

    private String name;
    private String city;

    public Seller (String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(name, seller.name) && Objects.equals(city, seller.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
