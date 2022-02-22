package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComicBooksList;

/**
 * Servlet implementation class NavagationServlet
 */
@WebServlet("/navagationServlet")
public class NavagationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavagationServlet() {
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
		ComicBooksListHelper dao = new ComicBooksListHelper();
		String act = request.getParameter("doThisToComic");
	
		String path = "/viewAllComicsServlet";
		if (act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ComicBooksList comicToDelete = dao.searchForComicById(tempId);
			dao.deleteAComic(comicToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a comic");
				}
		
		} else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ComicBooksList comicToEdit = dao.searchForComicById(tempId);
			request.setAttribute("comicToEdit", comicToEdit);
			path = "/edit-comic.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a comic");
				}
			
		} else if (act.equals("add")) {
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		}

}
