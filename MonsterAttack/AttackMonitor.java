package Lab3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class AttackMonitor {
	public List<MonsterAttack> monsterAttacks = new ArrayList<MonsterAttack>();

	public void monitor() {

		String[] choices = { "Quit", "Input Information on a MonsterAttack", "Show Current List",
				"Delete attack from list", "Copy File", "Read File" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "(Main Menu)", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE,
					null, choices, "null");
			switch (choice) {
			case 1:
				if (!(monsterAttacks.isEmpty()) || monsterAttacks.isEmpty())
					addAttack();
				break;
			case 2:
				if (!(monsterAttacks.isEmpty()))
					listMonsterAttack();
				break;
			case 3:
				if (!(monsterAttacks.isEmpty()))
					deleteAttack();
				break;
			case 4:
				if (!(monsterAttacks.isEmpty()))
					try {
						saveFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				break;
			case 5:
				if (!(monsterAttacks.isEmpty()))
					try {
						readFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		} while (choice != 0);
	}

	public void addAttack() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the id of the Monster"));
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the day"));
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the month"));
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the year"));
		String nameOfMonster = JOptionPane.showInputDialog("Please enter the name of the Monster");
		String locationOfAttack = JOptionPane.showInputDialog("Please enter the location of the attack");
		int numOfVictims = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of victims"));
		monsterAttacks.add(new MonsterAttack(id, day, month, year, nameOfMonster, locationOfAttack, numOfVictims));
	}

	public void listMonsterAttack() {
		StringBuilder sb = new StringBuilder(monsterAttacks.toString());
		if (monsterAttacks.isEmpty())
			sb.append("None");
		else
			for (int i = 0; i < monsterAttacks.size(); i++)
				JOptionPane.showMessageDialog(null, sb);
	}

	public void deleteAttack() {
		int userInput = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Please enter the id number you would like to delete"));
		for (int i = 0; i < monsterAttacks.size(); i++) {
			if (monsterAttacks.get(i).getId() == (userInput)) {
				monsterAttacks.remove(i);
			}
		}
	}

	public void saveFile() throws IOException {
		String in = JOptionPane.showInputDialog("Please enter the filepath to copy to");
		File outFile = new File(in);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < monsterAttacks.size(); i++) {
			int id = monsterAttacks.get(i).getId();
			int day = monsterAttacks.get(i).getDay();
			int month = monsterAttacks.get(i).getMonth();
			int year = monsterAttacks.get(i).getYear();
			String name = monsterAttacks.get(i).getNameOfMonster();
			String location = monsterAttacks.get(i).getLocationOfAttack();
			int numVictims = monsterAttacks.get(i).getNumOfVictims();
			writer.write(id + ",");
			sb.append(day + "/");
			sb.append(month + "/");
			sb.append(year);
			String date = sb.toString();
			writer.write(date);
			writer.write(name);
			writer.write(location);
			writer.write(numVictims + "\n");
		}
		writer.close();
	}

	public void readFile() throws IOException {
		for (int i = 0; i < monsterAttacks.size(); i++) {
			monsterAttacks.remove(i);
		}
		try {
			String input = JOptionPane.showInputDialog("Please enter the filepath to read from");
			File inFile = new File(input);
			BufferedWriter writer = new BufferedWriter(new FileWriter(inFile));
			@SuppressWarnings("unused")
			StringBuilder sb = new StringBuilder();
			Scanner reader = new Scanner(inFile);
			String line;
			String[] fields;
			int id, day, month, year, numVictims;
			String name;
			String location;
			while (reader.hasNextLine()) {
				line = reader.next();
				fields = line.split(",");
				id = Integer.parseInt(fields[0]);
				day = Integer.parseInt(fields[1]);
				month = Integer.parseInt(fields[2]);
				year = Integer.parseInt(fields[3]);
				name = fields[4];
				location = fields[5];
				numVictims = Integer.parseInt(fields[6]);
				monsterAttacks.add(new MonsterAttack(id, day, month, year, name, location, numVictims));
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			JOptionPane.showInputDialog(e);
			System.exit(1);
		}
	}

}
