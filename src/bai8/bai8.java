package bai8;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.*;

public class bai8 {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<String> files = List.of(
                "D://week5//src//bai8//file1.txt",
                "D://week5//src//bai8//file2.txt",
                "D://week5//src//bai8//file3.txt"
        );
        String keyword = "khoa";

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<Integer>> results;

        try {
            results = executor.invokeAll(files.stream()
                    .map(file -> new SearchTask(file, keyword))
                    .toList());

            executor.shutdown();

            int totalOccurrences = 0;
            for (Future<Integer> result : results) {
                totalOccurrences += result.get();
            }

            System.out.println("Tổng số lần xuất hiện của \"" + keyword + "\": " + totalOccurrences);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class SearchTask implements Callable<Integer> {
        private final String filePath;
        private final String keyword;

        public SearchTask(String filePath, String keyword) {
            this.filePath = filePath;
            this.keyword = keyword;
        }

        @Override
        public Integer call() {
            int count = 0;
            try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                for (String line : lines) {
                    count += (line.split("\\b" + keyword + "\\b", -1).length - 1);
                }
                System.out.println("File " + filePath + " có " + count + " lần xuất hiện.");
            } catch (IOException e) {
                System.err.println("Lỗi đọc file " + filePath);
            }
            return count;
        }
    }
}
