package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComicBooksList;

/**
 * Servlet implementation class editComicServlet
 */
@WebServlet("/editComicServlet")
public class EditComicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditComicServlet() {
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
		ComicBooksListHelper dao = new ComicBooksListHelper();
		String publisher = request.getParameter("publisher");
		String seriesTitle = request.getParameter("seriesTitle");
		String issueNum = request.getParameter("issueNum");
		String author = request.getParameter("author");
		String illustrator = request.getParameter("illustrator");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ComicBooksList comicToEdit = dao.searchForComicById(tempId);
		comicToEdit.setPublisher(publisher);
		comicToEdit.setSeriesTitle(seriesTitle);
		comicToEdit.setIssueNum(issueNum);
		comicToEdit.setAuthor(author);
		comicToEdit.setIllustrator(illustrator);
		dao.updateComics(comicToEdit);
		getServletContext().getRequestDispatcher("/viewAllComicsServlet").forward(request, response);
	}

}
