/**
 * 文 件 名:  App
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  0:24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

import com.bluetop.App;
import com.bluetop.payment.core.cons.type.PayType;
import com.bluetop.payment.core.pay.domain.H5_info;
import com.bluetop.payment.core.pay.request.MicropayRequest;
import com.bluetop.payment.core.pay.request.PayQrCodeRequest;
import com.bluetop.payment.core.service.PaymentService;
import com.bluetop.payment.core.strategy.PayStrategy;
import com.bluetop.payment.core.strategy.request.PayRequest;
import com.bluetop.payment.core.strategy.response.PayResponse;
import com.bluetop.payment.core.utils.GUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/6/2 0:24
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    PaymentService paymentService;

    @Test
    public void pay() {
        PayRequest payRequest = new PayRequest();
        payRequest.setOutOrderNo(GUID.get());
        payRequest.setAmount(new BigDecimal(100));
        payRequest.setAttach("测试产品");
        payRequest.setBody("测试产品");
        payRequest.setIp("10.100.9.1");
        payRequest.setOpenId("23432432");
        payRequest.setProductName("测试产品");
        payRequest.setPayType(PayType.ALIPAY_QCODE.name());
        H5_info h5_info = new H5_info();
        h5_info.setType("JSAPI");
        h5_info.setWap_name("测试产品");
        payRequest.setH5_info(h5_info);
        PayResponse payResponse = paymentService.pay(payRequest);
        System.out.println(payResponse);
    }
}
