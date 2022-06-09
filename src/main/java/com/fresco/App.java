package com.fresco;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class App {

	public static void main(String[] args) {

		try {
			ImageIO.write(generateQRCodeImage("https://twitter.com/jgrateron", 400, 400), "png",
					new File("mitwitter.png"));

			ImageIO.write(generateQRCodeImage("https://github.com/jgrateron/qr-java", 400, 400), "png",
					new File("migithub.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage generateQRCodeImage(String barcodeText, int width, int height) throws Exception {
		QRCodeWriter barcodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, width, height,
				Map.of(EncodeHintType.MARGIN, "1"));

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
