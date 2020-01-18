package com.qding.eyecloud.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 一句话功能简述;
 * 功能详细描述;
 * @Since [产品/模块版本]
 * @Author tanshen@qding.me
 * @Version v1.0
 * @Date:2019/12/30 17:01
 */
public class Image2String {

    public static void createAsciiPic(final String path) {
        //final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        final String base = "KSPksp;.";
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            System.out.println("W:"+image.getWidth()+" H:"+image.getHeight());
            for (int y = 0; y < image.getHeight(); y += 16) {
                for (int x = 0; x < image.getWidth(); x += 12) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);

                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args []){
        Image2String.createAsciiPic("E://img.jpg");
    }

}
