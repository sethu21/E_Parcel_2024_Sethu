package service;

import model.*;
import model.Enum.City;
import model.Enum.ParcelSize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainService {
    private List<Driver> allDrivers = new ArrayList<>();
    private List<AbstractCustomer> allCustomers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.run();
    }

    
    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Create a new driver");
            System.out.println("2. Find driver by person code");
            System.out.println("3. Update driver's license number");
            System.out.println("4. Update driver's experience");
            System.out.println("5. Remove driver by person code");
            System.out.println("6. Retrieve all customers as company");
            System.out.println("7. Retrieve all customers as person");
            System.out.println("8. Create a new customer as person");
            System.out.println("9. Create a new customer as company");
            System.out.println("10. Create a new parcel for a customer");
            System.out.println("11. Retrieve all parcels by customer code");
            System.out.println("12. Retrieve all parcels by driver person code");
            System.out.println("13. Retrieve all parcels by city");
            System.out.println("14. Retrieve all parcels by size");
            System.out.println("15. Calculate price of all customer parcels");
            System.out.println("16. Retrieve statistics of customer parcels size");
            System.out.println("17. Sort drivers by experience");
            System.out.println("18. Calculate how many parcels today delivered to specific city");
            System.out.println("19. Generate customer as person and parcel");
            System.out.println("20. Generate customer as company and parcel");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    createNewDriver();
                    break;
                case 2:
                    findDriverByPersonCode();
                    break;
                case 3:
                    updateDriverLicenseNoByPersonCode();
                    break;
                case 4:
                    updateDriverExperienceByPersonCode();
                    break;
                case 5:
                    removeDriverByPersonCode();
                    break;
                case 6:
                    retrieveAllCustomersAsCompany();
                    break;
                case 7:
                    retrieveAllCustomersAsPerson();
                    break;
                case 8:
                    createNewCustomerAsPerson();
                    break;
                case 9:
                    createNewCustomerAsCompany();
                    break;
                case 10:
                    createNewParcelForCustomer();
                    break;
                case 11:
                    retrieveAllParcelsByCustomerCode();
                    break;
                case 12:
                    retrieveAllParcelsByDriverPersonCode();
                    break;
                case 13:
                    retrieveAllParcelsByCity();
                    break;
                case 14:
                    retrieveAllParcelsBySize();
                    break;
                case 15:
                    calculatePriceOfAllCustomerParcels();
                    break;
                case 16:
                    retrieveStatisticsOfCustomerParcelsSize();
                    break;
                case 17:
                    sortDriversByExperience();
                    break;
                case 18:
                    calculateHowManyParcelsTodayDeliveredToSpecificCity();
                    break;
                case 19:
                    generateCustomerAsPersonAndParcel();
                    break;
                case 20:
                    generateCustomerAsCompanyAndParcel();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Create a new driver
    public void createNewDriver() {
        boolean validInput = false;
        Driver driver = null;

        while (!validInput) {
            System.out.println("Enter driver details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Surname: ");
            String surname = scanner.nextLine();

            // Generate person code
            //Person person = new Person(name, surname); // Create a Person object with name and surname
            //String personCode = person.getPersonCode();
           // System.out.print(personCode);
            System.out.print("License number: ");
            String licenseNo = scanner.nextLine();
            System.out.print("Experience in years: ");
            float experienceInYears = scanner.nextFloat();
            scanner.nextLine(); 

            // Create the driver
            driver = new Driver(name, surname,  licenseNo, experienceInYears);

           
            if (driver.getName().isEmpty() || driver.getSurname().isEmpty() ||
                    driver.getLicenseNo().isEmpty() || driver.getExperienceInYears() <= 0) {
                System.out.println("Invalid input. Please re-enter driver details.");
            } else {
                validInput = true;
            }
        }

        // Add the driver to the list
        allDrivers.add(driver);

        // Display driver details
        System.out.println("Driver added successfully:");
        System.out.println(driver);
    }

    // Find driver by person code
    public void findDriverByPersonCode() {
        System.out.print("Enter driver's person code: ");
        String personCode = scanner.nextLine();
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                System.out.println("Driver found:");
                System.out.println(driver);
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Update driver's license number by person code
    public void updateDriverLicenseNoByPersonCode() {
        System.out.print("Enter driver's person code: ");
        String personCode = scanner.nextLine();
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                System.out.print("Enter new license number: ");
                String licenseNo = scanner.nextLine();
                driver.setLicenseNo(licenseNo);
                System.out.println("Driver's license number updated successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Update driver's experience by person code
    public void updateDriverExperienceByPersonCode() {
        System.out.print("Enter driver's person code: ");
        String personCode = scanner.nextLine();
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                System.out.print("Enter new experience in years: ");
                float experienceInYears = scanner.nextFloat();
                driver.setExperienceInYears(experienceInYears);
                System.out.println("Driver's experience updated successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Remove driver by person code
    public void removeDriverByPersonCode() {
        System.out.print("Enter driver's person code: ");
        String personCode = scanner.nextLine();
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                allDrivers.remove(driver);
                System.out.println("Driver removed successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Retrieve all customers as company
    public void retrieveAllCustomersAsCompany() {
        List<CustomerAsCompany> companyCustomers = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            if (customer instanceof CustomerAsCompany) {
                companyCustomers.add((CustomerAsCompany) customer);
            }
        }
        System.out.println("All customers as company:");
        for (CustomerAsCompany customer : companyCustomers) {
            System.out.println(customer);
        }
    }

    // Retrieve all customers as person
    public void retrieveAllCustomersAsPerson() {
        List<CustomerAsPerson> individualCustomers = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            if (customer instanceof CustomerAsPerson) {
                individualCustomers.add((CustomerAsPerson) customer);
            }
        }
        System.out.println("All customers as person:");
        for (CustomerAsPerson customer : individualCustomers) {
            System.out.println(customer);
        }
    }

    // Create a new customer as person
    public void createNewCustomerAsPerson() {
        System.out.println("Enter customer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Person code: ");
        String personCode = scanner.nextLine();
        System.out.print("Address (city): ");
        String city = scanner.nextLine();
        System.out.print("Address (street or house title): ");
        String streetOrHouseTitle = scanner.nextLine();
        System.out.print("Address (house number): ");
        int houseNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        Address address = new Address(City.valueOf(city.toUpperCase()), streetOrHouseTitle, houseNo);
        CustomerAsPerson customer = new CustomerAsPerson(name, surname, personCode, address, phone);
        allCustomers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Create a new customer as company
    public void createNewCustomerAsCompany() {
        System.out.println("Enter company customer details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Company registration number: ");
        String companyRegNo = scanner.nextLine();
        System.out.print("Address (city): ");
        String city = scanner.nextLine();
        System.out.print("Address (street or house title): ");
        String streetOrHouseTitle = scanner.nextLine();
        System.out.print("Address (house number): ");
        int houseNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        Address address = new Address(City.valueOf(city.toUpperCase()), streetOrHouseTitle, houseNo);
        CustomerAsCompany customer = new CustomerAsCompany(address, phone, title, companyRegNo);
        allCustomers.add(customer);
        System.out.println("Company customer added successfully!");
    }

    // Create a new parcel for a customer
    public void createNewParcelForCustomer() {
        System.out.print("Enter planned delivery date and time (YYYY-MM-DDTHH:MM): ");
        LocalDateTime plannedDelivery = LocalDateTime.parse(scanner.nextLine());

        System.out.print("Enter parcel size (X, S, M, L, XL): ");
        ParcelSize size;
        while (true) {
            try {
                size = ParcelSize.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid parcel size. Please enter again: ");
            }
        }

        System.out.print("Is the parcel fragile? (true/false): ");
        boolean isFragile = scanner.nextBoolean();
        scanner.nextLine(); 

        System.out.print("Enter driver's person code: ");
        String driverPersonCode = scanner.nextLine();

        System.out.print("Enter customer code: ");
        String customerCode = scanner.nextLine();

        // Find driver by person code
        Driver driver = null;
        for (Driver d : allDrivers) {
            if (d.getPersonCode().equals(driverPersonCode)) {
                driver = d;
                break;
            }
        }
        if (driver == null) {
            System.out.println("Driver not found with person code: " + driverPersonCode);
            return;
        }

        // Find customer by code
        AbstractCustomer customer = null;
        for (AbstractCustomer c : allCustomers) {
            if (c.getCustomerCode().equals(customerCode)) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }

        Parcel parcel = new Parcel(plannedDelivery, size, isFragile, driver);
        customer.addNewParcel(parcel);
        System.out.println("Parcel created successfully!");
    }

    // Retrieve all parcels by customer code
    public void retrieveAllParcelsByCustomerCode() {
        System.out.print("Enter customer code: ");
        String customerCode = scanner.nextLine();
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            if (customer.getCustomerCode().equals(customerCode)) {
                parcels.addAll(customer.getParcels());
            }
        }
        System.out.println("All parcels for customer with code " + customerCode + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by driver person code
    public void retrieveAllParcelsByDriverPersonCode() {
        System.out.print("Enter driver's person code: ");
        String personCode = scanner.nextLine();
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDriver().getPersonCode().equals(personCode)) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels for driver with person code " + personCode + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by city
    public void retrieveAllParcelsByCity() {
        System.out.print("Enter city: ");
        String cityName = scanner.nextLine();
        City city = City.valueOf(cityName.toUpperCase());
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDeliveryAddress().getCity() == city) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels for city " + cityName + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by size
    public void retrieveAllParcelsBySize() {
        System.out.print("Enter parcel size (X, S, M, L, XL): ");
        ParcelSize size = ParcelSize.valueOf(scanner.nextLine().toUpperCase());
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getSize() == size) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels of size " + size + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Calculate price of all customer parcels by customer code
    public void calculatePriceOfAllCustomerParcels() {
        System.out.print("Enter customer code: ");
        String customerCode = scanner.nextLine();
        float totalPrice = 0;
        for (AbstractCustomer customer : allCustomers) {
            if (customer.getCustomerCode().equals(customerCode)) {
                for (Parcel parcel : customer.getParcels()) {
                    totalPrice += parcel.getPrice();
                }
            }
        }
        System.out.println("Total price of all parcels for customer with code " + customerCode + ": $" + totalPrice);
    }

    // Retrieve statistics of customer parcels size by customer code
    public void retrieveStatisticsOfCustomerParcelsSize() {
        System.out.print("Enter customer code: ");
        String customerCode = scanner.nextLine();
        int[] sizeCounts = new int[5]; // Array to store counts for each size (X, S, M, L, XL)
        for (AbstractCustomer customer : allCustomers) {
            if (customer.getCustomerCode().equals(customerCode)) {
                for (Parcel parcel : customer.getParcels()) {
                    switch (parcel.getSize()) {
                        case X:
                            sizeCounts[0]++;
                            break;
                        case S:
                            sizeCounts[1]++;
                            break;
                        case M:
                            sizeCounts[2]++;
                            break;
                        case L:
                            sizeCounts[3]++;
                            break;
                        case XL:
                            sizeCounts[4]++;
                            break;
                    }
                }
            }
        }
        System.out.println("Statistics of parcels size for customer with code " + customerCode + ":");
        System.out.println("X: " + sizeCounts[0] + ", S: " + sizeCounts[1] + ", M: " + sizeCounts[2] +
                ", L: " + sizeCounts[3] + ", XL: " + sizeCounts[4]);
    }

    // Sort drivers by experience
    public void sortDriversByExperience() {
        allDrivers.sort((d1, d2) -> Float.compare(d1.getExperienceInYears(), d2.getExperienceInYears()));
        System.out.println("Drivers sorted by experience:");
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }

    // Calculate how many parcels today delivered to specific city
    public void calculateHowManyParcelsTodayDeliveredToSpecificCity() {
        System.out.print("Enter city: ");
        String cityName = scanner.nextLine();
        City city = City.valueOf(cityName.toUpperCase());
        int count = 0;
        LocalDateTime today = LocalDateTime.now();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDeliveryAddress().getCity() == city &&
                        parcel.getPlannedDelivery().toLocalDate().isEqual(today.toLocalDate())) {
                    count++;
                }
            }
        }
        System.out.println("Number of parcels delivered today to city " + cityName + ": " + count);
    }

    // Generate customer as person and parcel
    public void generateCustomerAsPersonAndParcel() {
        // Implement generation of random customer and parcel
        System.out.println("Generating customer as person and parcel...");
    }

    // Generate customer as company and parcel
    public void generateCustomerAsCompanyAndParcel() {
        // Implement generation of random company customer and parcel
        System.out.println("Generating customer as company and parcel...");
    }
}

