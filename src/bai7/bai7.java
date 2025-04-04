package bai7;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;

public class bai7 {
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB mỗi đoạn
    private static final String FILE_PATH = "D://week5//src//bai7//largefile.txt";
    private static final String OUTPUT_FILE = "D://week5//src//bai7//output.txt";
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        ConcurrentHashMap<Integer, String> contentMap = new ConcurrentHashMap<>();

        try (RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r")) {
            long fileSize = file.length();
            long chunkSize = fileSize / NUM_THREADS;

            for (int i = 0; i < NUM_THREADS; i++) {
                long start = i * chunkSize;
                long end = (i == NUM_THREADS - 1) ? fileSize : (i + 1) * chunkSize;
                executor.execute(new FileReadTask(FILE_PATH, start, end, i, contentMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ghép nội dung đúng thứ tự và ghi ra file
        mergeAndWriteFile(contentMap);
    }

    private static void mergeAndWriteFile(ConcurrentHashMap<Integer, String> contentMap) {
        List<Integer> keys = new ArrayList<>(contentMap.keySet());
        Collections.sort(keys);

        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            for (int key : keys) {
                writer.write(contentMap.get(key));
            }
            System.out.println("File đã được ghép lại thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

