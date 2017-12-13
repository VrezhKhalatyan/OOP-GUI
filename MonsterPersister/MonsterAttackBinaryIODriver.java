package lab11;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class MonsterAttackBinaryIODriver {
	private static List<MonsterAttack> monsterAttacks;

	public MonsterAttackBinaryIODriver() {
		monsterAttacks = new ArrayList<MonsterAttack>();
	}

	public void outbreak() {
		String[] options = { "Quit", "List Monster_Attacks", "Add A Monster_Attack", "Save To File", "Load From File" };
		int choice = 0;
		do {
			choice = JOptionPane.showOptionDialog(null, "Next Action", "Next Action", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			switch (choice) {
			case 1:
				listMonsterAttacks();
				break;
			case 2:
				addMonsterAttack();
				break;
			case 3:
				saveToFile();
				break;
			case 4:
				loadFromFile();
				break;
			}
		} while (choice != 0);
	}

	public void listMonsterAttacks() {
		StringBuilder sb = new StringBuilder();
		for (MonsterAttack m : monsterAttacks)
			sb.append(m.toString() + "\n");
		if (sb.length() == 0)
			sb.append("There are no Monster Attacks");
		JOptionPane.showMessageDialog(null, sb);
	}

	public void addMonsterAttack() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the id of the Monster"));
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the day"));
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the month"));
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an integer for the year"));
		String nameOfMonster = JOptionPane.showInputDialog("Please enter the name of the Monster");
		String locationOfAttack = JOptionPane.showInputDialog("Please enter the location of the attack");
		int numOfVictims = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of victims"));
		monsterAttacks.add(new MonsterAttack(id, day, month, year, nameOfMonster, locationOfAttack, numOfVictims));
	}

	public void saveToFile() {
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			persister.saveListToFile(selectedFile, monsterAttacks);
		}
	}

	public void loadFromFile() {
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			monsterAttacks = persister.readListFromFile(selectedFile);
		}

	}

	public static void main(String[] args) {
		MonsterAttackBinaryIODriver mA = new MonsterAttackBinaryIODriver();
		mA.outbreak();

	}

}
