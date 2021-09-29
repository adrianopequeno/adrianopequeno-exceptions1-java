package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import main.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("N�mero do quarto: ");
		int number = sc.nextInt();
		
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de sa�da (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error na reserva: A data de sa�da tem que ser superior a data de entrada");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservas: " + reservation);
			
			System.out.println();
			System.out.println("Entre com a atualiza�ao da reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de sa�da (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error na reserva: A datas de atualiza�ao das reservas nao pode ser no passado!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error na reserva: A data de sa�da tem que ser superior a data de entrada");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservas: " + reservation);
			}
			
		}
		
		sc.close();

	}

}
