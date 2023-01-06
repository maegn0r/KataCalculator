class CalculationHelper {

    public static String parseAndCalc(String line) {
        String result = null;

        if (line.contains("/")) {
            String[] arr = line.split("/");
            int div = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
            result = Integer.toString(div);
        }

        if (line.contains("+")) {
            String[] arr = line.split("\\+");
            int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            result = Integer.toString(sum);
        }

        if (line.contains("-")) {
            String[] arr = line.split("-");
            int dif = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
            result = Integer.toString(dif);
        }

        if (line.contains("*")) {
            String[] arr = line.split("\\*");
            int multi = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
            result = Integer.toString(multi);
        }
        return result;
    }
}
