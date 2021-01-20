package jCafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetProductServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		String item = request.getParameter("item_no");
		productVO vo = new productVO();
		vo.setItemNo("bean_001");

		productDAO dao = new productDAO();
		productVO result = dao.getProduct(vo);

		String json = "{";
		json += "\"item_no\":\"" + result.getItemNo() + "\"";
		json += ",\"item\":\"" + result.getItem() + "\"";
		json += ",\"category\":\"" + result.getCategory() + "\"";
		json += ",\"price\":\"" + result.getPrice() + "\"";
		json += ",\"link\":\"" + result.getLink() + "\"";
		json += ",\"content\":\"" + result.getContent() + "\"";
		json += ",\"likeIt\":\"" + result.getLikeIt() + "\"";
		json += ",\"alt\":\"" + result.getAlt() + "\"";
		json += ",\"image\":\"" + result.getImage() + "\"";
		json += "}";

		response.getWriter().append(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
