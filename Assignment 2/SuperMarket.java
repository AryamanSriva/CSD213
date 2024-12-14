import java.util.ArrayList;
import java.util.Scanner;
// In the output perishable and non-perishable items are coming alternatively
class Item {
    private String name;
    private double pricePerUnit;

    public Item(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}

class NonPerishable extends Item {
    private double volume;
    private double price;

    public NonPerishable(String name, double pricePerUnit, double volume) {
        super(name);
        this.price = pricePerUnit;
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public double getPricePerUnit() {
        return price;
    }
}

class Perishable extends Item {
    private double weight;
    private double price;

    public Perishable(String name, double pricePerUnit, double weight) {
        super(name);
        this.price = pricePerUnit;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getPricePerUnit() {
        return price;
    }
}

class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addPerishables(Perishable item) {
        items.add(item);
    }

    public void addNonPerishables(NonPerishable item) {
        items.add(item);
    }

    public ArrayList<Perishable> getPerishableItems() {
        ArrayList<Perishable> perishableItems = new ArrayList<>();
        for (Item product : items) {
            if (product instanceof Perishable) {
                perishableItems.add((Perishable) product);
            }
        }
        return perishableItems;
    }

    public ArrayList<NonPerishable> getNonPerishableItems() {
        ArrayList<NonPerishable> nonPerishableItems = new ArrayList<>();
        for (Item product : items) {
            if (product instanceof NonPerishable) {
                nonPerishableItems.add((NonPerishable) product);
            }
        }
        return nonPerishableItems;
    }
}

class Biller {
    public double calculateTotalCost(ArrayList<Perishable> perishables, ArrayList<NonPerishable> nonPerishables) {
        double cost = 0;
        for (Perishable product : perishables) {
            cost += product.getWeight() * product.getPricePerUnit();
        }
        for (NonPerishable product : nonPerishables) {
            cost += product.getVolume() * product.getPricePerUnit();
        }
        return cost;
    }

    public void printBill(ArrayList<Perishable> perishables, ArrayList<NonPerishable> nonPerishables, double shippingCost, double totalCost) {
        for (Perishable product : perishables) {
            System.out.println(product.getName() + "  " + product.getWeight() + "  " + product.getWeight() * product.getPricePerUnit());
        }
        for (NonPerishable product : nonPerishables) {
            System.out.println(product.getName() + "  " + product.getVolume() + "  " + product.getVolume() * product.getPricePerUnit());
        }
        System.out.println("Shipping " + shippingCost);
        System.out.println("Total " + totalCost);
    }
}

class Packer {
    public double shippingCost(ArrayList<Perishable> perishables, ArrayList<NonPerishable> nonPerishables) {
        double totalWeightOfPerishables = 0;
        double totalVolumeOfNonPerishables = 0;
        double cost = 0;

        for (Perishable perishable : perishables) {
            totalWeightOfPerishables += perishable.getWeight();
        }

        for (NonPerishable nonPerishable : nonPerishables) {
            totalVolumeOfNonPerishables += nonPerishable.getVolume();
        }

        if (totalWeightOfPerishables > 5) {
            cost += (totalWeightOfPerishables - 5) * 5;
        }

        if (totalVolumeOfNonPerishables > 4) {
            cost += (totalVolumeOfNonPerishables - 4) * 2;
        }

        return cost;
    }
}

public class prog1 {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Biller biller = new Biller();
        Packer packer = new Packer();
        ArrayList<Item> availableItems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Read available items and their prices
        while (true) {
            String name = sc.next();
            if (name.equalsIgnoreCase("end")) {
                break;
            }
            double price = sc.nextDouble();
            availableItems.add(new Item(name, price));
        }

        // Add items to the cart and calculate costs
        while (true) {
            String name = sc.next();
            if (name.equalsIgnoreCase("checkout")) {
                break;
            }

            double price = 0;
            for (Item product : availableItems) {
                if (product.getName().equalsIgnoreCase(name)) {
                    price = product.getPricePerUnit();
                }
            }

            double weight = sc.nextDouble();
            cart.addPerishables(new Perishable(name, price, weight));

            String name2 = sc.next();
            if (name2.equalsIgnoreCase("checkout")) {
                break;
            }

            double price2 = 0;
            for (Item product : availableItems) {
                if (product.getName().equalsIgnoreCase(name2)) {
                    price2 = product.getPricePerUnit();
                }
            }

            double volume = sc.nextDouble();
            cart.addNonPerishables(new NonPerishable(name2, price2, volume));
        }

        double shippingCost = packer.shippingCost(cart.getPerishableItems(), cart.getNonPerishableItems());
        double totalCost = biller.calculateTotalCost(cart.getPerishableItems(), cart.getNonPerishableItems()) + shippingCost;
        biller.printBill(cart.getPerishableItems(), cart.getNonPerishableItems(), shippingCost, totalCost);
    }
}
