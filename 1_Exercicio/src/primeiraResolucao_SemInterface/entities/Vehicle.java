package primeiraResolucao_SemInterface.entities;

public class Vehicle {
    private String carModel;

    public Vehicle() {
    }

    public Vehicle(String name) {
        this.carModel = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
