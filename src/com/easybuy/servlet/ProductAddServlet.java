package com.easybuy.servlet;

import com.easybuy.entity.Product;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/addOrUpdateProduct")
public class ProductAddServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String categoryLevel1Id = req.getParameter ("categoryLevel1Id");
        String categoryLevel2Id = req.getParameter ("categoryLevel2Id");
        String categoryLevel3Id = req.getParameter ("categoryLevel3Id");
        String name = req.getParameter ("name");
        String price = req.getParameter ("price");
        String stock = req.getParameter ("stock");
        String description = req.getParameter ("description");
        Part fileName = req.getPart ("photo");
        Product product =new Product ();
        if (categoryLevel1Id!=null){
            fileName.getInputStream ();
            if (fileName.getSize ()!=0){
                String cd = fileName.getHeader("Content-Disposition");
                String name1 = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
                BufferedInputStream bis = new BufferedInputStream (fileName.getInputStream ());
                BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream ("D:\\abc"+name1));
                byte[] bys = new byte[1024];
                int len;
                while ((len=bis.read (bys))!=-1){
                    bos.write (bys,0,len);
                }
                bis.close ();
                bos.close ();
                product.setFileName (name1);
            }
            product.setCategoryLevel1Id (Integer.parseInt (categoryLevel1Id));
            product.setCategoryLevel2Id (Integer.parseInt (categoryLevel2Id));
            product.setCategoryLevel3Id (Integer.parseInt (categoryLevel3Id));
            product.setName (name);
            product.setPrice (Double.valueOf (price));
            product.setStock (Integer.parseInt (stock));
            product.setDescription (description);
            if (id.length ()!=0){
                product.setId (Integer.parseInt (id));
                productService.updateProduct(product);
            }else {
                productService.addProduct(product);
            }
            req.getRequestDispatcher ("/findAllProduct").forward (req,resp);
        }
    }
}
