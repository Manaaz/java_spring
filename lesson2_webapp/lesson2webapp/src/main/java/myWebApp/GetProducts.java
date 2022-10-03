package myWebApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "GetProducts", urlPatterns = "/get_products.html")
public class GetProducts extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(GetProducts.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Log: GET");
        String htmlTextProducts = getFirst10ProductsString();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); //.printf("<html><body><h1>New GET request</h1></body></html>");
        out.printf("<html><body><h1>Catalog:</h1><br>" + htmlTextProducts + "</body></html>");
        out.close();
    }

    @Override
    public void destroy() {
        logger.info("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.info("Init");
    }

    private String getFirst10ProductsString() {

        String result = "";
        List<Product> productList = getProductList();

        for(int i = 0; i<10; i++) {
            String productString = productList.get(i).productToString();
            result += productString + "<br>";
        }

        return result;

    }

    private List<Product> getProductList() {

        List<Product> productList = new ArrayList<>();

        for(int i = 0; i<10; i++) {
            String stringId = Integer.toString(i);
            Product product = new Product(stringId,"product " + stringId,100.50);
            productList.add(product);
        }

        return productList;

    }
}
