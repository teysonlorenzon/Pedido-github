package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import entidades.enums.OrderStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Client ct = new Client();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");

		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.next());

		Client client = new Client(name, email, data);

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

		System.out.print("How many items to this orde? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();

			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			OrderItem item = new OrderItem(quantityProduct, priceProduct, new Product(nameProduct, priceProduct));
			order.addItem(item);

		}

		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(order);

		sc.close();

	}

}
