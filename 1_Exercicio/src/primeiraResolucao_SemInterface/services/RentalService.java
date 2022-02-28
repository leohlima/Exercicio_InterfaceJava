package primeiraResolucao_SemInterface.services;

import primeiraResolucao_SemInterface.entities.CarRental;
import primeiraResolucao_SemInterface.entities.Invoice;

public class RentalService {
    private Double pricePerday;
    private Double pricePerHour;
    private BrasilTaxService taxService;

    public RentalService(Double pricePerday, Double pricePerHour, BrasilTaxService taxService) {
        this.pricePerday = pricePerday;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double)(t2 - t1) / 1000 / 60 / 60;

        double basicPayment;
        if (hours <= 12.0){
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerday;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
