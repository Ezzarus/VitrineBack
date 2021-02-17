package pfe.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.api.model.Product;
import pfe.api.repository.ProductRepository;
import pfe.converter.CurrencyConverter;

import java.util.List;

@Service
@Transactional
public class ProductService {

    public static int SEUIL_ALERTE_STOCK = 10;

    @Autowired
    private ProductRepository productRepository;

    private CurrencyConverter converter = new CurrencyConverter();

    public List<Product> listAllProduct() {
        List<Product> list = productRepository.findAll();
        for (Product p : list) {
            p.setEvent(createEvent(p));
            p.setUSDPrice(converter.convert_EUR_to_USD(p.getPrice()));
        }
        return list;
    }

    public void saveProduct(Product product) {
        if (product.getPrice() > product.getMaxPrice()) {
            product.setMaxPrice(product.getPrice());
        }
        product.setUSDPrice(converter.convert_EUR_to_USD(product.getPrice()));
        productRepository.save(product);
    }

    public Product getProduct(Integer id) {
        Product product = productRepository.findById(id).get();
        product.setEvent(createEvent(product));
        product.setUSDPrice(converter.convert_EUR_to_USD(product.getPrice()));
        return product;
    }

    public void updateProduct(Product product) {
        if (product.getPrice() > product.getMaxPrice()) {
            product.setMaxPrice(product.getPrice());
        }
        product.setUSDPrice(converter.convert_EUR_to_USD(product.getPrice()));
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public void updateProductStock(Integer id) {
        Product product = productRepository.findById(id).get();
        if (product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
        } else {
            throw new RuntimeException();
        }
        productRepository.save(product);
    }

    public String createEvent (Product product) {
        String event = "";
        if (product.getMaxPrice() != product.getPrice()) {
            event += Event.PROMO.getText() + "-" + (100 - (product.getPrice()*100 / product.getMaxPrice())) + "% ! ";
        }
        if (product.getStock()<=SEUIL_ALERTE_STOCK) {
            if (product.getStock() == 0) {
                event = Event.INDISPONIBLE.getText();
            } else {
                event += Event.STOCK.getText();
            }
        }
        return event;
    }

}
