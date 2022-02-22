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
 * Servlet implementation class EditComicListServlet
 */
@WebServlet("/editComicListServlet")
public class EditComicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditComicListServlet() {
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
		WantListDetails custListToUpdate = dao.searchForComicById(tempId);

		String custListName = request.getParameter("custListName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
	
		Customer newCustomer = ch.findCustomer(customerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
	
			String[] selectedComic = request.getParameterValues("allComicsToAdd");
			List<ComicBooksList> selectedComicsInList = new ArrayList<ComicBooksList>();

			for (int i = 0; i < selectedComic.length; i++) {
				System.out.println(selectedComic[i]);
				ComicBooksList c = cblh.searchForComicById(Integer.parseInt(selectedComic[i]));
				selectedComicsInList.add(c);

			}
			custListToUpdate.setListOfComics(selectedComicsInList);
		} catch (NullPointerException ex) {

			List<ComicBooksList> selectedComicsInList = new ArrayList<ComicBooksList>();
			custListToUpdate.setListOfComics(selectedComicsInList);
		}

		custListToUpdate.setcustListName(custListName);
		custListToUpdate.setTripDate(ld);
		custListToUpdate.setCustomer(newCustomer);

		dao.updateCustomerList(custListToUpdate);

		getServletContext().getRequestDispatcher("/viewAllCustomerLists").forward(request, response);
	}


}
