import java.io.IOException;

import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class SendReq {
	public static void sendReq(String info, String post) throws IOException {
		Request.Post("http://localhost:8081/").useExpectContinue()
        .version(HttpVersion.HTTP_1_1)
        .bodyString(info, ContentType.DEFAULT_TEXT)
        .execute().returnContent().asBytes();

	}
}
