package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = leia.nextLine();

		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = leia.nextLine();
		System.out.print("Level: ");
		String workerLevel = leia.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = leia.nextDouble();

		// intanciou um novo objeto worker associado aos dados inseridos e assossiado a
		// outro objeto Department
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int n = leia.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(leia.next());
			System.out.print("Value per hour: ");
			double valuePerHour = leia.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = leia.nextInt();
			//intanciando o contrato
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			//associando o contrato ao trabalhador
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = leia.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));//recorta a string gerando uma substring com 2 digitos
		int year = Integer.parseInt(monthAndYear.substring(3));//recirtando chega aprtir da posição 3 que chega no ano
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		leia.close();
	}

}
