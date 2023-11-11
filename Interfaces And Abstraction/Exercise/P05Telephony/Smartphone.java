package P10InheritanceAndAbstraction_Exercise.P05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        urls.forEach(url -> {
            sb.append(System.lineSeparator());
            if (url.matches(".*\\d+.*")) {
                sb.append("Invalid URL!");
            } else {
                sb.append(String.format("Browsing: %s!", url));
            }
        });
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(num -> {
            sb.append(System.lineSeparator());
            if (num.matches(".*[A-z]+.*")) {
                sb.append("Invalid number!");
            } else {
                sb.append(String.format("Calling... %s", num));
            }
        });
        return sb.toString();
    }
}
