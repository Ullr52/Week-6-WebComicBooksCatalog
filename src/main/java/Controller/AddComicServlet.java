package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComicBooksList;

/**
 * Servlet implementation class AddComicServlet
 */
@WebServlet("/addComicServlet")
public class AddComicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String publisher = request.getParameter("publisher");
		String seriesTitle = request.getParameter("seriesTitle");
		String issueNum = request.getParameter("issueNum");
		String author = request.getParameter("author");
		String illustrator = request.getParameter("illustrator");
		ComicBooksList lc = new ComicBooksList(publisher, seriesTitle, issueNum, author, illustrator);
		ComicBooksListHelper dao = new ComicBooksListHelper();
		dao.insertComic(lc);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
