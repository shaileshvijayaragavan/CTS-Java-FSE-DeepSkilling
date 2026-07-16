import java.util.ArrayList;
import java.util.List;

public class FinancialForecaster {

    public double forecastNextWithMovingAverage(List<Double> history, int windowSize) {
        if (history == null || history.isEmpty()) {
            throw new IllegalArgumentException("History must not be empty.");
        }
        if (windowSize <= 0 || windowSize > history.size()) {
            throw new IllegalArgumentException("windowSize must be between 1 and history.size().");
        }

        int n = history.size();
        double sum = 0.0;
        for (int i = n - windowSize; i < n; i++) {
            sum += history.get(i);
        }
        return sum / windowSize;
    }

    public double[] forecastSeriesWithMovingAverage(List<Double> history, int windowSize, int periodsAhead) {
        List<Double> working = new ArrayList<>(history);
        double[] forecasts = new double[periodsAhead];

        for (int i = 0; i < periodsAhead; i++) {
            double next = forecastNextWithMovingAverage(working, windowSize);
            forecasts[i] = next;
            working.add(next);
        }
        return forecasts;
    }

    public double[] fitLinearRegression(List<Double> history) {
        int n = history.size();
        if (n < 2) {
            throw new IllegalArgumentException("Need at least 2 data points for linear regression.");
        }

        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
        for (int i = 0; i < n; i++) {
            double x = i;
            double y = history.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        return new double[]{slope, intercept};
    }

    public double forecastNextWithLinearRegression(List<Double> history, int periodsAhead) {
        double[] coefficients = fitLinearRegression(history);
        double slope = coefficients[0];
        double intercept = coefficients[1];

        int nextIndex = history.size() - 1 + periodsAhead;
        return slope * nextIndex + intercept;
    }

    public double[] forecastSeriesWithLinearRegression(List<Double> history, int periodsAhead) {
        double[] coefficients = fitLinearRegression(history);
        double slope = coefficients[0];
        double intercept = coefficients[1];

        double[] forecasts = new double[periodsAhead];
        int startIndex = history.size();
        for (int i = 0; i < periodsAhead; i++) {
            int x = startIndex + i;
            forecasts[i] = slope * x + intercept;
        }
        return forecasts;
    }
}
