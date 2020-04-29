package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ReadFavicon {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://webcode.me/favicon.ico"))
                .build();

        HttpResponse<byte[]> response = client.send(request,
                HttpResponse.BodyHandlers.ofByteArray());

        byte[] data = response.body();

        int i = 0;
        for (byte c : data) {

            System.out.printf("%02x ", c);

            i++;

            if (i % 10 == 0) {

                System.out.println();
            }
        }
    }
}