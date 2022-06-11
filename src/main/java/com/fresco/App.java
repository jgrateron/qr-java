package com.fresco;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class App {

	public static void main(String[] args) {

		try {
			var qr = generateQRCodeImage("https://twitter.com/jgrateron", 450, 450, Color.BLUE, Color.WHITE);
			ImageIO.write(qr, "png", new File("mitwitter.png"));

			qr = generateQRCodeImage("https://github.com/jgrateron/qr-java", 450, 450, new Color(45, 87, 44), Color.WHITE);
			ImageIO.write(qr, "png", new File("migithub.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage generateQRCodeImage(String barcodeText, int width, int height, Color onColor, Color offColor) throws Exception {
		QRCodeWriter barcodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, width, height,
				Map.of(EncodeHintType.MARGIN, "2"));

		return MatrixToImageWriter.toBufferedImage(bitMatrix, new MatrixToImageConfig(onColor.getRGB(), offColor.getRGB()));
	}

}
