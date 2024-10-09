import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NetworkDeviceCounter {

    public static void main(String[] args) {
        try {
            // Execute the command to list devices
            ProcessBuilder processBuilder = new ProcessBuilder("arp", "-a");
            Process process = processBuilder.start();

            // Read the output from the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int deviceCount = 0;

            // Count the number of lines in the output
            while ((line = reader.readLine()) != null) {
                // Check if the line contains a device entry (skip empty lines)
                if (!line.trim().isEmpty()) {
                    deviceCount++;
                }
            }

            // Wait for the process to complete
            process.waitFor();

            // Output the result
            System.out.println("Number of devices on the network: " + deviceCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
