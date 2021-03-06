package qmw.sell.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qmw.sell.dao.ProductInfoRepository;
import qmw.sell.dataobject.ProductInfo;
import qmw.sell.enums.ProductStatusEnum;
import qmw.sell.service.ProductService;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {


        Optional<ProductInfo> byId = repository.findById(productId);
        ProductInfo productInfo = byId.get();

        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {

        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll( pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
