import java.util.Arrays;
import java.util.List;

public class FinancialForecastingDemo {

    public static void main(String[] args) {
        List<Double> monthlyRevenue = Arrays.asList(
                120.0, 125.0, 130.0, 128.0, 135.0, 140.0,
                138.0, 145.0, 150.0, 148.0, 155.0, 160.0
        );

        FinancialForecaster forecaster = new FinancialForecaster();

        System.out.println("Historical revenue (last 12 months): " + monthlyRevenue);

        System.out.println("\nSimple Moving Average Forecast (window = 3)");
        double nextSMA = forecaster.forecastNextWithMovingAverage(monthlyRevenue, 3);
        System.out.printf("Predicted next month's revenue: $%.2fk%n", nextSMA);

        double[] smaForecast = forecaster.forecastSeriesWithMovingAverage(monthlyRevenue, 3, 4);
        System.out.println("4-month SMA forecast:");
        for (int i = 0; i < smaForecast.length; i++) {
            System.out.printf("  Month +%d: $%.2fk%n", i + 1, smaForecast[i]);
        }

        System.out.println("\nLinear Regression Forecast");
        double[] coefficients = forecaster.fitLinearRegression(monthlyRevenue);
        System.out.printf("Fitted line: revenue = %.3f * month + %.3f%n", coefficients[0], coefficients[1]);

        double nextLR = forecaster.forecastNextWithLinearRegression(monthlyRevenue, 1);
        System.out.printf("Predicted next month's revenue: $%.2fk%n", nextLR);

        double[] lrForecast = forecaster.forecastSeriesWithLinearRegression(monthlyRevenue, 4);
        System.out.println("4-month linear regression forecast:");
        for (int i = 0; i < lrForecast.length; i++) {
            System.out.printf("  Month +%d: $%.2fk%n", i + 1, lrForecast[i]);
        }
    }
}
