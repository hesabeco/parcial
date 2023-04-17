package parcial.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import parcial.entities.Paciente;
import lombok.Data;
@Entity
@Data
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="paciente_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_id_seq")
	private int id;
	private String documento;
	private String nombre;
	private String apellido;
	private String email;
	private String genero;
	private Date   fechanacimiento;
	private String telefono;
	private String direccion;
	private BigDecimal peso;
	private BigDecimal estatura;
	@Transient
	private BigDecimal imc;
	@Transient
	private String nivelpeso;
	
	public BigDecimal obtenerIMC() {
		imc = peso.divide(estatura.multiply(estatura), 2, BigDecimal.ROUND_HALF_UP);
		return imc;
	}
}
