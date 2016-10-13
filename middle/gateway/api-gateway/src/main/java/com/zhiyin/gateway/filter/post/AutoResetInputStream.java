//package com.zhiyin.gateway.filter.post;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import java.io.IOException;
//
//public class AutoResetInputStream extends ServletInputStream {
//
//    private byte[] data;
//    private int idx = 0;
//
//    public AutoResetInputStream(byte[] data) {
//        if (data == null)
//            data = new byte[0];
//        this.data = data;
//    }
//
//    @Override
//    public int read() throws IOException {
//        if (idx == data.length)
//            return -1;
//    }
//
//    @Override
//    public synchronized void reset() throws IOException {
//        idx = 0;
//    }
//
////    @Override
////    public boolean isFinished() {
////        return false;
////    }
////
////    @Override
////    public boolean isReady() {
////        return false;
////    }
////
////    @Override
////    public void setReadListener(ReadListener listener) {
////
////    }
//}