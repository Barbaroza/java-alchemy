package com.pmb.code.bitwise;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class FindMedian extends Application {
    private static final String FILE_ROOT_PATH = System.getProperty("user.dir");
    private static final String FILE_NAME_PREFIX = "median";
    private static final int SIZE = 4 * 1024 * 1024;
    private Random random = new Random();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            int numSize = 1000000000;
            RandomAccessFile baf = new RandomAccessFile(FILE_ROOT_PATH + File.separator + FILE_NAME_PREFIX, "rw");
            FileChannel channel = baf.getChannel();
            ByteBuffer direct = ByteBuffer.allocateDirect(SIZE);
            generateRandomNumFile(channel, direct, numSize);

            int batchSize = numSize / 100;

            for (int count = 0; count < 100; count++) {
                channel.position(0);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeRandomNum(FileChannel fileChannel, ByteBuffer byteBuffer, int size) throws IOException {
        for (int count = 0; count < size && count < byteBuffer.capacity(); count++) {
            byteBuffer.putInt(random.nextInt(Integer.MAX_VALUE));
        }

        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        byteBuffer.clear();
    }


    private int[] read(FileChannel channel, ByteBuffer byteBuffer) throws IOException {
        int[] res = new int[SIZE >> 2];
        channel.read(byteBuffer);
        byteBuffer.flip();
        for (int count = 0; count < SIZE / 4 && byteBuffer.remaining() > 0; count++) {
            res[count] = byteBuffer.getInt();
        }
        byteBuffer.clear();
        return res;
    }


    private FileChannel generateRandomNumFile(FileChannel channel, ByteBuffer byteBuffer, int numSize) throws IOException {

        int bufferSize = SIZE / 4;
        int remainder = numSize & bufferSize >> 1;
        int minRound = numSize / (bufferSize);
        int total = remainder == 0 ? minRound : minRound + 1;
        long start = System.currentTimeMillis();
        for (int round = 0; round < total; round++) {
            boolean lastRound = round == total - 1;
            int writeSize = lastRound && remainder != 0 ? remainder : bufferSize;
            writeRandomNum(channel, byteBuffer, writeSize);
        }

        long end = System.currentTimeMillis();

        System.out.println(byteBuffer.getClass().getName() + "cost:" + (end - start));

        return channel;
    }
}
