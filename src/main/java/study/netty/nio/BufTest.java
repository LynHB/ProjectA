package study.netty.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BufTest {
    public static void main(String[] args) throws IOException {
        System.out.println("ByteBuffer test");
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put((byte) 'a');
        buffer.flip();
        System.out.println(buffer.get());

        System.out.println("MappedByteBuffer test");
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        /**
         * MappedByteBuffer 可以文件直接在内存（堆外内存）修改，操作系统不需要额外拷贝一次
         * 参数1 FileChannel.MapMode.READ_WRITE 读写模式
         * 参数2 修改的起始位置
         * 参数3 映射到内存的大小
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0, (byte) 'h');
        randomAccessFile.close();
    }
}
