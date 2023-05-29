package Hello;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Hello.LocationDetails;
import Hello.LocationDao;
import Hello.sqlDemo;
import com.google.gson.Gson;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet()
   {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		List<LocationDetails> details = new LocationDao().getLocationByCity(req.getParameterValues("city")[0]);
		
		String json = new Gson().toJson(details);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, response);
	}

}
