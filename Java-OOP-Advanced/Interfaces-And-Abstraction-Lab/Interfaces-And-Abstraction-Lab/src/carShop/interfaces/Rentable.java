package carShop.interfaces;

public interface Rentable extends Car{
    Integer getMinRentDay();
    Double  getPricePerDay();
}
