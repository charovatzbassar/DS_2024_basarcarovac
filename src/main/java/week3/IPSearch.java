package week3;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        int low = 0;
        int high = ipAddresses.length - 1;

        String[] octets = ipAddress.split("\\.");

        long w = Long.parseLong(octets[0]);
        long x = Long.parseLong(octets[1]);
        long y = Long.parseLong(octets[2]);
        long z = Long.parseLong(octets[3]);

        long ipNumber = 16777216 * w + 65536 * x + 256 * y + z;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (ipNumber >= ipAddresses[middle].getStartIp() && ipNumber <= ipAddresses[middle].getEndIp()) {
                return ipAddresses[middle];
            } else if (ipNumber < ipAddresses[middle].getStartIp()) {
                high = middle - 1;
            } else if (ipNumber > ipAddresses[middle].getEndIp()) {
                low = middle + 1;
            }

        }

        return null;
    }
}
