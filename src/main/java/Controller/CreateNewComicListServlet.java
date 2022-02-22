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
 * Servlet implementation class CreateNewComicListServlet
 */
@WebServlet("/createNewComicListServlet")
public class CreateNewComicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewComicListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ComicBooksListHelper cblh = new ComicBooksListHelper();
		String custListName = request.getParameter("custListName");
		System.out.println("Comic List Name: " + custListName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String customerName = request.getParameter("customerName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedComics = request.getParameterValues("allComicsToAdd");
		List<ComicBooksList> selectedComicsInList = new ArrayList<ComicBooksList>();
		
		if(selectedComics != null && selectedComics.length > 0){
			for(int i = 0; i<selectedComics.length; i++) {
				ComicBooksList c = cblh.searchForComicById(Integer.parseInt(selectedComics[i]));
				selectedComicsInList.add(c);
			}
		}
		
		Customer customer = new Customer(customerName);
		
		WantListDetails wld = new WantListDetails(custListName, ld, customer);
		
		wld.setListOfComics(selectedComicsInList);
		
		WantListDetailsHelper wldh = new WantListDetailsHelper();
		wldh.insertNewWantListDetails(wld);
		
		getServletContext().getRequestDispatcher("/viewAllComicsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
