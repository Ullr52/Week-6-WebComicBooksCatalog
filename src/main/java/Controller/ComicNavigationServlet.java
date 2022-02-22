package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComicBooksList;
import model.WantListDetails;

/**
 * Servlet implementation class ComicNavigationServlet
 */
@WebServlet("/comicNavigationServlet")
public class ComicNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComicNavigationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		WantListDetailsHelper dao = new WantListDetailsHelper();
		String act = request.getParameter("doThisToComic");

		if (act == null) {
		
			getServletContext().getRequestDispatcher("/viewAllCustomerLists").forward(request, response);

		}else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				WantListDetails comicListToDelete = dao.searchForComicById(tempId);
				dao.deleteComicList(comicListToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllCustomerLists").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				WantListDetails custListToEdit = dao.searchForComicById(tempId);
				request.setAttribute("custListToEdit", custListToEdit);
				request.setAttribute("month", custListToEdit.getTripDate().getMonthValue());
				request.setAttribute("date", custListToEdit.getTripDate().getDayOfMonth());
				request.setAttribute("year", custListToEdit.getTripDate().getYear());
				
				ComicBooksListHelper daoForComics = new ComicBooksListHelper();
				
				request.setAttribute("showAllComics", daoForComics.showAllComics());
							
				if(daoForComics.showAllComics().isEmpty()){
						request.setAttribute("showAllComics", " ");
				}
				getServletContext().getRequestDispatcher("/edit-comic-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllCustomerLists").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-comic-list.jsp").forward(request, response);
		}
		
		
}
}
