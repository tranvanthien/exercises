package bai7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;

public class FileReadTask implements Runnable {
    private final String filePath;
    private final long start;
    private final long end;
    private final int partIndex;
    private final ConcurrentHashMap<Integer, String> contentMap;

    public FileReadTask(String filePath, long start, long end, int partIndex, ConcurrentHashMap<Integer, String> contentMap) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
        this.partIndex = partIndex;
        this.contentMap = contentMap;
    }

    @Override
    public void run() {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            file.seek(start);
            byte[] buffer = new byte[(int) (end - start)];
            file.read(buffer);
            contentMap.put(partIndex, new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
