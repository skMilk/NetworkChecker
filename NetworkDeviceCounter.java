import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NetworkDeviceCounter {

    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("arp", "-a");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int deviceCount = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    deviceCount++;
                }
            }

            process.waitFor();

            System.out.println("Number of devices on the network: " + deviceCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

