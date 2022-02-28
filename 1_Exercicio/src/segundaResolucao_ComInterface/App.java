package segundaResolucao_ComInterface;

import segundaResolucao_ComInterface.entities.CarRental;
import segundaResolucao_ComInterface.entities.Vehicle;
import segundaResolucao_ComInterface.services.BrasilTaxService;
import segundaResolucao_ComInterface.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        Date finish = sdf.parse(sc.nextLine());
        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrasilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Invoice");
        System.out.print("Basic Payment: " + cr.getInvoice().getBasicPayment() + "\n");
        System.out.print("Tax: " + cr.getInvoice().getTax() + "\n");
        System.out.print("Total Payment: " + cr.getInvoice().getTotalPayment() + "\n");

        sc.close();

    }
}
