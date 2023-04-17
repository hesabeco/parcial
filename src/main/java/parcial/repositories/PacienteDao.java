package parcial.repositories;

import parcial.entities.Paciente;
import parcial.utils.Conexion;

public class PacienteDao extends Conexion<Paciente> implements GenericDao<Paciente> {
	public PacienteDao() {
		super(Paciente.class);
	}
}
