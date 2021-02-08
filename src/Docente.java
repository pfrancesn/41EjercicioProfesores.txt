
public class Docente {
	private int id;
	private String nombre;
	private String curso;
	private String horario;
	private String jefe;

	public Docente() {
		super();
	}

	public Docente(int id, String nombre, String curso, String horario, String jefe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.horario = horario;
		this.jefe = jefe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", horario=" + horario + ", jefe="
				+ jefe + "]";
	}

}
