package edu.mum.controller;

import edu.mum.entity.OrderLine;
import edu.mum.entity.Product;
import edu.mum.entity.ProductType;
import edu.mum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value="/products")
    public String selectAll(Model model) {
        model.addAttribute("products", productService.searchAllProduct() );
        return "productList";
    }

    @RequestMapping(value="/products/details")
    public String selectone(Model model,@RequestParam("id") int id) {
        model.addAttribute("product", productService.getProduct(id));
        return "productDetails";
    }
    @RequestMapping(value="/product6")
    public String searchID(Model model,@RequestParam("id") int id){
        model.addAttribute("product",productService.getProduct(id));
        return "productpage6";

    }

    @RequestMapping(value="/products/savedproducts", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";

    }

    @RequestMapping(value="/products/delete",method = RequestMethod.POST)
    public String deleteit(int productId){
        // int id = Integer.parseInt(input);
        //Product p = productService.getProduct(product.getProductId());
        productService.deleteProduct(productId);
        return "redirect:/products";
    }

    @RequestMapping(value="/productTiles")
    public String productTiles(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("orderLines");
        if(orderLines == null)
        {
            orderLines = new ArrayList<>();
        }
        for(int i=0;i<5;i++)
        {
            Product p = new Product(12,i, ProductType.AUDIO,"Product " + i,null);
            OrderLine ol = new OrderLine();
            ol.setProduct(p);
            ol.setQuantity(i);
            orderLines.add(ol);
        }
        session.setAttribute("orderLines",orderLines);
        return "redirect:/order/create";

    }
}












