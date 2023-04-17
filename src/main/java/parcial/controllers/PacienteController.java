package parcial.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parcial.entities.Paciente;
import parcial.repositories.PacienteDao;


@WebServlet("/")
public class PacienteController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = (request.getParameter("fechanacimiento"));
	    DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	    Date fecha = null;
		try {
			fecha = (Date) formatoFecha.parse(fechanacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String telefono = request.getParameter("telefono");
	    String direccion = request.getParameter("direccion");
	    String peso = request.getParameter("peso");
	    BigDecimal pesopar = new BigDecimal(peso);
	    String estatura = request.getParameter("estatura");
	    BigDecimal estaturapar = new BigDecimal(estatura);
		Paciente paciente = new Paciente();
		paciente.setDocumento(documento);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setEmail(email);
		paciente.setGenero(genero);
		paciente.setFechanacimiento(fecha);
		paciente.setTelefono(telefono);
		paciente.setDireccion(direccion);
		paciente.setPeso(pesopar);
		paciente.setEstatura(estaturapar);

		PacienteDao cDao = new PacienteDao();
		cDao.insert(paciente);
		response.sendRedirect("list");
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		PacienteDao cDao = new PacienteDao();
		request.setAttribute("cdao", cDao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		PacienteDao cDao = new PacienteDao();
		Paciente paciente = cDao.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("paciente", paciente); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		//request.getRequestDispatcher("/user-form.jsp").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
    	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PacienteDao cDao = new PacienteDao();
		int idTxt =Integer.valueOf(request.getParameter("id"));
		Paciente paciente = cDao.find(idTxt);
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = (request.getParameter("fechanacimiento"));
	    DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	    Date fecha = null;
		try {
			fecha = (Date) formatoFecha.parse(fechanacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String telefono = request.getParameter("telefono");
	    String direccion = request.getParameter("direccion");
	    String peso = request.getParameter("peso");
	    BigDecimal pesopar = new BigDecimal(peso);
	    String estatura = request.getParameter("estatura");
	    BigDecimal estaturapar = new BigDecimal(estatura);
		
	    paciente.setDocumento(documento);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setEmail(email);
		paciente.setGenero(genero);
		paciente.setFechanacimiento(fecha);
		paciente.setTelefono(telefono);
		paciente.setDireccion(direccion);
		paciente.setPeso(pesopar);
		paciente.setEstatura(estaturapar);
		cDao.update(paciente);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PacienteDao cDao = new PacienteDao();
		int idTxt =Integer.valueOf(request.getParameter("id"));
		Paciente paciente = cDao.find(idTxt);
		cDao.delete(paciente);
		response.sendRedirect("list");
	}

}
