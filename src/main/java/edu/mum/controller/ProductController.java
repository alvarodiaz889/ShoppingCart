package edu.mum.controller;

import edu.mum.entity.OrderLine;
import edu.mum.entity.Product;
import edu.mum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    ProductService productService;

    //landing page
    @RequestMapping(value={"/product","/","home"})
    public String selectAll(Model model) {
        model.addAttribute("products", productService.searchAllProduct() );
        return "productList";
    }
    //working
    @RequestMapping(value="/product/details")
    public String selectOne(Model model,@RequestParam("id") int id) {
        model.addAttribute("product", productService.getProduct(id));
        return "productDetails";
    }
    @RequestMapping(value="/product/update")
    public String updateByID(Model model,@RequestParam("productId") int productId){
        model.addAttribute("product",productService.getProduct(productId));
        return "productCreate";

    }

    @RequestMapping(value="/product/update", method = RequestMethod.POST)
    public String updateProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/table";
    }
    @RequestMapping(value="/product/delete",method = RequestMethod.POST)
    public String delete(int productId){
        productService.deleteProduct(productId);
        return "redirect:/product/table";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchByName(Model model, String productName){
        List<Product> products = productService.findByProductName(productName);
        for(Product product : products){
            System.out.println(product.getProductName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }
        model.addAttribute("products",productService.findByProductName(productName));
        return "searchResult";
    }


    @RequestMapping("/product/create")
    public String createProduct(Model model){
        model.addAttribute("product",new Product());
        return "productCreate";
    }

    @RequestMapping(value="/product/save", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/table";
    }

    @RequestMapping("/product/table")
    public String adminProductTable(Model model){
        List<Product> productList = productService.searchAllProduct();
        model.addAttribute("products", productList);
        return "productTableList";
    }

    @PostMapping(value="/product/addToCart")
    public String productTiles(@RequestParam("productId") int id, @RequestParam("quantity") int quantity,
                               HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("orderLines");
        if(orderLines == null)
        {
            orderLines = new ArrayList<>();
        }
        Product p = productService.getProduct(id);
        OrderLine ol = new OrderLine();
        ol.setQuantity(quantity);
        ol.setProduct(p);
        orderLines.add(ol);
        session.setAttribute("orderLines",orderLines);
        int sum = 0;

        return "redirect:/order/create";
}

}












