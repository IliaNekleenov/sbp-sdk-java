package raiffeisen.sbp.sdk;

import org.junit.Test;
import raiffeisen.sbp.sdk.client.SbpClient;
import raiffeisen.sbp.sdk.model.Response;
import raiffeisen.sbp.sdk.model.in.RefundStatus;
import raiffeisen.sbp.sdk.model.out.QRId;
import raiffeisen.sbp.sdk.model.out.RefundInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RefundPaymentTest {

    private static final String SECRET_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJzdWIiOiJNQTAwMDAwMDA1NTIiLCJqdGkiOiI0ZDFmZWIwNy0xZDExLTRjOWEtYmViNi" +
            "1kZjUwY2Y2Mzc5YTUifQ.pxU8KYfqbVlxvQV7wfbGpsu4AX1QoY26FqBiuNuyT-s";

    private static SbpClient client = new SbpClient(SbpClient.TEST_DOMAIN, SECRET_KEY);

    @Test
    public void refundPaymentStaticTest() throws IOException {
        RefundInfo refundInfo = RefundInfo.creator().
                amount(new BigDecimal(100)).
                order(getOrderInfo()).
                refundId(getRefundId()).
                transactionId(getTransactionId()).
                create();

        RefundStatus response = client.refundPayment(refundInfo);

        assertNotEquals("SUCCESS", response.getCode());
        //more checks

    }

    @Test
    public void refundPaymentDynamicTest() throws IOException {
        RefundInfo refundInfo = RefundInfo.creator().
                amount(new BigDecimal(100)).
                order(getOrderInfo()).
                refundId(getRefundId()).
                transactionId(getTransactionId()).
                create();

        RefundStatus response = client.refundPayment(refundInfo);

        assertNotEquals("SUCCESS", response.getCode());
        //more checks
    }

    private String getOrderInfo() {
        return UUID.randomUUID().toString();
    }

    private String getRefundId() {
        return UUID.randomUUID().toString();
    }

    private long getTransactionId() {
        return new Random().nextLong();
    }
}
