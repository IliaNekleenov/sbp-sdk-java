package raiffeisen.sbp.sdk;

import org.junit.Test;
import raiffeisen.sbp.sdk.client.SbpClient;
import raiffeisen.sbp.sdk.model.Response;
import raiffeisen.sbp.sdk.model.in.RefundStatus;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefundInfoTest {

    private static final String SECRET_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJzdWIiOiJNQTAwMDAwMDA1NTIiLCJqdGkiOiI0ZDFmZWIwNy0xZDExLTRjOWEtYmViNi" +
            "1kZjUwY2Y2Mzc5YTUifQ.pxU8KYfqbVlxvQV7wfbGpsu4AX1QoY26FqBiuNuyT-s";

    private static SbpClient client = new SbpClient(SbpClient.TEST_DOMAIN, SECRET_KEY);

    @Test
    public void refundInfoTest() throws IOException {

        RefundStatus response = client.getRefundInfo(getRefundId());

        assertEquals("SUCCESS", response.getCode());
        // more checks

    }

    private static String getRefundId() {
        return UUID.randomUUID().toString();
    }
}
