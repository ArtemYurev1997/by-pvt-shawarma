package by.pvt.shawarma.api.enums;

public enum Status {
    UNFORMED("Не оформлен"),
    WAITING("Ожидает подтверждения"),
    ON_THE_WAY("В пути"),
    DONE("Оформлен"),
    PAY("Оплачен"),
    NO_PAY("Не оплачен");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
