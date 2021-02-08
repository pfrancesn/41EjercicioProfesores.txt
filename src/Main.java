import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		String path = "Profesores.txt";
		int opc = 0;
		do {
			System.out.print("1. Listado de datos de profesores (Realizado en le v1.0)\r\n" + 
					"2. Genera un archivo de txt con la información de los\r\n" + 
					"profesores que impartan clase en alguno de sus\r\n" + 
					"horario de 15:00 a 18:00. El archivo se llamará\r\n" + 
					"profes36.txt\r\n" + 
					"3. Genera un archivo de txt con la información de los\r\n" + 
					"profesores que impartan clase en alguno de sus\r\n" + 
					"horario , en un horario pedido al usuario por teclado. El archico se llamará\r\n" + 
					"profesHorario.txt\r\n" + 
					"4. Genera un archivo de texto con únicamente los horario de las clases que sean de una\r\n" + 
					"disciplina pedida al usuario por teclado, el archivo se llamará con el nombre de la\r\n" + 
					"disciplina.txt.\r\n" + 
					"5. Realiza el punto 3 del ejercicio pero esta vez poniendo como carácter separador de\r\n" + 
					"cada campo el siguiente: ||”|:\r\n" + 
					"Opcion: ");
			opc = sn.nextInt();
			switch (opc) {
			case 1:
				readFile(docentes, path);
				for (int i = 0; i < docentes.size(); i++) {
					System.out.println("Docente " + (i + 1) + ":");
					System.out.println("ID: " + docentes.get(i).getId());
					System.out.println("Nombre: " + docentes.get(i).getNombre());
					System.out.println("Curso: " + docentes.get(i).getCurso());
					System.out.println("Horario del curso: " + docentes.get(i).getHorario());
					System.out.println("Jefe: " + docentes.get(i).getJefe());
					System.out.println();
				}
				break;
			case 2:
				createProfe36(docentes);
				break;
			case 3:
				System.out.print("Introduce un horario(hh:mm a hh:mm): ");
				String horario = sc.nextLine();
				createProfesHorario(docentes, horario);
				break;
			default:
				break;
			}
		} while (opc!=0);


		
		
	}

	public static void readFile(ArrayList<Docente> docentes, String path) {
		// TODO Auto-generated method stub
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			try {
				line = br.readLine();
				while (line != null) {
					String[] attributes = line.split("\\|");
					Docente docente = new Docente(Integer.parseInt(attributes[0]), attributes[1], attributes[2],
							attributes[4] + " y " + attributes[5], attributes[6]);
					docentes.add(docente);
					line = br.readLine();
				}
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createProfe36(ArrayList<Docente> docentes) {
		File file = new File("profes36.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < docentes.size(); i++) {
				String horarios[] = docentes.get(i).getHorario().split(" y ");
				if (horarios[0].contentEquals("15:00 A 18:00") || horarios[1].contentEquals("15:00 A 18:00")) {
					line = docentes.get(i).getId() + "|" + docentes.get(i).getNombre() + "|"
							+ docentes.get(i).getCurso() + "|" + docentes.get(i).getHorario() + "|"
							+ docentes.get(i).getJefe();
					bw.write(line);
					bw.newLine();
				}
				bw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createProfesHorario(ArrayList<Docente> docentes, String horario) {
		// TODO Auto-generated method stub
		File file = new File("profesHorario.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
			for (int i = 0; i < docentes.size(); i++) {
				String horarios[] = docentes.get(i).getHorario().split(" y ");
				if (horarios[0].contentEquals(horario) || horarios[1].contentEquals(horario)) {
					line = docentes.get(i).getId() + "|" + docentes.get(i).getNombre() + "|"
							+ docentes.get(i).getCurso() + "|" + docentes.get(i).getHorario() + "|"
							+ docentes.get(i).getJefe();
					bw.write(line);
					bw.newLine();
				}
				bw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
