package pl.waw.sgh;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloader {

    public static void download(String url, String fileName) throws IOException {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }

    public static void main(String[] args) throws IOException {
        //download("https://query1.finance.yahoo.com/v7/finance/download/MSFT?period1=1539514461&period2=1542196461&interval=1d&events=history&crumb=IlQIFCSo5vE","MSFT.csv");
        download("https://stooq.pl/q/d/l/?s=msft.us&i=d", "c:\\temp\\MSFT.csv");
    }
}
