package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComicBooksList;
import model.Customer;
import model.WantListDetails;

/**
 * Servlet implementation class EditCustomerListDetailsServlet
 */
@WebServlet("/editCustomerListDetailsServlet")
public class EditCustomerListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WantListDetailsHelper dao = new WantListDetailsHelper();
		ComicBooksListHelper cblh = new ComicBooksListHelper();
		CustomerHelper ch = new CustomerHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		WantListDetails listToUpdate = dao.searchForComicById(tempId);

		String newCustomerListName = request.getParameter("custListName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
		//find our add the new shopper
		Customer newCustomer = ch.findCustomer(customerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
		
			String[] selectedComics = request.getParameterValues("allComicsToAdd");
			List<ComicBooksList> selectedComicInList = new ArrayList<ComicBooksList>();

			for (int i = 0; i < selectedComics.length; i++) {
				System.out.println(selectedComics[i]);
				ComicBooksList c = cblh.searchForComicById(Integer.parseInt(selectedComics[i]));
				selectedComicInList.add(c);

			}
			listToUpdate.setListOfComics(selectedComicInList);
		} catch (NullPointerException ex) {
		
			List<ComicBooksList> selectedComicsInList = new ArrayList<ComicBooksList>();
			listToUpdate.setListOfComics(selectedComicsInList);
		}

		listToUpdate.setcustListName(newCustomerListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setCustomer(newCustomer);

		dao.updateCustomerList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllCustomersServlet").forward(request, response);
	}

}
