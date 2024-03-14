package Misc;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class HashcodeEquals {
    String concern;
    String model;
    int productionYear;
    public HashcodeEquals(){};
     HashcodeEquals(String concern, String model, int productionYear) {
        this.concern = concern;
        this.model = model;
        this.productionYear = productionYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashcodeEquals that = (HashcodeEquals) o; //casting from Object type to HashcodeEquals class
        return productionYear == that.productionYear && Objects.equals(concern, that.concern) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concern, model, productionYear);
    }

    @Test
    public void shouldBeEqualIfAllValuesAreTheSame() {
        HashcodeEquals car1 = new HashcodeEquals("Toyota", "Prius", 2023);
        HashcodeEquals car2 = new HashcodeEquals("Toyota", "Prius", 2022);
        assertEquals(car1, car2);
    }
public static void main(String []args) {
        HashcodeEquals   hashcodeEquals=new HashcodeEquals();
        hashcodeEquals.shouldBeEqualIfAllValuesAreTheSame();
        System.out.println("shouldBeEqualIfAllValuesAreTheSame");
}
}
