import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		String path = "Profesores.txt";

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
	}

	private static void readFile(ArrayList<Docente> docentes, String path) {
		// TODO Auto-generated method stub
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			try {
				line = br.readLine();
				while (line != null) {
					String[] attributes = line.split("\\|");
					Docente docente = new Docente(Integer.parseInt(attributes[0]), attributes[1], attributes[2],
							attributes[4], attributes[6]);
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

}
